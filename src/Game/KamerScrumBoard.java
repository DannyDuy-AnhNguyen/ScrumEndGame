package Game;

import java.util.Scanner;

public class KamerScrumBoard extends Kamer {

    public KamerScrumBoard() {
        super("Scrum Board");
    }

    @Override
    public void betreed(Speler speler) {
        boolean antwoordCorrect = false;
        Scanner scanner = new Scanner(System.in);
        setInVraag(true); // De speler is nu in de vraag

        while (!antwoordCorrect) {
            System.out.println("Je betreedt de kamer: " + naam);
            System.out.println("Wat hoort op het Scrum Board?");
            System.out.println("a) Gebruikersverhalen, taken, voortgang");
            System.out.println("b) Persoonlijke notities van teamleden");
            System.out.println("c) Salarisinformatie");

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

        System.out.println("Je hebt het juiste antwoord gegeven!");
        setVoltooid(); // Zet de kamer als voltooid
        setInVraag(false); // De vraag is beantwoord
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (antwoord.equals("a")) {
            System.out.println("Correct! Het Scrum Board toont gebruikersverhalen, taken en de voortgang.");
            return true; // Correct antwoord
        } else {
            System.out.println("Fout! Monster 'Chaos op het bord' verschijnt!");
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