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

        System.out.println("Je hebt het juiste antwoord gegeven!\n");
        setVoltooid();
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