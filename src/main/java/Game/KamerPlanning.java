package Game;

import java.util.Scanner;

public class KamerPlanning extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Status status;

    public KamerPlanning(Antwoord antwoordStrategie) {
        super("Sprint Planning");
        this.antwoordStrategie = antwoordStrategie;
    }

    @Override
    public void betreedIntro() {
        System.out.println();
        System.out.println("Je bent nu in de kamer: " + naam);
        deur.toonStatus();
        System.out.println();
    }

    @Override
    public void verwerkFeedback(int huidigeVraag) {
        if (huidigeVraag == 0) {
            System.out.println("Het is iemand die niet in de scrum werkt");
        } else if (huidigeVraag == 1) {
            System.out.println("Meeste sprints duren van 1 tot 2 weken. Misschien zelfs een maand.");
        }
    }

//    @Override
    public void verwerkOpdracht(int huidigeVraag){
        if (huidigeVraag == 0) {
            System.out.println("Wie neemt deel aan de Sprint Planning?");
            System.out.println("a) Alleen de Scrum Master");
            System.out.println("b) Product Owner en Scrum Master");
            System.out.println("c) Product Owner Scum Master en het hele Development Team");
            System.out.println("d) Product Owner Scrum Master en het hele Development Team");
        } else if (huidigeVraag == 1) {
            System.out.println("Wat wordt er tijdens de Sprint Planning vastgesteld?");
            System.out.println("a) Welke teamleden vakantie hebben");
            System.out.println("b) Wat het doel van de sprint is en welke backlog-items worden opgepakt");
            System.out.println("c) Hoe de vorige sprint geëvalueerd");
            System.out.println("d) Wat de vastgestelde items van de backlog zijn als de product owner tevreden is met het product.");
        }
    }

    @Override
    public void betreed(Speler speler) {
        if (!deur.isOpen()) {
            System.out.println("🚪 De deur is gesloten, je kunt deze kamer nog niet betreden.");
            deur.toonStatus();
            return;
        }

        this.status = new Status(speler);
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            betreedIntro();
            verwerkOpdracht(huidigeVraag);

//            if (huidigeVraag == 0) {
//                System.out.println("Wie neemt deel aan de Sprint Planning?");
//                System.out.println("a) Alleen de Scrum Master");
//                System.out.println("b) Product Owner en Scrum Master");
//                System.out.println("c) Product Owner Scum Master en het hele Development Team");
//                System.out.println("d) Product Owner Scrum Master en het hele Development Team");
//            } else if (huidigeVraag == 1) {
//                System.out.println("Wat wordt er tijdens de Sprint Planning vastgesteld?");
//                System.out.println("a) Welke teamleden vakantie hebben");
//                System.out.println("b) Wat het doel van de sprint is en welke backlog-items worden opgepakt");
//                System.out.println("c) Hoe de vorige sprint geëvalueerd");
//                System.out.println("d) Wat de vastgestelde items van de backlog zijn als de product owner tevreden is met het product.");
//            }

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
                    System.out.println("Je krijgt 10 punten.\n");
                } else {
                    speler.voegMonsterToe("Misverstand");
                    System.out.println("Fout! Monster 'Misverstand' verschijnt! Probeer het opnieuw.\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Je hebt beide vragen goed beantwoord!\n");
        setVoltooid();

        deur.setOpen(true); // deur open zetten na voltooiing
        System.out.println("De deur gaat open! Je kunt nu verder.");

        speler.voegVoltooideKamerToe(1); // pas aan naar juiste index
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        return false; // niet gebruikt hier
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ het letterantwoord: a, b, c of d");
        System.out.println("Gebruik 'status' om je huidige status te zien.");
        System.out.println("Gebruik 'help' om deze hulp te zien.");
        System.out.println("Gebruik 'naar andere kamer' om deze kamer te verlaten.");
    }
}