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

            String antwoord = scanner.nextLine().trim().toLowerCase();
            antwoordCorrect = verwerkAntwoord(antwoord);
        }

        System.out.println("Je hebt het juiste antwoord gegeven!");
        setVoltooid(); // Zet de kamer als voltooid
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (antwoord.equals("a")) {
            System.out.println("Goed! Tijdens een sprint review presenteer je het werk aan de stakeholders.");
            return true; // Correct antwoord
        } else {
            System.out.println("Fout! Monster 'Sprint Confusie' blokkeert de deur!");
            return false; // Fout antwoord
        }
    }

    @Override
    public void stelVraag(Speler speler) {
        // Deze methode roept de betreed-methode aan om de vraag te stellen
        betreed(speler);
    }
}