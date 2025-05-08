package Class;

import java.util.Scanner;

public class KamerPlanning extends Kamer {

    public KamerPlanning() {
        super("Sprint Planning");
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt de kamer: " + naam);
        System.out.println("Welke taak hoort NIET thuis in de sprint? (a, b of c)");
        System.out.println("a) Taken uit product backlog");
        System.out.println("b) Ongevraagde extra taken");
        System.out.println("c) Team taken die besproken zijn");

        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine();
        verwerkAntwoord(antwoord);
    }

    @Override
    public void verwerkAntwoord(String antwoord) {
        if (antwoord.equalsIgnoreCase("b")) {
            System.out.println("Goed! Je mag door.");
            voltooid = true;
        } else {
            System.out.println("Fout antwoord. Het monster 'Scope Creep' verschijnt!");
            // Hier zou je het monster kunnen toevoegen aan de speler
        }
    }
}

