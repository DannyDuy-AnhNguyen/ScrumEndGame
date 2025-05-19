package Game;

import java.util.Scanner;

public class KamerReview extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Deur deur;

    public KamerReview(Antwoord antwoordStrategie, Deur deur) {
        super("Sprint Review");
        this.antwoordStrategie = antwoordStrategie;
        this.deur = deur;
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 3) {
            System.out.println("Je bent nu in de kamer: " + naam);

            switch (huidigeVraag) {
                case 0 -> {
                    System.out.println("1. Wanneer wordt er een sprintreview gehouden?");
                    System.out.println("a) Aan het begin van de sprint");
                    System.out.println("b) Tijdens de sprint");
                    System.out.println("c) Aan het einde van de sprint");
                }
                case 1 -> {
                    System.out.println("2. Wat is het belangrijkste doel van de Sprint Review?");
                    System.out.println("a) De Scrum Master evalueren");
                    System.out.println("b) Het increment inspecteren en feedback verzamelen");
                    System.out.println("c) De volgende sprint alvast plannen");
                    System.out.println("d) Vorige sprint doornemen");
                }
                case 2 -> {
                    System.out.println("3. De voordelen van een Sprint Review zijn...?");
                    System.out.println("a) Meer vergaderingen = meer productiviteit");
                    System.out.println("b) Transparantie, snelle feedback, alignment met stakeholders");
                    System.out.println("c) Langer werken zonder pauzes");
                    System.out.println("d) De product owner tevreden houden");
                }
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
            } else if (antwoord.equals("status")) {
                speler.status();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.\n");
                return;
            } else if (antwoord.matches("[a-d]")) {
                boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
                updateScore(correct, speler);

                if (correct) {
                    huidigeVraag++;
                    System.out.println("✅ Correct!\n");
                } else {
                    speler.voegMonsterToe("Sprint Confusie");
                    deur.setOpen(false);
                    deur.toonStatus();
                    System.out.println("❌ Fout! Monster 'Sprint Confusie' verschijnt! Probeer het opnieuw.\n");
                }

            } else {
                System.out.println("⚠️ Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("✅ Je hebt alle vragen juist beantwoord! De deur gaat open.");
        deur.setOpen(true);
        deur.toonStatus();
        setVoltooid();
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
        updateScore(correct, speler);
        return correct;
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ het letterantwoord: a, b, c of d");
        System.out.println("Gebruik 'status' om je huidige status te zien.");
        System.out.println("Gebruik 'help' om deze hulp te zien.");
        System.out.println("Gebruik 'naar andere kamer' om deze kamer te verlaten.");
    }
}
