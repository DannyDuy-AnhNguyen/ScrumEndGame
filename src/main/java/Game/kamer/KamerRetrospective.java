package Game.kamer;

import Game.antwoord.Antwoord;
import Game.core.Speler;
import Game.core.Status;

import java.util.Scanner;

public class KamerRetrospective extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Status status;
    private boolean introGetoond = false;  // Zorg dat intro maar 1x getoond wordt

    public KamerRetrospective(Antwoord antwoordStrategie) {
        super("Sprint Retrospective");
        this.antwoordStrategie = antwoordStrategie;
        deur.setOpen(false); // deur standaard dicht bij start
    }

    @Override
    public void betreedIntro() {
        if (!introGetoond) {
            System.out.println();
            System.out.println("Je bent nu in de kamer: " + naam);
            deur.toonStatus();
            System.out.println();
            introGetoond = true;
        }
    }

    @Override
    public void verwerkFeedback(int huidigeVraag) {
        if (huidigeVraag == 0) {
            System.out.println("RetroSpective zorgt ervoor dat de teamleden weten wat er goed gaat, beter kan en hoe ze het kunnen verbeteren.");
        } else if (huidigeVraag == 1) {
            System.out.println("Om te weten hoe de samenwerking daadwerkelijk gaat, is het verstandig om daar 1 tot 2 weken te geven of het beste na elke sprint.");
        }
    }

    @Override
    public void verwerkOpdracht(int huidigeVraag) {
        if (huidigeVraag == 0) {
            System.out.println("Wat is het hoofddoel van de Sprint Retrospective?");
            System.out.println("a) De resultaten van het product demonstreren aan de klant.");
            System.out.println("b) De product backlog aanpassen.");
            System.out.println("c) Terugkijken op het proces en verbeteren waar mogelijk is.");
        } else if (huidigeVraag == 1) {
            System.out.println("Wanneer vindt de Sprint Retrospective plaats?");
            System.out.println("a) Aan het begin van de sprint");
            System.out.println("b) Direct na de Sprint Review, aan het einde van de sprint");
            System.out.println("c) Halverwege de Sprint");
        }
    }

    @Override
    public void verwerkResultaat(boolean correct, Speler speler) {
        if (correct) {
            speler.verhoogScore(10);
            verwerkFeedback(huidigeVraag);
            huidigeVraag++;
            System.out.println("\n✅ Correct! Je krijgt 10 punten.\n");
        } else {
            speler.voegMonsterToe("Blame Game");
            System.out.println("\n❌ Fout! Monster 'Blame Game' verschijnt! Probeer het opnieuw.\n");
        }
    }

    @Override
    public void betreed(Speler speler) {
        if (!deur.isOpen()) {
            System.out.println("🚪 De deur is gesloten, je kunt deze kamer nog niet betreden.");
            deur.toonStatus();
            return;
        }

        this.status = new Status(speler);
        Scanner scanner = new Scanner(System.in);

        // Intro slechts 1 keer tonen
        betreedIntro();

        while (huidigeVraag < 2) {
            verwerkOpdracht(huidigeVraag);

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
                System.out.println();
            } else if (antwoord.equals("status")) {
                status.update();
                System.out.println();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.\n");
                return;
            } else if (antwoord.matches("[a-d]")) {
                boolean antwoordCorrect = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
                verwerkResultaat(antwoordCorrect, speler);
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        // Na juiste beantwoording alle vragen
        setVoltooid();
        deur.setOpen(true);
        System.out.println("🎉 Je hebt alle vragen juist beantwoord! De deur gaat open.");
        speler.voegVoltooideKamerToe(2); // Pas nummer indien nodig
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        // Niet gebruikt in deze klasse
        return false;
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ 'a', 'b' of 'c' om een antwoord te kiezen.");
        System.out.println("Typ 'status' om je huidige status te zien.");
        System.out.println("Typ 'naar andere kamer' om deze kamer te verlaten.");
        System.out.println("Typ 'help' om deze hulp te tonen.");
    }
}