package Game;

import java.util.Scanner;

public class KamerScrumBoard extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Status status;

    public KamerScrumBoard(Antwoord antwoordStrategie) {
        super("Scrum Board");
        this.antwoordStrategie = antwoordStrategie;
        // Deur standaard dicht, tenzij anders ingesteld in Kamer
    }

    @Override
    public void betreedIntro(){
        System.out.println();
        System.out.println("Je bent nu in de kamer: " + naam);
        deur.toonStatus();
        System.out.println();
    }

    //    De feedback die je krijgt voor elke vraag die je goed beantwoord
        @Override
    public void verwerkFeedback(int huidigeVraag) {
        if (huidigeVraag == 0) {
            System.out.println("Epic is de deelonderdeel van een project onderwerp, Userstory de deel van je Epic en Taken de deel van de je userstory");
        } else if(huidigeVraag == 1){
            System.out.println("Product backlog is waar alles userstories staan die nog gedaan moet worden,\nSprint backlog de userstories voor de sprint die je in deze sprint wilt maken,\n" +
                    "To Do wat er vandaag gedaan moet worden,\nDoing welke teamlid aan het uitvoeren is\nTesting wat nog getest moet worden\nDone wat er al gedaan is.");
        }
    }

    @Override
    public void verwerkOpdracht(int huidigeVraag){
        if (huidigeVraag == 0) {
            System.out.println("1. Wat is de volgorde om een Scrum-proces te maken?");
            System.out.println("a) Epics > Userstories > Taken");
            System.out.println("b) Epics > Taken > Userstories");
            System.out.println("c) Userstories > Epics > Taken");
        } else if (huidigeVraag == 1) {
            System.out.println("2. Welke borden gebruik je in het Scrumboard?");
            System.out.println("a) Product Backlog > Sprint Backlog > Doing > Testing > Done");
            System.out.println("b) Product Backlog > Sprint Backlog > To Do > Doing > Testing > Done");
            System.out.println("c) Sprint Backlog > To Do > Doing > Testing > Done");
        }
    }

    @Override
    public void verwerkResultaat(boolean correct, Speler speler){
        if (correct) {
            System.out.println("Correct!");
            updateScore(true, speler);
            verwerkFeedback(huidigeVraag);
            huidigeVraag++;
            System.out.println();
        } else {
            System.out.println("Fout, probeer opnieuw.");
            updateScore(false, speler);
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
            verwerkOpdracht(huidigeVraag);  //De vragen worden uit deze abstracte methode opgeroepen

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
            } else if (antwoord.matches("[a-c]")) {
                boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag); // controleerd de resultaat wat de gebruiker gekozen heeft.
                verwerkResultaat(correct, speler); // toont de resultaat of de speler het goed heeft of niet
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Je hebt alle vragen juist beantwoord!\n");
        setVoltooid();

        // Deur openen na voltooiing
        deur.setOpen(true);
        System.out.println("De deur gaat open! Je kunt nu verder.");

        // Kamer als voltooid registreren (pas nummer aan indien nodig)
        speler.voegVoltooideKamerToe(1);
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        return false; // strategie regelt het
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ het letterantwoord: a, b of c");
        System.out.println("Gebruik 'status' om je huidige status te zien.");
        System.out.println("Gebruik 'help' om deze hulp te zien.");
        System.out.println("Gebruik 'naar andere kamer' om deze kamer te verlaten.");
    }
}