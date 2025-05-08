package Class;

import java.util.Scanner;

public class KamerReview extends Kamer {

    public KamerReview(String naam) {
        super(naam);
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt de Sprint Review Kamer.");
        System.out.println("Stakeholder zegt: 'De demo was duidelijk, maar ik mis nog iets over gebruikersgemak.'");
        System.out.println("Wat moet het team hiermee doen?");
        System.out.println("A) Negeren, feedback hoort bij de volgende sprint");
        System.out.println("B) Feedback documenteren en bespreken met het team");
        System.out.print("Typ A of B: ");

        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine().trim().toUpperCase();
        verwerkAntwoord(antwoord);
    }

    @Override
    public void verwerkAntwoord(String antwoord) {
        if (antwoord.equals("B")) {
            System.out.println("Correct! Feedback moet besproken en verwerkt worden.");
        } else {
            System.out.println("Fout! Je hebt het monster 'Ongrijpbare Feedback' opgeroepen!");
            // Hier zou je later een monster toevoegen
        }
    }
}
