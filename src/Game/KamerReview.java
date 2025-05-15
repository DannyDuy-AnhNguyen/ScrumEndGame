package Game;

import java.util.Scanner;

public class KamerReview extends Kamer {
    private int huidigeVraag = 0;

    public KamerReview() {
        super("Sprint Review");
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 3) {
            typeText("\n🚪 Je bent nu in de kamer: " + naam, 30);

            if (huidigeVraag == 0) {
                System.out.println("1. Wanneer wordt er een sprintreview gehouden?");
                System.out.println("a) Aan het begin van de sprint");
                System.out.println("b) Tijdens de sprint");
                System.out.println("c) Aan het einde van de sprint");
            } else if (huidigeVraag == 1) {
                System.out.println("2. Wat is het belangrijkste doel van de Sprint Review?");
                System.out.println("a) De Scrum Master Evalueren");
                System.out.println("b) Het increment inspecteren en feedback verzamelen");
                System.out.println("c) De volgende sprint alvast plannen");
                System.out.println("d) Vorige sprint doornemen");
            } else if (huidigeVraag == 2) {
                System.out.println("3. De voordelen van een Sprint Review zijn...?");
                System.out.println("a) Meer vergaderingen = meer productiviteit");
                System.out.println("b) Transparantie, snelle feedback, alignment met stakeholders");
                System.out.println("c) Langer werken zonder pauzes");
                System.out.println("d) De product owner tevreden houden");
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
                boolean juist = verwerkAntwoord(antwoord);
                if (juist) {
                    huidigeVraag++;
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
            if (antwoord.equals("c")) {
                deurActie(true, "");
                return true;
            } else {
                deurActie(false, "Sprint Confusie");
                return false;
            }
        } else if (huidigeVraag == 1) {
            if (antwoord.equals("b")) {
                deurActie(true, "");
                return true;
            } else {
                deurActie(false, "Sprint Confusie");
                return false;
            }
        } else if (huidigeVraag == 2) {
            if (antwoord.equals("b")) {
                deurActie(true, "");
                return true;
            } else {
                deurActie(false, "Sprint Confusie");
                return false;
            }
        }
        return false;
    }
}

