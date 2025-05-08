package Game;

import java.util.Scanner;

public class KamerPlanning extends Kamer {

    public KamerPlanning() {
        super("Sprint Planning");
    }

    @Override
    public void betreed(Speler speler) {
        boolean antwoordCorrect = false;
        Scanner scanner = new Scanner(System.in);

        while (!antwoordCorrect) {
            System.out.println("Je bent nu in de kamer: Sprint Planning.");
            System.out.println("Vraag: Wat is het doel van een sprint planning?");
            System.out.println("a) Het doel van de sprint is om de planning te maken");
            System.out.println("b) De sprintplanning moet ervoor zorgen dat het team goed begrijpt wat er gedaan moet worden");
            System.out.println("c) De sprintplanning is een kans om alle technische beslissingen te nemen");

            String antwoord = scanner.nextLine().trim().toLowerCase();
            antwoordCorrect = verwerkAntwoord(antwoord);
        }

        System.out.println("Je hebt het juiste antwoord gegeven!");
        setVoltooid(); // Zet de kamer als voltooid
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (antwoord.equals("b")) {
            System.out.println("Correct! De sprintplanning zorgt ervoor dat het team begrijpt wat er gedaan moet worden.");
            return true; // Correct antwoord
        } else {
            System.out.println("Fout! Monster 'Misverstand' verschijnt! Probeer het opnieuw.");
            return false; // Fout antwoord
        }
    }
}