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
            typeText("\n🚪 Je betreedt de kamer: " + naam, 30);
            typeText("Wat hoort op het Scrum Board?", 30);
            System.out.println("a) Gebruikersverhalen, taken, voortgang");
            System.out.println("b) Persoonlijke notities van teamleden");
            System.out.println("c) Salarisinformatie");

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("status")) {
                speler.status();
                continue;
            } else if (antwoord.equals("help")) {
                toonHelp();
                continue;
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("⬅️ Je keert terug naar de gang.");
                break;
            }

            if (!antwoord.equals("a") && !antwoord.equals("b") && !antwoord.equals("c")) {
                System.out.println("⚠️ Ongeldige invoer. Kies a, b of c (of typ 'status' of 'help').");
                continue;
            }

            antwoordCorrect = verwerkAntwoord(antwoord);
        }

        if (antwoordCorrect) {
            typeText("➡️ Je verlaat de kamer.", 30);
        }
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (antwoord.equals("a")) {
            deurActie(true, "");
            return true;
        } else {
            deurActie(false, "Chaos op het bord");
            return false;
        }
    }
}
