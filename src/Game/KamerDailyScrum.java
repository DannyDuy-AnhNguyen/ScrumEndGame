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
        setInVraag(true); // De speler is nu in de vraag

        while (!antwoordCorrect) {
            System.out.println("Je betreedt de kamer: " + naam);
            System.out.println("Wat is het doel van de Daily Scrum?");
            System.out.println("a) Het delen van persoonlijke verhalen");
            System.out.println("b) Het bespreken van de voortgang van het werk");
            System.out.println("c) Het plannen van de volgende sprint");

            String antwoord = scanner.nextLine().trim().toLowerCase();

            // Als het commando 'status' is, geven we de status weer
            if (antwoord.equals("status")) {
                speler.status(); // Geef de status weer zonder monster
                continue; // Herhaal de vraag zonder de fout
            }

            // Als de speler kiest om naar een andere kamer te gaan
            else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je kiest ervoor om naar een andere kamer te gaan.");
                break; // Breek de loop en stop het vragen
            }

            // Als de invoer geen a, b of c is, geef een foutmelding en herhaal de vraag
            if (!antwoord.equals("a") && !antwoord.equals("b") && !antwoord.equals("c")) {
                System.out.println("Ongeldige keuze! Kies a, b of c. Of typ 'status' om je status te zien, of 'naar andere kamer' om verder te gaan.");
                continue; // Herhaal de vraag zonder de fout
            }

            // Verwerk antwoord als het een geldige keuze is
            antwoordCorrect = verwerkAntwoord(antwoord);
        }

        System.out.println("Goed gedaan! Je mag nu naar de volgende kamer.");
        setVoltooid(); // Zet de kamer als voltooid
        setInVraag(false); // De vraag is beantwoord
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

    @Override
    public void stelVraag(Speler speler) {
        // Deze methode roept de betreed-methode aan om de vraag te stellen
        if (isInVraag()) {  // Alleen de vraag stellen als we in een vraag zitten
            betreed(speler);
        } else {
            System.out.println("Je kunt de vraag pas beantwoorden als je in de kamer bent.");
        }
    }
}