package Class;

import java.util.Scanner;

public class KamerRetrospective extends Kamer {

    public KamerRetrospective() {
        super("Sprint Retrospective");
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt de kamer: " + naam);
        System.out.println("Wat is een goed onderwerp voor een retrospective?");
        System.out.println("a) Hoe het weekend van iedereen was");
        System.out.println("b) Wat goed ging, wat beter kan, en actiepunten");
        System.out.println("c) Wie verantwoordelijk is voor fouten");

        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine().trim().toLowerCase();
        verwerkAntwoord(antwoord);
    }

    @Override
    public void verwerkAntwoord(String antwoord) {
        if (antwoord.equals("b")) {
            System.out.println("Goed! Reflectie en verbetering zijn de kern.");
            voltooid = true;
        } else {
            System.out.println("Fout! Monster 'Blame Game' blokkeert de deur!");
        }
    }
}
