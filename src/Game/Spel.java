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
        // Bij de toegevoegde kamers zijn ook de bijbehorende antwoord (Strategy Klasse) bij toegevoegd.
        kamers.add(new KamerPlanning(new AntwoordPlanning()));
        kamers.add(new KamerReview(new AntwoordReview()));
        kamers.add(new KamerScrumBoard(new AntwoordScrumBoard()));
        kamers.add(new KamerRetrospective(new AntwoordRetrospective()));
        kamers.add(new KamerDailyScrum(new AntwoordDailyScrum()));
    }

    public void start() {
        System.out.println("Welkom bij de Scrum Escape Game!");
        System.out.print("Wat is je naam? ");
        speler.setNaam(scanner.nextLine());

        System.out.println("Welkom, " + speler.getNaam() + "! Deze commando's kan je op elk moment gebruiken:");
        System.out.println("'status', 'help', 'ga naar kamer X' of 'stop'.");
        System.out.println("Kies a, b of c als je een vraag krijgt.");
        System.out.println();  // Extra enter voor overzichtelijkheid

        boolean gameInProgress = true;
        while (gameInProgress) {
            toonKamerOpties();
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("stop")) {
                System.out.println("Tot ziens!");
                gameInProgress = false;
            } else if (input.equals("status")) {
                speler.status();
                System.out.println(); // Extra enter voor overzichtelijkheid
            } else if (input.equals("help")) {
                toonHelp();
                System.out.println(); // Extra enter na help
            } else if (input.startsWith("ga naar kamer")) {
                try {
                    int nummer = Integer.parseInt(input.split(" ")[3]) - 1;
                    if (nummer >= 0 && nummer < kamers.size()) {
                        Kamer gekozenKamer = kamers.get(nummer);
                        if (!gekozenKamer.isVoltooid()) {
                            gekozenKamer.betreed(speler);
                            // Als de kamer is voltooid, markeer deze als voltooid.
                            if (gekozenKamer.isVoltooid()) {
                                System.out.println("Deze kamer is voltooid!");
                            }
                        } else {
                            System.out.println("Deze kamer is al voltooid.");
                        }

                        // Nadat een kamer is voltooid, geef de speler de keuze om naar een andere kamer te gaan.
                        if (alleKamersVoltooid()) {
                            System.out.println("Alle kamers voltooid! Je gaat nu naar de Finale TIA kamer.");
                            Kamer finaleKamer = new KamerFinaleTIA(new AntwoordFinalTIA());
                            finaleKamer.betreed(speler);
                            gameInProgress = false;  // Einde van het spel
                        }
                    } else {
                        System.out.println("Ongeldig kamernummer.");
                        System.out.println();  // Extra enter na foutmelding
                    }
                } catch (Exception e) {
                    System.out.println("Gebruik: ga naar kamer X");
                    System.out.println();  // Extra enter na foutmelding
                }
            } else {
                System.out.println("Onbekend commando. Kies 'status', 'help', 'ga naar kamer X' of 'stop'.");
                System.out.println();  // Extra enter na onbekend commando
            }
        }
    }

    private void toonKamerOpties() {
        System.out.println("Beschikbare kamers:");
        for (int i = 0; i < kamers.size(); i++) {
            if (!kamers.get(i).isVoltooid()) {
                System.out.println((i + 1) + ". " + kamers.get(i).getNaam());
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

    private void toonHelp() {
        System.out.println("Help:");
        System.out.println("Gebruik de volgende commando's:");
        System.out.println("'status' - Bekijk je huidige status.");
        System.out.println("'help' - Toon deze hulptekst.");
        System.out.println("'ga naar kamer X' - Ga naar de kamer die je wilt betreden (X = kamer nummer).");
        System.out.println("'stop' - Stop het spel.");
    }
}