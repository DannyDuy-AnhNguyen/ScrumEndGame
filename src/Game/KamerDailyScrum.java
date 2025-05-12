package Game;

import java.util.Scanner;

public class KamerDailyScrum extends Kamer {

    public KamerDailyScrum() {
        super("Daily Scrum");
    }

    @Override
    public void betreed(Speler speler) {
        boolean antwoordCorrect = false;
        Scanner scanner = new Scanner(System.in);

        while (!antwoordCorrect) {
            System.out.println("Je betreedt de kamer: " + naam);
            System.out.println("Wat is het doel van de Daily Scrum?");
            System.out.println("a) Het delen van persoonlijke verhalen");
            System.out.println("b) Het bespreken van de voortgang van het werk");
            System.out.println("c) Het plannen van de volgende sprint");
            System.out.println("Typ 'help' voor uitleg, 'status' voor je status of 'naar andere kamer' om deze kamer te verlaten.\n");

            String antwoord = scanner.nextLine().trim().toLowerCase();

            // Keuzes verwerken
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

        System.out.println("Goed gedaan! Je mag nu naar de volgende kamer.\n");
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (antwoord.equals("b")) {
            System.out.println("Correct! Het doel van de Daily Scrum is om de voortgang van het werk te bespreken.");
            return true; // Correct antwoord
        } else {
            System.out.println("Fout! Monster 'Verlies van Focus' verschijnt! Probeer het opnieuw.");
            return false; // Fout antwoord
        }
    }
}