package Game;

import java.util.Scanner;

public class KamerDailyScrum extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Status status;

    public KamerDailyScrum(Antwoord antwoordStrategie) {
        super("Daily Scrum");
        this.antwoordStrategie = antwoordStrategie;
    }

    @Override
    public void betreedIntro(){
        System.out.println();
        System.out.println("Je bent nu in de kamer: " + naam);
        System.out.println();
    }


    @Override
    public void betreed(Speler speler) {
        this.status = new Status(speler);
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            betreedIntro();

            if (huidigeVraag == 0) {
                System.out.println("1. Welke van de volgende rollen bestaat niet binnen Scrum?");
                System.out.println("a) Projectleider");
                System.out.println("b) Scrum Master");
                System.out.println("c) Development Team");
                System.out.println("d) Product Owner");
            } else if (huidigeVraag == 1) {
                System.out.println("2. Hoelang duurt een standaard sprint meestal?");
                System.out.println("a) 1 tot 4 weken");
                System.out.println("b) 1 tot 4 maanden");
                System.out.println("c) 1 tot 4 dagen");
                System.out.println("d) 1 tot 4 jaren");
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
                boolean antwoordCorrect = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);

                if (antwoordCorrect) {
                    speler.verhoogScore(10);
                    huidigeVraag++;
                    System.out.println("Correct! Je krijgt 10 punten.\n");
                } else {
                    speler.voegMonsterToe("Verlies van Focus");
                    System.out.println("Fout antwoord! De deur blijft gesloten en Monster 'Verlies van Focus' verschijnt!\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Je hebt alle vragen juist beantwoord! De deur gaat open.\n");
        setVoltooid();

        // Registreer dat deze kamer voltooid is (bijv. met index 2, pas aan naar jouw situatie)
        speler.voegVoltooideKamerToe(2);
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        // Dit gebruik je blijkbaar niet in deze kamer, want antwoorden worden direct in 'betreed' afgehandeld
        return false;
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ het letterantwoord: a, b, c of d");
        System.out.println("Gebruik 'status' om je huidige status te zien.");
        System.out.println("Gebruik 'help' om deze hulp te zien.");
        System.out.println("Gebruik 'naar andere kamer' om deze kamer te verlaten.");
    }
}