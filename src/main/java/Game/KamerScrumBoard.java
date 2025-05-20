package Game;

import java.util.Scanner;

public class KamerScrumBoard extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Status status;


    public KamerScrumBoard(Antwoord antwoordStrategie) {
        super("Scrum Board");
        this.antwoordStrategie = antwoordStrategie;
    }

    @Override
    public void betreed(Speler speler) {
        this.status = new Status(speler);
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
                status.update();
                System.out.println();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.\n");
                return;
            } else if (antwoord.matches("[a-c]")) {
                boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
                if (correct) {
                    System.out.println("Correct!");
                    updateScore(true, speler);
                    huidigeVraag++;
                    System.out.println();
                } else {
                    System.out.println("Fout, probeer opnieuw.");
                    updateScore(false, speler);
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
        // Niet nodig meer, strategie regelt het
        return false;
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ het letterantwoord: a, b of c");
        System.out.println("Gebruik 'status' om je huidige status te zien.");
        System.out.println("Gebruik 'help' om deze hulp te zien.");
        System.out.println("Gebruik 'naar andere kamer' om deze kamer te verlaten.");
    }
}