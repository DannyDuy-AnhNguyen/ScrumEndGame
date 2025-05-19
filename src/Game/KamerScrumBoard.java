package Game;

import java.util.Scanner;

public class KamerScrumBoard extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Deur deur;

    public KamerScrumBoard(Antwoord antwoordStrategie, Deur deur) {
        super("Scrum Board");
        this.antwoordStrategie = antwoordStrategie;
        this.deur = deur;
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            System.out.println("Je betreedt de kamer: " + naam);

            switch (huidigeVraag) {
                case 0 -> {
                    System.out.println("1. Wat is de volgorde om een Scrum-proces te maken?");
                    System.out.println("a) Epics > Userstories > Taken");
                    System.out.println("b) Epics > Taken > Userstories");
                    System.out.println("c) Userstories > Epics > Taken");
                }
                case 1 -> {
                    System.out.println("2. Welke borden gebruik je in het Scrumboard?");
                    System.out.println("a) Product Backlog > Sprint Backlog > Doing > Testing > Done");
                    System.out.println("b) Product Backlog > Sprint Backlog > To Do > Doing > Testing > Done");
                    System.out.println("c) Sprint Backlog > To Do > Doing > Testing > Done");
                }
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
            } else if (antwoord.equals("status")) {
                speler.status();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.\n");
                return;
            } else if (antwoord.matches("[a-c]")) {
                boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
                updateScore(correct, speler);

                if (correct) {
                    System.out.println("Correct!");
                    huidigeVraag++;
                } else {
                    speler.voegMonsterToe("Board Chaos");
                    deur.setOpen(false);
                    deur.toonStatus();
                    System.out.println("Fout! Monster 'Board Chaos' verschijnt! Probeer het opnieuw.\n");
                }

                System.out.println();
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("✅ Je hebt alle vragen juist beantwoord! De deur gaat open.");
        deur.setOpen(true);
        deur.toonStatus();
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
        updateScore(correct, speler);
        return correct;
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ het letterantwoord: a, b of c");
        System.out.println("Gebruik 'status' om je huidige status te zien.");
        System.out.println("Gebruik 'help' om deze hulp te zien.");
        System.out.println("Gebruik 'naar andere kamer' om deze kamer te verlaten.");
    }
}
