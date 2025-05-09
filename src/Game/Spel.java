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
        kamers.add(new KamerDailyScrum());

        // Nummer de kamers (1 t/m 5)
        for (int i = 0; i < kamers.size(); i++) {
            kamers.get(i).setKamerNummer(i + 1);
        }

        // Geef de speler toegang tot deze lijst voor de status
        speler.setKamers(kamers);
    }

    public void start() {
        System.out.println("Welkom bij de Scrum Escape Game!");
        System.out.print("Wat is je naam? ");
        speler.setNaam(scanner.nextLine());

        System.out.println("Welkom, " + speler.getNaam() + "!");
        System.out.println("Je kunt op elk moment 'status' intypen om te zien waar je bent, hoeveel kamers je al hebt gehaald, en of je nog monsters (impediments) hebt om op te lossen.");
        System.out.println("Typ 'ga naar kamer X' om een kamer te betreden of 'stop' om het spel te verlaten.");

        boolean gameInProgress = true;
        while (gameInProgress) {
            toonKamerOpties();
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("stop")) {
                System.out.println("Tot ziens!");
                gameInProgress = false;
            } else if (input.equals("status")) {
                speler.status(); // Toon de status zonder verder spel voort te zetten
                continue; // Zorg ervoor dat we verder gaan met het spel zonder monster
            } else if (input.startsWith("ga naar kamer")) {
                try {
                    int nummer = Integer.parseInt(input.split(" ")[3]) - 1;
                    if (nummer >= 0 && nummer < kamers.size()) {
                        Kamer gekozenKamer = kamers.get(nummer);
                        if (gekozenKamer.isVoltooid()) {
                            System.out.println("Deze kamer is al voltooid.");
                        } else {
                            speler.setHuidigeKamer(gekozenKamer);
                            gekozenKamer.betreed(speler);
                            if (alleKamersVoltooid()) {
                                System.out.println("Alle kamers voltooid! Je gaat nu naar de Finale TIA kamer.");
                                Kamer finaleKamer = new KamerFinaleTIA();
                                finaleKamer.setKamerNummer(6);
                                speler.setHuidigeKamer(finaleKamer);
                                finaleKamer.betreed(speler);
                                gameInProgress = false;
                            }
                        }
                    } else {
                        System.out.println("Ongeldig kamernummer.");
                    }
                } catch (Exception e) {
                    System.out.println("Gebruik: ga naar kamer X (bijv. 'ga naar kamer 2')");
                }
            } else {
                System.out.println("Onbekend commando. Typ 'status' of 'ga naar kamer X' of 'stop'.");
            }
        }
    }

    private void toonKamerOpties() {
        System.out.println("Beschikbare kamers:");
        for (Kamer kamer : kamers) {
            if (!kamer.isVoltooid()) {
                System.out.println(kamer.getKamerNummer() + ". " + kamer.getNaam());
            }
        }
    }

    private boolean alleKamersVoltooid() {
        for (Kamer kamer : kamers) {
            if (!kamer.isVoltooid()) {
                return false;
            }
        }
        return true;
    }
}