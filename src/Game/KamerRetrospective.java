package Game;

import java.util.Scanner;

public class KamerRetrospective extends Kamer {
    private int huidigeVraag = 0;

    public KamerRetrospective() {
        super("Sprint Retrospective");
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            typeText("\n🚪 Je betreedt de kamer: " + naam, 30);

            if (huidigeVraag == 0) {
                typeText("1. Wat is het hoofddoel van de Sprint Retrospective?", 30);
                System.out.println("a) De resultaten van het product demonstreren aan de klant.");
                System.out.println("b) De product backlog aanpassen.");
                System.out.println("c) Terugkijken op het proces en verbeteren waar mogelijk is.");
            } else if (huidigeVraag == 1) {
                typeText("2. Wanneer vindt de Sprint Retrospective plaats?", 30);
                System.out.println("a) Aan het begin van de sprint");
                System.out.println("b) Direct na de Sprint Review, aan het einde van de sprint");
                System.out.println("c) Halverwege de Sprint");
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
            } else if (antwoord.equals("status")) {
                speler.status();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("⬅️ Je verlaat deze kamer.");
                return;
            } else if (antwoord.matches("[a-c]")) {
                boolean juist = verwerkAntwoord(antwoord);
                if (juist) {
                    huidigeVraag++;
                }
            } else {
                System.out.println("⚠️ Ongeldige invoer. Typ 'a', 'b', 'c', 'status', 'help' of 'naar andere kamer'.");
            }
        }

        typeText("🎉 Je hebt alle vragen juist beantwoord! De deur opent volledig.\n", 30);
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (huidigeVraag == 0) {
            if (antwoord.equals("c")) {
                deurActie(true, "");
                return true;
            } else {
                deurActie(false, "Blame Game");
                return false;
            }
        } else if (huidigeVraag == 1) {
            if (antwoord.equals("b")) {
                deurActie(true, "");
                return true;
            } else {
                deurActie(false, "Blame Game");
                return false;
            }
        }
        return false;
    }
}
