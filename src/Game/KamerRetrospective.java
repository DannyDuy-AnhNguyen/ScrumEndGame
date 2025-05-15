package Game;

import java.util.Scanner;

public class KamerRetrospective extends Kamer {
    private int huidigeVraag = 0;

    public KamerRetrospective() {
        super("Sprint Retrospective");
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            System.out.println("Je betreedt de kamer: " + naam);

            if (huidigeVraag == 0) {
                System.out.println("1. Wat is het hoofddoel van de Sprint Retrospective?");
                System.out.println("a) De resultaten van het product demonstreren aan de klant.");
                System.out.println("b) De product backlog aanpassen.");
                System.out.println("c) Terugkijken op het proces en verbeteren waar mogelijk is.");
            } else if (huidigeVraag == 1) {
                System.out.println("2. Wanneer vindt de Sprint Retrospective plaats?");
                System.out.println("a) Aan het begin van de sprint");
                System.out.println("b) Direct na de Sprint Review, aan het einde van de sprint");
                System.out.println("c) Halverwege de Sprint");
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
                    System.out.println("Monster 'Blame Game' verschijnt! Probeer het opnieuw.\n");
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
            correct = antwoord.equals("c");
            if (correct) {
                System.out.println("Correct! Terugkijken en verbeteren is het doel.");
            } else {
                System.out.println("Fout! Dit is niet het hoofddoel.");
            }
        } else if (huidigeVraag == 1) {
            correct = antwoord.equals("b");
            if (correct) {
                System.out.println("Correct! De Retrospective vindt direct na de Review plaats.");
            } else {
                System.out.println("Fout! Dit is niet het juiste moment.");
            }
        }
        updateScore(correct, speler);
        return correct;
    }
}