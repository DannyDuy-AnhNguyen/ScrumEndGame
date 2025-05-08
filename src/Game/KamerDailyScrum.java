package Game;

import java.util.Scanner;

public class KamerDailyScrum extends Kamer {

    public KamerDailyScrum() {
        super("Daily Scrum");
    }

    @Override
    public void betreed(Speler speler) {
        System.out.println("Je betreedt de kamer: " + naam);
        System.out.println("Wat is het doel van de Daily Scrum?");
        System.out.println("a) Het delen van persoonlijke verhalen");
        System.out.println("b) Het bespreken van de voortgang van het werk");
        System.out.println("c) Het plannen van de volgende sprint");

        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine().trim().toLowerCase();
        verwerkAntwoord(antwoord);
    }

    @Override
    public void verwerkAntwoord(String antwoord) {
        if (antwoord.equals("b")) {
            System.out.println("Correct! Het doel van de Daily Scrum is om de voortgang van het werk te bespreken.");
        } else {
            System.out.println("Fout! Monster 'Verlies van Focus' verschijnt!");
        }
    }
}