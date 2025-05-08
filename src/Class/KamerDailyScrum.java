package Class;

import java.util.Scanner;

public class KamerDailyScrum extends Kamer {

    public KamerDailyScrum() {
        super("Daily Scrum");
    }

    @Override
    public void betreed() {
        System.out.println("Je betreedt de kamer: " + naam);
        System.out.println("Wie zou in een Daily Scrum zeggen: 'Ik ben gisteren begonnen met taak X, maar had een blokkade bij de testomgeving'?");
        System.out.println("a) Scrum Master");
        System.out.println("b) Developer");
        System.out.println("c) Product Owner");

        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine().trim().toLowerCase();
        verwerkAntwoord(antwoord);
    }

    @Override
    public void verwerkAntwoord(String antwoord) {
        if (antwoord.equals("b")) {
            System.out.println("Goed! De Developer deelt voortgang en blokkades.");
            voltooid = true;
        } else {
            System.out.println("Fout! Monster 'Vertraging' blokkeert je pad!");
        }
    }
}
