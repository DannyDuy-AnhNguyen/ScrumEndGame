package Game;

import java.util.Scanner;

public class KamerFinaleTIA extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Deur deur;

    public KamerFinaleTIA(Antwoord antwoordStrategie, Deur deur) {
        super("Finale TIA Kamer – Waarom Scrum?");
        this.antwoordStrategie = antwoordStrategie;
        this.deur = deur;
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 4) {
            System.out.println("Welkom in de laatste kamer: " + naam);

            switch (huidigeVraag) {
                case 0 -> {
                    System.out.println("1. Wat is het ultieme doel van Scrum?");
                    System.out.println("a) Strikte processen volgen");
                    System.out.println("b) Zo snel mogelijk software opleveren");
                    System.out.println("c) Transparantie, Inspectie en Aanpassing (TIA)");
                    System.out.println("d) Alleen werken in sprints");
                }
                case 1 -> {
                    System.out.println("2. Uit welk jaar is Scrum ontstaan?");
                    System.out.println("a) 1993");
                    System.out.println("b) 1995");
                    System.out.println("c) 2001");
                    System.out.println("d) 2010");
                }
                case 2 -> {
                    System.out.println("3. Welke Scrum waarde bevordert open communicatie?");
                    System.out.println("a) Lef");
                    System.out.println("b) Focus");
                    System.out.println("c) Transparantie");
                    System.out.println("d) Verantwoordelijkheid");
                }
                case 3 -> {
                    System.out.println("4. Bij welke sprint hoort deze user story?");
                    System.out.println("(Typ het sprintnummer of 'sprint 0')");
                }
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
            } else if (antwoord.equals("status")) {
                speler.status();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.");
                return;
            } else if (huidigeVraag == 3) {
                boolean juist = verwerkAntwoordOpenVraag(antwoord);
                updateScore(juist, speler);
                if (juist) {
                    huidigeVraag++;
                    System.out.println("Correct! De open vraag is goed beantwoord.\n");
                } else {
                    speler.voegMonsterToe("Sprint Verwarring");
                    deur.setOpen(false);
                    deur.toonStatus();
                    System.out.println("Fout! Monster 'Sprint Verwarring' verschijnt.\n");
                }
            } else if (antwoord.matches("[a-d]")) {
                boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag);
                updateScore(correct, speler);
                if (correct) {
                    huidigeVraag++;
                    System.out.println();
                } else {
                    speler.voegMonsterToe("Scrum Misverstanden");
                    deur.setOpen(false);
                    deur.toonStatus();
                    System.out.println("Fout! Monster 'Scrum Misverstanden' verschijnt!\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("🎉 Gefeliciteerd! Je hebt alle vragen goed beantwoord en de laatste kamer voltooid.");
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
