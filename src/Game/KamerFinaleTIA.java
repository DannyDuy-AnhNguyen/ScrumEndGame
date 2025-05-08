package Class;

import java.util.Scanner;

public class KamerFinaleTIA extends Kamer {

    public KamerFinaleTIA() {
        super("Finale TIA Kamer – Waarom Scrum?");
    }

    @Override
    public void betreed() {
        System.out.println("Welkom in de laatste kamer: " + naam);
        System.out.println("Wat is het ultieme doel van Scrum?");
        System.out.println("a) Strikte processen volgen");
        System.out.println("b) Zo snel mogelijk software opleveren");
        System.out.println("c) Transparantie, Inspectie en Aanpassing (TIA)");

        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine().trim().toLowerCase();
        verwerkAntwoord(antwoord);
    }

    @Override
    public void verwerkAntwoord(String antwoord) {
        if (antwoord.equals("c")) {
            System.out.println("Gefeliciteerd! Je begrijpt het hart van Scrum en hebt het spel voltooid!");
            voltooid = true;
        } else {
            System.out.println("Fout! Monster 'Scrum Misverstanden' probeert je tegen te houden!");
        }
    }
}
