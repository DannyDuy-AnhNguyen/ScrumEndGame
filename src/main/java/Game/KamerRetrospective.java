package Game;

import java.util.Scanner;

public class KamerRetrospective extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Status status;

    public KamerRetrospective(Antwoord antwoordStrategie) {
        super("Sprint Retrospective");
        this.antwoordStrategie = antwoordStrategie;
        // Deur start standaard gesloten (aangenomen dat dat in Kamer constructor gebeurt)
    }

    @Override
    public void betreedIntro(){
        System.out.println();
        System.out.println("Je bent nu in de kamer: " + naam);
        deur.toonStatus();
        System.out.println();
    }

    //    De feedback die je krijgt voor elke vraag die je goed beantwoord
    @Override
    public void verwerkFeedback(int huidigeVraag) {
        if (huidigeVraag == 0) {
            System.out.println("RetroSpective zorgt ervoor dat de teamleden weten wat er goed gaat, beter kan en hoe ze het kunnen verbeteren.");
        } else if(huidigeVraag == 1){
            System.out.println("Om te weten hoe de samenwerking daadwerkelijk gaat, is het verstandig om daar 1 tot 2 weken te geven of het beste na elke sprint.");
        }
    }

    @Override
    public void verwerkOpdracht(int huidigeVraag){
        if(huidigeVraag == 0){
            System.out.println("Wat is het hoofddoel van de Sprint Retrospective?");
            System.out.println("a) De resultaten van het product demonstreren aan de klant.");
            System.out.println("b) De product backlog aanpassen.");
            System.out.println("c) Terugkijken op het proces en verbeteren waar mogelijk is.");
        } else if(huidigeVraag == 1){
            System.out.println("Wanneer vindt de Sprint Retrospective plaats?");
            System.out.println("a) Aan het begin van de sprint");
            System.out.println("b) Direct na de Sprint Review, aan het einde van de sprint");
            System.out.println("c) Halverwege de Sprint");
        }
    }

    @Override
    public void verwerkResultaat(boolean correct, Speler speler){
        if (correct) {
            speler.verhoogScore(10);  // Score verhogen bij goed antwoord
            verwerkFeedback(huidigeVraag);
            huidigeVraag++;
            System.out.println("Correct!\n");
        } else {
            speler.voegMonsterToe("Blame Game");
            System.out.println("Monster 'Blame Game' verschijnt! Probeer het opnieuw.\n");
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

        while (huidigeVraag < 2) {
            betreedIntro();
            verwerkOpdracht(huidigeVraag);  //De vragen worden uit deze abstracte methode opgeroepen

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
            } else if (antwoord.matches("[a-c]")) {
                boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag); // controleerd de resultaat wat de gebruiker gekozen heeft.
                verwerkResultaat(correct, speler); // toont de resultaat of de speler het goed heeft of niet

            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Je hebt alle vragen juist beantwoord!\n");
        setVoltooid();

        // Deur openen na voltooiing
        deur.setOpen(true);
        System.out.println("De deur gaat open! Je kunt nu verder.");

        // Kamer als voltooid registreren (pas index aan indien nodig)
        speler.voegVoltooideKamerToe(2);
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        return false; // niet gebruikt in deze kamer
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ 'a', 'b' of 'c' om een antwoord te kiezen.");
        System.out.println("Typ 'status' om je huidige status te zien.");
        System.out.println("Typ 'naar andere kamer' om deze kamer te verlaten.");
        System.out.println("Typ 'help' om deze hulp te tonen.");
    }
}