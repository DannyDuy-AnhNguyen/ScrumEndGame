package Game;

import java.util.Scanner;

public class KamerFinaleTIA extends Kamer {
    private int huidigeVraag = 0;

    public KamerFinaleTIA() {
        super("Finale TIA Kamer – Waarom Scrum?");
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 3) {
            typeText("\n🚪 Welkom in de laatste kamer: " + naam, 30);

            if (huidigeVraag == 0) {
                typeText("1. Wat is het ultieme doel van Scrum?", 30);
                System.out.println("a) Strikte processen volgen");
                System.out.println("b) Zo snel mogelijk software opleveren");
                System.out.println("c) Transparantie, Inspectie en Aanpassing (TIA)");
            } else if (huidigeVraag == 1) {
                typeText("2. Uit welk jaar is Scrum ontstaan?", 30);
                System.out.println("a) 1993");
                System.out.println("b) 1995");
                System.out.println("c) 2001");
                System.out.println("d) 2010");
            } else if (huidigeVraag == 2) {
                typeText("3. Bij welke sprint hoort een voorbereidend item zoals een user story die nog besproken moet worden?", 30);
                System.out.println("(typ het nummer van de sprint of 'sprint 0')");
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
            } else if (antwoord.equals("status")) {
                speler.status();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("⬅️ Je verlaat deze kamer.");
                return;
            } else if (huidigeVraag == 2) {
                if (verwerkAntwoordOpenVraag(antwoord)) {
                    deurActie(true, "");
                    huidigeVraag++;
                } else {
                    deurActie(false, "Scrum Misverstanden");
                }
            } else if (antwoord.matches("[a-d]")) {
                boolean juist = verwerkAntwoord(antwoord);
                if (juist) {
                    huidigeVraag++;
                }
            } else {
                System.out.println("⚠️ Ongeldige invoer. Typ 'a' t/m 'd', of een tekstueel antwoord, of gebruik 'status', 'help', 'naar andere kamer'.");
            }
        }

        typeText("🎉 Gefeliciteerd! Je hebt alle vragen goed beantwoord en de laatste kamer voltooid.\n", 30);
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (huidigeVraag == 0) {
            if (antwoord.equals("c")) {
                deurActie(true, "");
                return true;
            } else {
                deurActie(false, "Scrum Misverstanden");
                return false;
            }
        } else if (huidigeVraag == 1) {
            if (antwoord.equals("b")) {
                deurActie(true, "");
                return true;
            } else {
                deurActie(false, "Scrum Misverstanden");
                return false;
            }
        }
        return false;
    }

    public boolean verwerkAntwoordOpenVraag(String antwoord) {
        return antwoord.matches("^(0|sprint ?0|nul|sprintnul|sprint0)$");
    }
}
