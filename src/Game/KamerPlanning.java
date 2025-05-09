package Game;

import java.util.Scanner;

public class KamerPlanning extends Kamer {

    public KamerPlanning() {
        super("Sprint Planning");
    }

    @Override
    public void betreed(Speler speler) {
        boolean antwoordCorrect = false;
        Scanner scanner = new Scanner(System.in);
        setInVraag(true); // De speler is nu in de vraag

        while (!antwoordCorrect) {
            System.out.println("Je bent nu in de kamer: Sprint Planning.");
            System.out.println("Vraag: Wat is het doel van een sprint planning?");
            System.out.println("a) Het doel van de sprint is om de planning te maken");
            System.out.println("b) De sprintplanning moet ervoor zorgen dat het team goed begrijpt wat er gedaan moet worden");
            System.out.println("c) De sprintplanning is een kans om alle technische beslissingen te nemen");

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
        if (antwoord.equals("b")) {
            System.out.println("Correct! De sprintplanning zorgt ervoor dat het team begrijpt wat er gedaan moet worden.");
            return true; // Correct antwoord
        } else {
            System.out.println("Fout! Monster 'Misverstand' verschijnt! Probeer het opnieuw.");
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