package Game;

import java.util.Scanner;

public class KamerRetrospective extends Kamer {
    private int huidigeVraag = 0;
    private final Antwoord antwoordStrategie;

    public KamerRetrospective(Antwoord strategie) {
        super("Sprint Retrospective");
        this.antwoordStrategie = strategie;
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
                if (antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag)) {
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

//    @Override
//    public boolean verwerkAntwoord(String antwoord) {
//        if (huidigeVraag == 0) {
//            return antwoord.equals("c");
//        } else if (huidigeVraag == 1) {
//            return antwoord.equals("b");
//        } else {
//            return false;
//        }
//    }
}