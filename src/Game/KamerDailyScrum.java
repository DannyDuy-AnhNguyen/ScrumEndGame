package Game;

import java.util.Scanner;

public class KamerDailyScrum extends Kamer {
    private int huidigeVraag = 0;

    public KamerDailyScrum() {
        super("Daily Scrum");
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            typeText("\n🚪 Je betreedt de kamer: " + naam, 30);

            if (huidigeVraag == 0) {
                typeText("1. Welke van de volgende rollen bestaat niet binnen Scrum?", 30);
                System.out.println("a) Projectleider");
                System.out.println("b) Scrum Master");
                System.out.println("c) Development Team");
                System.out.println("d) Product Owner");
            } else if (huidigeVraag == 1) {
                typeText("2. Hoelang duurt een standaard sprint meestal?", 30);
                System.out.println("a) 1 tot 4 weken");
                System.out.println("b) 1 tot 4 maanden");
                System.out.println("c) 1 tot 4 dagen");
                System.out.println("d) 1 tot 4 jaren");
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
            } else if (antwoord.equals("status")) {
                speler.status();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("⬅️ Je verlaat deze kamer.");
                return;
            } else if (antwoord.matches("[a-d]")) {
                boolean correct = verwerkAntwoord(antwoord);
                if (correct) {
                    deurActie(true, "");
                    huidigeVraag++;
                } else {
                    deurActie(false, "Verlies van Focus");
                }
            } else {
                System.out.println("⚠️ Ongeldige invoer. Typ 'a' t/m 'd', 'status', 'help' of 'naar andere kamer'.");
            }
        }

        typeText("🎉 Je hebt alle vragen juist beantwoord! De deur opent volledig.\n", 30);
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (huidigeVraag == 0) {
            return antwoord.equals("a");
        } else if (huidigeVraag == 1) {
            return antwoord.equals("a");
        }
        return false;
    }
}
