package Game;

import java.util.Scanner;

public class KamerReview extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Status status;

    private final String[] vragen = {
            "Wanneer wordt er een sprintreview gehouden?",
            "Wat is het belangrijkste doel van de Sprint Review?",
            "De voordelen van een Sprint Review zijn...?"
    };

    private final String[][] opties = {
            {
                    "a) Aan het begin van de sprint",
                    "b) Tijdens de sprint",
                    "c) Aan het einde van de sprint"
            },
            {
                    "a) De Scrum Master evalueren",
                    "b) Het increment inspecteren en feedback verzamelen",
                    "c) De volgende sprint alvast plannen",
                    "d) Vorige sprint doornemen"
            },
            {
                    "a) Meer vergaderingen = meer productiviteit",
                    "b) Transparantie, snelle feedback, alignment met stakeholders",
                    "c) Langer werken zonder pauzes",
                    "d) De product owner tevreden houden"
            }
    };

    public KamerReview(Antwoord antwoordStrategie) {
        super("Sprint Review");
        this.antwoordStrategie = antwoordStrategie;
    }

    @Override
    public void betreed(Speler speler) {
        this.status = new Status(speler);
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < vragen.length) {
            System.out.println("Je bent nu in de kamer: " + naam);
            System.out.println((huidigeVraag + 1) + ". " + vragen[huidigeVraag]);

            for (String optie : opties[huidigeVraag]) {
                System.out.println(optie);
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
                System.out.println();
            } else if (antwoord.equals("status")) {
                status.update();
                System.out.println();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.\n");
                return;
            } else if (antwoord.matches("[a-d]")) {
                boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
                updateScore(correct, speler);
                if (correct) {
                    huidigeVraag++;
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Monster 'Sprint Confusie' verschijnt! Probeer het opnieuw.\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Je hebt alle vragen juist beantwoord!\n");
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        return false; // niet gebruikt, strategie regelt dit
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ het letterantwoord: a, b, c of d");
        System.out.println("Gebruik 'status' om je huidige status te zien.");
        System.out.println("Gebruik 'help' om deze hulp te zien.");
        System.out.println("Gebruik 'naar andere kamer' om deze kamer te verlaten.");
    }
}