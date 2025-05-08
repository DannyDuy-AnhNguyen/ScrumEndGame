package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spel {
    private Speler speler;
    private List<Kamer> kamers;
    private Scanner scanner;

    public Spel() {
        this.scanner = new Scanner(System.in);
        this.speler = new Speler();
        this.kamers = new ArrayList<>();

        // Voeg kamers toe
        kamers.add(new KamerPlanning());
        kamers.add(new KamerReview());
        kamers.add(new KamerScrumBoard());
        kamers.add(new KamerRetrospective());
        kamers.add(new KamerFinaleTIA());
    }

    public void start() {
        System.out.println("Welkom bij de Scrum Escape Game!");
        System.out.print("Wat is je naam? ");
        speler.setNaam(scanner.nextLine());

        System.out.println("Welkom, " + speler.getNaam() + "! Typ 'status' of 'ga naar kamer X' of 'stop'.");

        toonKamerOpties();

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("stop")) {
                System.out.println("Tot ziens!");
                break;
            } else if (input.equals("status")) {
                speler.status();
            } else if (input.startsWith("ga naar kamer")) {
                try {
                    int nummer = Integer.parseInt(input.split(" ")[3]) - 1;
                    if (nummer >= 0 && nummer < kamers.size()) {
                        speler.setPositie(nummer);
                        kamers.get(nummer).betreed(speler);
                    } else {
                        System.out.println("Ongeldig kamernummer.");
                    }
                } catch (Exception e) {
                    System.out.println("Gebruik: ga naar kamer X");
                }
            } else {
                System.out.println("Onbekend commando.");
            }
        }
    }

    private void toonKamerOpties() {
        System.out.println("Beschikbare kamers:");
        for (int i = 0; i < kamers.size(); i++) {
            System.out.println((i + 1) + ". " + kamers.get(i).getNaam());
        }
    }
}