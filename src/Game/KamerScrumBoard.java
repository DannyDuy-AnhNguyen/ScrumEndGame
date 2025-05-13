package Game;

import java.util.Scanner;

public class KamerScrumBoard extends Kamer {
    private int huidigeVraag = 0;
    private final Antwoord antwoordStrategie;

    public KamerScrumBoard(Antwoord strategie) {
        super("Scrum Board");
        this.antwoordStrategie = strategie;
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            System.out.println("Je betreedt de kamer: " + naam);

            if (huidigeVraag == 0) {
                System.out.println("1. Wat is de volgorde om een scrum process te maken?");
                System.out.println("a) Epics > Userstories > Taken");
                System.out.println("b) Epics > Taken > Userstories");
                System.out.println("c) Userstories > Epics > Taken");
            } else if (huidigeVraag == 1) {
                System.out.println("2. Welke borden gebruik je in de scrumboard?");
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
                if (antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag)) {
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

//    @Override
//    public boolean verwerkAntwoord(String antwoord) {
//        if (huidigeVraag == 0) {
//            return antwoord.equals("a");
//        } else if (huidigeVraag == 1) {
//            return antwoord.equals("b");
//        } else {
//            return false;
//        }
//    }
}