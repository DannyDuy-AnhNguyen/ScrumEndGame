package Game;

import java.util.Scanner;

public class KamerFinaleTIA extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;

    // Constructor met Antwoord parameter
    public KamerFinaleTIA(Antwoord antwoordStrategie) {
        super("Finale TIA Kamer – Waarom Scrum?");
        this.antwoordStrategie = antwoordStrategie;
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 4) {
            System.out.println("Welkom in de laatste kamer: " + naam);

            switch (huidigeVraag) {
                case 0:
                    System.out.println("1. Wat vind je van Scrum?");
                    System.out.println("a) Uitstekend");
                    System.out.println("b) Neutraal");
                    System.out.println("c) Slecht");
                    break;
                case 1:
                    System.out.println("2. Uit welk jaar is Scrum ontstaan?");
                    System.out.println("a) 1993");
                    System.out.println("b) 1995");
                    System.out.println("c) 2001");
                    System.out.println("d) 2010");
                    break;
                case 2:
                    System.out.println("3. Is Scrum gay?");
                    System.out.println("a) Ja");
                    System.out.println("b) Ja");
                    System.out.println("c) Ja");
                    System.out.println("d) Ja");
                    break;
                case 3:
                    System.out.println("4. Bij welke sprint hoort deze userstory?");
                    break;
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
                System.out.println();
            } else if (antwoord.equals("status")) {
                speler.status();
                System.out.println();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.");
                return;
            } else if (huidigeVraag == 3 && verwerkAntwoordOpenVraag(antwoord)) {
                huidigeVraag++;
                System.out.println("Je hebt de open vraag goed beantwoord!\n");
            } else if (antwoord.matches("[a-d]")) {
                boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
                if (correct) {
                    huidigeVraag++;
                    System.out.println();
                } else {
                    System.out.println("Fout antwoord! De deur blijft gesloten en Monster 'Scrum Misverstanden' verschijnt!\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Gefeliciteerd! Je hebt alle vragen goed beantwoord en de laatste kamer voltooid.");
        setVoltooid();
    }

    // verwerkAntwoord bestaat nu alleen nog om updateScore te doen via strategie
    // maar kan eventueel ook weg, als dat al in AntwoordFinaleTIA zit
    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
        updateScore(correct, speler);
        return correct;
    }

    public boolean verwerkAntwoordOpenVraag(String antwoord) {
        return antwoord.matches("^(0|sprint 0|nul|sprintnul|sprint0)$");
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ 'a', 'b', 'c' of 'd' om een antwoord te kiezen.");
        System.out.println("Typ 'status' om je huidige status te zien.");
        System.out.println("Typ 'naar andere kamer' om deze kamer te verlaten.");
        System.out.println("Typ 'help' om deze hulp te tonen.");
    }
}