package Game;

import java.util.Scanner;

public class KamerScrumBoard extends Kamer {
    private int huidigeVraag = 0;

    public KamerScrumBoard() {
        super("Scrum Board");
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            System.out.println("Je betreedt de kamer: " + naam);

            if (huidigeVraag == 0) {
                System.out.println("1. Wat is de volgorde om een Scrum-proces te maken?");
                System.out.println("a) Epics > Userstories > Taken");
                System.out.println("b) Epics > Taken > Userstories");
                System.out.println("c) Userstories > Epics > Taken");
            } else if (huidigeVraag == 1) {
                System.out.println("2. Welke borden gebruik je in het Scrumboard?");
                System.out.println("a) Product Backlog > Sprint Backlog > Doing > Testing > Done");
                System.out.println("b) Product Backlog > Sprint Backlog > To Do > Doing > Testing > Done");
                System.out.println("c) Sprint Backlog > To Do > Doing > Testing > Done");
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
                System.out.println();
            } else if (antwoord.equals("status")) {
                speler.status();
                System.out.println();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.\n");
                return;
            } else if (antwoord.matches("[a-c]")) {
                boolean correct = verwerkAntwoord(antwoord, speler);
                if (correct) {
                    huidigeVraag++;
                    System.out.println();
                } else {
                    System.out.println("Monster 'Scrum Chaos' verschijnt! Probeer het opnieuw.\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Je hebt alle vragen juist beantwoord!\n");
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        boolean correct = false;

        if (huidigeVraag == 0) {
            correct = antwoord.equals("a");
            System.out.println(correct
                    ? "Correct! De juiste volgorde is Epics > Userstories > Taken."
                    : "Fout! De juiste volgorde is Epics > Userstories > Taken.");
        } else if (huidigeVraag == 1) {
            correct = antwoord.equals("b");
            System.out.println(correct
                    ? "Correct! Een volledig Scrumboard bevat To Do, Doing, Testing en Done."
                    : "Fout! Denk aan het volledige proces vanaf de backlog tot aan done.");
        }

        updateScore(correct, speler);
        return correct;
    }
}