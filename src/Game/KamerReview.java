package Game;

import java.util.Scanner;

public class KamerReview extends Kamer {
    public KamerReview() {
        super("Sprint Review");
    }

    @Override
    public void betreed(Speler speler) {
        boolean antwoordCorrect = false;
        Scanner scanner = new Scanner(System.in);

        while (!antwoordCorrect) {
            System.out.println("Je bent nu in de kamer: " + naam);
            System.out.println("Wat gebeurt er tijdens een sprint review?");
            System.out.println("a) Het presenteren van de opgeleverde software aan de stakeholders");
            System.out.println("b) Het plannen van de volgende sprint");
            System.out.println("c) Het uitvoeren van de sprint retrospective");
            System.out.println("Typ 'help' voor uitleg, 'status' voor je status of 'naar andere kamer' om deze kamer te verlaten.\n");

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
            } else if (antwoord.equals("a") || antwoord.equals("b") || antwoord.equals("c")) {
                antwoordCorrect = verwerkAntwoord(antwoord);
                System.out.println();
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Je hebt het juiste antwoord gegeven!\n");
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (antwoord.equals("a")) {
            System.out.println("Goed! Tijdens een sprint review presenteer je het werk aan de stakeholders.");
            return true;
        } else {
            System.out.println("Fout! Monster 'Sprint Confusie' blokkeert de deur!");
            return false;
        }
    }
}