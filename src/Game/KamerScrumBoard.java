package Game;

import java.util.Scanner;

public class KamerScrumBoard extends Kamer {

    public KamerScrumBoard() {
        super("Scrum Board");
    }

    @Override
    public void betreed(Speler speler) {
        System.out.println("Je betreedt de kamer: " + naam);
        System.out.println("Wat hoort op het Scrum Board?");
        System.out.println("a) Gebruikersverhalen, taken, voortgang");
        System.out.println("b) Persoonlijke notities van teamleden");
        System.out.println("c) Salarisinformatie");

        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine().trim().toLowerCase();
        verwerkAntwoord(antwoord);
    }

    @Override
    public void verwerkAntwoord(String antwoord) {
        if (antwoord.equals("a")) {
            System.out.println("Correct! Het bord toont werk en voortgang.");
        } else {
            System.out.println("Fout! Monster 'Chaos op het bord' verschijnt!");
        }
    }
}