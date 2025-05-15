package Game;

import java.util.Scanner;

public class KamerPlanning extends Kamer {

    private int huidigeVraag = 1; // Vraag 1 of 2

    public KamerPlanning() {
        super("Sprint Planning");
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);
        boolean antwoordCorrect = false;

        while (huidigeVraag <= 2) {
            System.out.println("Je bent nu in de kamer: " + naam);

            if (huidigeVraag == 1) {
                System.out.println("Wie neemt deel aan de Sprint Planning?");
                System.out.println("a) Alleen de Scrum Master");
                System.out.println("b) Product Owner en Scrum Master");
                System.out.println("c) Product Owner Scum Master en het hele Development Team");
                System.out.println("d) Product Owner Scrum Master en het hele Development Team");
            } else if (huidigeVraag == 2) {
                System.out.println("Wat wordt er tijdens de Sprint Planning vastgesteld?");
                System.out.println("a) Welke teamleden vakantie hebben");
                System.out.println("b) Wat het doel van de sprint is en welke backlog-items worden opgepakt");
                System.out.println("c) Hoe de vorige sprint geëvalueerd");
                System.out.println("d) Wat de vastgestelde items van de backlog zijn als de product owner tevreden is met het product.");
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
                System.out.println();
            } else if (antwoord.equals("status")) {
                speler.status();
                System.out.println();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.\n");
                return;
            } else if (antwoord.matches("[a-d]")) {
                antwoordCorrect = verwerkAntwoord(antwoord);
                System.out.println();
                if (antwoordCorrect) {
                    huidigeVraag++;
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        typeText("🎉 Je hebt beide vragen goed beantwoord! De deur opent volledig. \n", 30);
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (huidigeVraag == 1) {
            if (antwoord.equals("d")) {
                System.out.println("Correct! Het hele Scrum Team neemt deel aan de Sprint Planning.");
                return true;
            } else {
                System.out.println("Fout! Monster 'Misverstand' verschijnt! Probeer het opnieuw.");
                // Hier kun je later een straf implementeren
                return false;
            }
        } else if (huidigeVraag == 2) {
            if (antwoord.equals("b")) {
                System.out.println("Correct! Tijdens de Sprint Planning worden het sprintdoel en de backlog-items vastgesteld.");
                return true;
            } else {
                System.out.println("Fout! Monster 'Verwarring' verschijnt! Probeer het opnieuw.");
                // Ook hier later straf mogelijk
                return false;
            }
        }

        return false;
    }
}