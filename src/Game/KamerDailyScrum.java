package Game;

import java.util.Scanner;

public class KamerDailyScrum extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Deur deur;

    public KamerDailyScrum(Antwoord antwoordStrategie, Deur deur) {
        super("Daily Scrum");
        this.antwoordStrategie = antwoordStrategie;
        this.deur = deur;
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            System.out.println("Je betreedt de kamer: " + naam);

            switch (huidigeVraag) {
                case 0 -> {
                    System.out.println("1. Welke van de volgende rollen bestaat niet binnen Scrum?");
                    System.out.println("a) Projectleider");
                    System.out.println("b) Scrum Master");
                    System.out.println("c) Development Team");
                    System.out.println("d) Product Owner");
                }
                case 1 -> {
                    System.out.println("2. Hoelang duurt een standaard sprint meestal?");
                    System.out.println("a) 1 tot 4 weken");
                    System.out.println("b) 1 tot 4 maanden");
                    System.out.println("c) 1 tot 4 dagen");
                    System.out.println("d) 1 tot 4 jaren");
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
                } else {
                    speler.voegMonsterToe("Verlies van Focus");
                    deur.setOpen(false);
                    deur.toonStatus();
                    System.out.println("Monster 'Verlies van Focus' verschijnt! Probeer het opnieuw.\n");
                }

                System.out.println();
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
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
