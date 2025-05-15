package Game;

import java.util.Scanner;

public class KamerRetrospective extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;

    private final String[] vragen = {
            "Wat is het hoofddoel van de Sprint Retrospective?",
            "Wanneer vindt de Sprint Retrospective plaats?"
    };

    private final String[][] opties = {
            {
                    "a) De resultaten van het product demonstreren aan de klant.",
                    "b) De product backlog aanpassen.",
                    "c) Terugkijken op het proces en verbeteren waar mogelijk is."
            },
            {
                    "a) Aan het begin van de sprint",
                    "b) Direct na de Sprint Review, aan het einde van de sprint",
                    "c) Halverwege de Sprint"
            }
    };

    public KamerRetrospective(Antwoord antwoordStrategie) {
        super("Sprint Retrospective");
        this.antwoordStrategie = antwoordStrategie;
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < vragen.length) {
            System.out.println("Je betreedt de kamer: " + naam);
            System.out.println((huidigeVraag + 1) + ". " + vragen[huidigeVraag]);

            for (String optie : opties[huidigeVraag]) {
                System.out.println(optie);
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
            } else if (antwoord.matches("[a-c]")) {
                boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
                updateScore(correct, speler);
                if (correct) {
                    huidigeVraag++;
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Monster 'Blame Game' verschijnt! Probeer het opnieuw.\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Je hebt alle vragen juist beantwoord!\n");
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        return false; // niet gebruikt in deze kamer
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ 'a', 'b' of 'c' om een antwoord te kiezen.");
        System.out.println("Typ 'status' om je huidige status te zien.");
        System.out.println("Typ 'naar andere kamer' om deze kamer te verlaten.");
        System.out.println("Typ 'help' om deze hulp te tonen.");
    }
}