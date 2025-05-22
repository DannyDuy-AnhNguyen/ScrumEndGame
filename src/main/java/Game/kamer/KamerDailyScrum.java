package Game.kamer;

import Game.antwoord.Antwoord;
import Game.core.Speler;
import Game.core.Status;

import java.util.Scanner;

public class KamerDailyScrum extends Kamer {
    private final Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Status status;

    public KamerDailyScrum(Antwoord antwoordStrategie) {
        super("Daily Scrum");
        this.antwoordStrategie = antwoordStrategie;
        deur.setOpen(false); // deur start altijd dicht
    }

    @Override
    public void betreedIntro() {
        System.out.println("\nJe bent nu in de kamer: " + naam);
        deur.toonStatus();
        System.out.println();
    }

    @Override
    public void verwerkFeedback(int vraagIndex) {
        switch (vraagIndex) {
            case 0 -> System.out.println("Een projectleider is geen officiële rol binnen Scrum.");
            case 1 -> System.out.println("De meeste sprints duren 1 tot 4 weken. Kort genoeg om snel te kunnen bijsturen.");
        }
    }

    @Override
    public void verwerkOpdracht(int vraagIndex) {
        if (vraagIndex == 0) {
            System.out.println("Vraag 1: Welke van de volgende rollen bestaat niet binnen Scrum?");
            System.out.println("a) Projectleider");
            System.out.println("b) Scrum Master");
            System.out.println("c) Development Team");
            System.out.println("d) Product Owner");
        } else if (vraagIndex == 1) {
            System.out.println("Vraag 2: Hoelang duurt een standaard sprint meestal?");
            System.out.println("a) 1 tot 4 weken");
            System.out.println("b) 1 tot 4 maanden");
            System.out.println("c) 1 tot 4 dagen");
            System.out.println("d) 1 tot 4 jaren");
        }
    }

    @Override
    public void verwerkResultaat(boolean correct, Speler speler) {
        if (correct) {
            speler.verhoogScore(10);
            verwerkFeedback(huidigeVraag);
            huidigeVraag++;
            System.out.println("\nCorrect! Je krijgt 10 punten.\n");

            if (huidigeVraag == 2) {
                setVoltooid();
                deur.setOpen(true);
                System.out.println("Je hebt alle vragen juist beantwoord! De deur gaat open.");
                speler.voegVoltooideKamerToe(2); // Pas index aan indien nodig
            }

        } else {
            speler.voegMonsterToe("Verlies van Focus");
            System.out.println("\nFout! Monster 'Verlies van Focus' verschijnt! Probeer het opnieuw.\n");
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
        return;
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        return false; // Niet gebruikt
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ het letterantwoord: a, b, c of d");
        System.out.println("Gebruik 'status' om je huidige status te zien.");
        System.out.println("Gebruik 'help' om deze hulp te zien.");
        System.out.println("Gebruik 'naar andere kamer' om deze kamer te verlaten.");
    }

    public void reset() {
        huidigeVraag = 0;
        deur.setOpen(false);
    }
}