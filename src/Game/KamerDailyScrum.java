package Game;

import java.util.Scanner;

public class KamerDailyScrum extends Kamer {
    private int huidigeVraag = 0;

    public KamerDailyScrum() {
        super("Daily Scrum");
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            System.out.println("Je betreedt de kamer: " + naam);

            if (huidigeVraag == 0) {
                System.out.println("1. Welke van de volgende rollen bestaat niet binnen Scrum?");
                System.out.println("a) Projectleider");
                System.out.println("b) Scrum Master");
                System.out.println("c) Development Team");
                System.out.println("d) Product Owner");
            } else if (huidigeVraag == 1) {
                System.out.println("2. Hoelang duurt een standaard sprint meestal?");
                System.out.println("a) 1 tot 4 weken");
                System.out.println("b) 1 tot 4 maanden");
                System.out.println("c) 1 tot 4 dagen");
                System.out.println("d) 1 tot 4 jaren");
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
            } else if (antwoord.matches("[a-d]")) {
                // Let op: hier nu verwerkAntwoord met speler meegeven
                if (verwerkAntwoord(antwoord, speler)) {
                    huidigeVraag++;
                    System.out.println();
                } else {
                    System.out.println("Fout antwoord! De deur blijft gesloten en Monster 'Verlies van Focus' verschijnt!\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd' 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Je hebt alle vragen juist beantwoord! De deur gaat open.\n");
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        boolean isCorrect = antwoord.equalsIgnoreCase("a"); // voorbeeldcheck
        updateScore(isCorrect, speler);
        if (isCorrect) {
            setVoltooid();
        }
        return isCorrect;
    }
}