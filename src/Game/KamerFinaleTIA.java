package Game;

import java.util.Scanner;

public class KamerFinaleTIA extends Kamer {
    private int huidigeVraag = 0;
    private final Antwoord antwoordStrategie;


    public KamerFinaleTIA(Antwoord strategie) {
        super("Finale TIA Kamer – Waarom Scrum?");
        this.antwoordStrategie = strategie;
    }

    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 3) {
            System.out.println("Welkom in de laatste kamer: " + naam);

            if (huidigeVraag == 0) {
                System.out.println("1. Wat vind je van Scrum?");
                System.out.println("a) Uitstekend");
                System.out.println("b) Neutraal");
                System.out.println("c) Slecht");
            } else if (huidigeVraag == 1) {
                System.out.println("2. Uit welk jaar is Scrum ontstaan?");
                System.out.println("a) 1993");
                System.out.println("b) 1995");
                System.out.println("c) 2001");
                System.out.println("d) 2010");
            } else if (huidigeVraag == 2) {
                System.out.println("3. Is Scrum gay?");
                System.out.println("a) Ja");
                System.out.println("b) Ja");
                System.out.println("c) Ja");
                System.out.println("d) Ja");
            }

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
                System.out.println();
            } else if (antwoord.equals("status")) {
                speler.status();
                System.out.println();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.\n");
                return;
            } else if (antwoord.matches("[a-d]")) {
                if (antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag)) {
                    huidigeVraag++;
                    System.out.println();
                } else {
                    System.out.println("Monster 'Scrum Misverstanden' verschijnt! Probeer het opnieuw.\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Gefeliciteerd! Je hebt alle vragen goed beantwoord en de laatste kamer voltooid.\n");
        setVoltooid();
    }

//    @Override
//    public boolean verwerkAntwoord(String antwoord, int vraagIndex) {
//        if (vraagIndex == 0) {
//            return antwoord.equals("a");
//        } else if (vraagIndex == 1) {
//            return antwoord.equals("a");
//        } else if (vraagIndex == 2) {
//            return antwoord.matches("[a-d]");
//        }
//        return false;
//    }
}