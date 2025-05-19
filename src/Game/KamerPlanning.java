package Game;

import java.util.Scanner;

public class KamerPlanning extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Deur deur;

    public KamerPlanning(Antwoord antwoordStrategie, Deur deur) {
        super("Sprint Planning");
        this.antwoordStrategie = antwoordStrategie;
        this.deur = deur;
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 2) {
            System.out.println("Je bent nu in de kamer: " + naam);

            if (huidigeVraag == 0) {
                System.out.println("Wie neemt deel aan de Sprint Planning?");
                System.out.println("a) Alleen de Scrum Master");
                System.out.println("b) Product Owner en Scrum Master");
                System.out.println("c) Product Owner Scrum Master en het hele Development Team");
                System.out.println("d) Product Owner Scrum Master en het hele Development Team");
            } else if (huidigeVraag == 1) {
                System.out.println("Wat wordt er tijdens de Sprint Planning vastgesteld?");
                System.out.println("a) Welke teamleden vakantie hebben");
                System.out.println("b) Wat het doel van de sprint is en welke backlog-items worden opgepakt");
                System.out.println("c) Hoe de vorige sprint geëvalueerd");
                System.out.println("d) Wat de vastgestelde items van de backlog zijn als de product owner tevreden is met het product.");
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
                    speler.voegMonsterToe("Misverstand");
                    deur.setOpen(false);
                    deur.toonStatus();
                    System.out.println("Fout antwoord! Monster 'Misverstand' verschijnt.\n");
                }

                System.out.println();
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("✅ Je hebt beide vragen goed beantwoord! De deur gaat open.");
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
