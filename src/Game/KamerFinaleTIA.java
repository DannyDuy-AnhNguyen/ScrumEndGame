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

        while (huidigeVraag < 4) {  // Verhoog het aantal vragen naar 4
            System.out.println("Welkom in de laatste kamer: " + naam);

            if (huidigeVraag == 0) {
                System.out.println("1. Wat vind je van Scrum?");
                System.out.println("a) Uitstekend");
                System.out.println("b) Neutraal");
                System.out.println("c) Slecht");
            } else if (huidigeVraag == 1) {
                System.out.println("2. Uit welk jaar is Scrum ontstaan?");
                System.out.println("a) 1993");
                System.out.println("b) 1995");
                System.out.println("c) 2001");
                System.out.println("d) 2010");
            } else if (huidigeVraag == 2) {
                System.out.println("3. Is Scrum gay?");
                System.out.println("a) Ja");
                System.out.println("b) Ja");
                System.out.println("c) Ja");
                System.out.println("d) Ja");
            } else if (huidigeVraag == 3) {  // De nieuwe open vraag
                System.out.println("4. Bij welke sprint hoort deze userstory?");
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
                System.out.println();
            } else if (antwoord.equals("status")) {
                speler.status();
                System.out.println();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.");
                return;
            } else if (huidigeVraag == 3 && verwerkAntwoordOpenVraag(antwoord)) {
                huidigeVraag++;
                System.out.println("Je hebt de open vraag goed beantwoord!");
                System.out.println();
            } else if (antwoord.matches("[a-e]")) {
                if (verwerkAntwoord(antwoord)) {
                    huidigeVraag++;
                    System.out.println();
                } else {
                    System.out.println("Fout antwoord! De deur blijft gesloten en Monster 'Scrum Misverstanden' verschijnt!\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.");
            }
        }

        System.out.println("Gefeliciteerd! Je hebt alle vragen goed beantwoord en de laatste kamer voltooid.");
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (huidigeVraag == 0) {
            return antwoord.equals("a");
        } else if (huidigeVraag == 1) {
            return antwoord.equals("a");
        } else if (huidigeVraag == 2) {
            return antwoord.equals("e");
        } else {
            return false;
        }
    }

    // Methode voor de open vraag
    public boolean verwerkAntwoordOpenVraag(String antwoord) {
        // Reguliere expressie die controleert of het antwoord 0, sprint 0 of nul is
        return antwoord.matches("^(0|sprint 0|nul|sprintnul|sprint0|)$");
    }
}