package Game;

import java.util.Scanner;

public class KamerReview extends Kamer {

    public KamerReview() {
        super("Sprint Review");
    }

    @Override
    public void betreed(Speler speler) {
        System.out.println("Je bent nu in de kamer: Sprint Review.");
        System.out.println("Vraag: Wat gebeurt er tijdens een sprint review?");
        System.out.println("a) Het team deelt de resultaten van de sprint met de stakeholders.");
        System.out.println("b) Het team plant de taken voor de volgende sprint.");
        System.out.println("c) Het team reflecteert op de samenwerking.");

        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine().trim().toLowerCase();
        verwerkAntwoord(antwoord);
    }

    @Override
    public void verwerkAntwoord(String antwoord) {
        if (antwoord.equals("a")) {
            System.out.println("Goed! Tijdens de sprint review deelt het team de resultaten.");
        } else {
            System.out.println("Fout! Monster 'Slechte Communicatie' verschijnt!");
        }
    }
}