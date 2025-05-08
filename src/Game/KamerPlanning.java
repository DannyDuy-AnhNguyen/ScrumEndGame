package Game;

import java.util.Scanner;

public class KamerPlanning extends Kamer {

    public KamerPlanning() {
        super("Sprint Planning");
    }

    @Override
    public void betreed(Speler speler) {
        System.out.println("Je bent nu in de kamer: Sprint Planning.");
        System.out.println("Vraag: Wat is het doel van een sprint planning?");
        System.out.println("a) Het plannen van de taken voor de sprint.");
        System.out.println("b) Het voltooien van de sprint.");
        System.out.println("c) Het bespreken van de resultaten van de sprint.");

        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine().trim().toLowerCase();
        verwerkAntwoord(antwoord);
    }

    @Override
    public void verwerkAntwoord(String antwoord) {
        if (antwoord.equals("a")) {
            System.out.println("Correct! Het doel van de sprint planning is om taken voor de sprint in te plannen.");
        } else {
            System.out.println("Fout! Monster 'Verkeerde Focus' verschijnt!");
        }
    }
}