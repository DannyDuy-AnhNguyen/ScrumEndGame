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

        while (!antwoordCorrect) {
            System.out.println("Je betreedt de kamer: " + naam);
            System.out.println("Wat hoort op het Scrum Board?");
            System.out.println("a) Gebruikersverhalen, taken, voortgang");
            System.out.println("b) Persoonlijke notities van teamleden");
            System.out.println("c) Salarisinformatie");

            String antwoord = scanner.nextLine().trim().toLowerCase();
            antwoordCorrect = verwerkAntwoord(antwoord);
        }

        System.out.println("Je hebt het juiste antwoord gegeven!");
        setVoltooid(); // Zet de kamer als voltooid
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (antwoord.equals("a")) {
            System.out.println("Correct! Het bord toont werk en voortgang.");
            return true; // Correct antwoord
        } else {
            System.out.println("Fout! Monster 'Chaos op het bord' verschijnt!");
            return false; // Fout antwoord
        }
    }
}