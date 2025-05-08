package Game;

import java.util.Scanner;

public class KamerFinaleTIA extends Kamer {

    public KamerFinaleTIA() {
        super("Finale TIA Kamer – Waarom Scrum?");
    }

    @Override
    public void betreed(Speler speler) {
        boolean antwoordCorrect = false;
        Scanner scanner = new Scanner(System.in);

        while (!antwoordCorrect) {
            System.out.println("Welkom in de laatste kamer: " + naam);
            System.out.println("Wat is het ultieme doel van Scrum?");
            System.out.println("a) Strikte processen volgen");
            System.out.println("b) Zo snel mogelijk software opleveren");
            System.out.println("c) Transparantie, Inspectie en Aanpassing (TIA)");

            String antwoord = scanner.nextLine().trim().toLowerCase();
            antwoordCorrect = verwerkAntwoord(antwoord);
        }

        System.out.println("Gefeliciteerd! Je hebt het ultieme doel van Scrum goed beantwoord.");
        setVoltooid(); // Zet de kamer als voltooid
    }

    @Override
    public boolean verwerkAntwoord(String antwoord) {
        if (antwoord.equals("c")) {
            System.out.println("Correct! Het ultieme doel van Scrum is transparantie, inspectie en aanpassing.");
            return true; // Correct antwoord
        } else {
            System.out.println("Fout! Monster 'Scrum Misverstanden' verschijnt! Probeer het opnieuw.");
            return false; // Fout antwoord
        }
    }
}