package Game;

import java.util.Scanner;

public class KamerRetrospective extends Kamer {

    public KamerRetrospective() {
        super("Sprint Retrospective");
    }

    @Override
    public void betreed(Speler speler) {
        boolean antwoordCorrect = false;
        Scanner scanner = new Scanner(System.in);

        while (!antwoordCorrect) {
            System.out.println("Je betreedt de kamer: " + naam);
            System.out.println("Wat is een goed onderwerp voor een retrospective?");
            System.out.println("a) Hoe het weekend van iedereen was");
            System.out.println("b) Wat goed ging, wat beter kan, en actiepunten");
            System.out.println("c) Wie verantwoordelijk is voor fouten");

            String antwoord = scanner.nextLine().trim().toLowerCase();
            antwoordCorrect = verwerkAntwoord(antwoord);
        }

        System.out.println("Je hebt het juiste antwoord gegeven!");
        setVoltooid(); // Zet de kamer als voltooid
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (antwoord.equals("b")) {
            System.out.println("Goed! Reflectie en verbetering zijn de kern.");
            return true; // Correct antwoord
        } else {
            System.out.println("Fout! Monster 'Blame Game' blokkeert de deur!");
            return false; // Fout antwoord
        }
    }
}