package Game;

import java.util.Scanner;

//de context klasse van AntwoordReview

public class KamerReview extends Kamer {
    private int huidigeVraag = 0;
    private final Antwoord antwoordStrategie;

    public KamerReview(Antwoord strategie) {
        super("Sprint Review");
        this.antwoordStrategie = strategie;
    }

    //    Strategy Pattern with Abstract method
    @Override
    public void betreed(Speler speler) {
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 3) {
            System.out.println("Je bent nu in de kamer: " + naam);

            if (huidigeVraag == 0) {
                System.out.println("1. Wanneer wordt er een sprintreview gehouden?");
                System.out.println("a) Aan het begin van de sprint");
                System.out.println("b) Tijdens de sprint");
                System.out.println("c) Aan het einde van de sprint");
            } else if (huidigeVraag == 1) {
                System.out.println("2. Wat is het belangrijkste doel van de Sprint Review?");
                System.out.println("a) De Scrum Master Evalueren");
                System.out.println("b) Het increment inspecteren en feedback verzamelen");
                System.out.println("c) De volgende sprint alvast plannen");
                System.out.println("d) Vorige sprint doornemen");
            } else if (huidigeVraag == 2) {
                System.out.println("3. De voordelen van een Sprint Review zijn...?");
                System.out.println("a) Meer vergaderingen = meer productiviteit");
                System.out.println("b) Transparantie, snelle feedback, alignment met stakeholders");
                System.out.println("c) Langer werken zonder pauzes");
                System.out.println("d) De product owner tevreden houden");
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
                    System.out.println("Monster 'Sprint Confusie' verschijnt! Probeer het opnieuw.\n");
                }
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Je hebt alle vragen juist beantwoord!\n");
        setVoltooid();
    }

//    @Override
//    public boolean verwerkAntwoord(String antwoord) {
//        if (huidigeVraag == 0) {
//            return antwoord.equals("c");
//        } else if (huidigeVraag == 1) {
//            return antwoord.equals("b");
//        } else if (huidigeVraag == 2) {
//            return antwoord.equals("b");
//        } else {
//            return false;
//        }
//    }
}