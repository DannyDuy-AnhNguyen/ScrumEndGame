package Game;

import java.util.Scanner;

public class KamerDailyScrum extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Status status;

    public KamerDailyScrum(Antwoord antwoordStrategie) {
        super("Daily Scrum");
        this.antwoordStrategie = antwoordStrategie;
        this.deur.setOpen(false); // deur start altijd dicht
    }

    // Intro text methode van elke kamer hetzelfde
    @Override
    public void betreedIntro(){
        System.out.println();
        System.out.println("Je bent nu in de kamer: " + naam);
        System.out.println();
    }

    // De feedback die je krijgt voor elke vraag die je goed beantwoord
    @Override
    public void verwerkFeedback(int huidigeVraag) {
        if (huidigeVraag == 0) {
            System.out.println("Het is iemand die niet in de scrum werkt");
        } else if(huidigeVraag == 1){
            System.out.println("Meeste sprints duren van 1 tot 2 weken. Misschien zelfs een maand.");
        }
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
                    verwerkFeedback(huidigeVraag);
                    huidigeVraag++;

                    // Deur open als laatste vraag juist beantwoord is
                    if (huidigeVraag == 2) {
                        setVoltooid();
                        deur.setOpen(true);
                        System.out.println("Je hebt alle vragen juist beantwoord! De deur gaat open.\n");
                        speler.voegVoltooideKamerToe(2);
                    } else {
                        deur.setOpen(false);
                        System.out.println("Correct! Je krijgt 10 punten.\n");
                    }

                } else {
                    deur.setOpen(false); // deur blijft dicht bij fout antwoord
                    speler.voegMonsterToe("Verlies van Focus");
                    System.out.println("Fout antwoord! De deur blijft gesloten en Monster 'Verlies van Focus' verschijnt!\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        // Niet gebruikt hier
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