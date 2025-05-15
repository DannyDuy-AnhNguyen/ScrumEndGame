package Game;

import java.util.Scanner;

public class KamerRetrospective extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;

    public KamerRetrospective(Antwoord antwoordStrategie) {
        super("Sprint Retrospective");
        this.antwoordStrategie = antwoordStrategie;
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            System.out.println("Je betreedt de kamer: " + naam);

            switch (huidigeVraag) {
                case 0:
                    System.out.println("1. Wat is het hoofddoel van de Sprint Retrospective?");
                    System.out.println("a) De resultaten van het product demonstreren aan de klant.");
                    System.out.println("b) De product backlog aanpassen.");
                    System.out.println("c) Terugkijken op het proces en verbeteren waar mogelijk is.");
                    break;
                case 1:
                    System.out.println("2. Wanneer vindt de Sprint Retrospective plaats?");
                    System.out.println("a) Aan het begin van de sprint");
                    System.out.println("b) Direct na de Sprint Review, aan het einde van de sprint");
                    System.out.println("c) Halverwege de Sprint");
                    break;
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
                boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
                if (correct) {
                    updateScore(true, speler);
                    huidigeVraag++;
                    System.out.println();
                } else {
                    updateScore(false, speler);
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