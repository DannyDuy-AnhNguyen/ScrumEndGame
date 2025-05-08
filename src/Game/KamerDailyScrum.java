package Game;

import java.util.Scanner;

public class KamerDailyScrum extends Kamer {

    public KamerDailyScrum() {
        super("Daily Scrum");
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (!isVraagBeantwoord()) {  // Gebruik de nieuwe methode om te controleren of de vraag beantwoord is
            System.out.println("Je betreedt de kamer: " + naam);
            System.out.println("Wat is het doel van de Daily Scrum?");
            System.out.println("a) Het delen van persoonlijke verhalen");
            System.out.println("b) Het bespreken van de voortgang van het werk");
            System.out.println("c) Het plannen van de volgende sprint");

            String antwoord = scanner.nextLine().trim().toLowerCase();
            boolean antwoordCorrect = verwerkAntwoord(antwoord);

            if (antwoordCorrect) {
                setVraagBeantwoord(true);  // Zet vraag als beantwoord bij correct antwoord
            } else {
                System.out.println("Je moet de vraag correct beantwoorden voordat je verder kunt.");
            }
        }

        System.out.println("Goed gedaan! Je mag nu naar de volgende kamer.");
        setVoltooid(); // Zet de kamer als voltooid
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