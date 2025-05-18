package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spel {
    private Speler speler;
    private List<Kamer> kamers;
    private Scanner scanner;
    private Scorebord scoreboard;
    private KamerFactory kamerFactory;

    public Spel() {
        this.scanner = new Scanner(System.in);
        this.speler = new Speler();
        this.kamers = new ArrayList<>();
        this.scoreboard = new Scorebord(speler);
        this.kamerFactory = new KamerFactory();

        // Voeg kamers toe in de klasse "KamersFactory"
        //In deze lijst wordt de lijst met bestaande kamer keys opgeslagen en in de for each loop wordt de kamers toegevoegd in de array list.
        List<String> kamerKeys = kamerFactory.getKamerKeys();
        for (String key : kamerKeys) {
            kamers.add(kamerFactory.getKamer(key));
        }
    }

    public void start() {
        System.out.println("Welkom bij de Scrum Escape Game!");
        System.out.print("Wat is je naam? ");
        speler.setNaam(scanner.nextLine());

        System.out.println("Welkom, " + speler.getNaam() + "! Deze commando's kan je op elk moment gebruiken:");
        System.out.println("'status', 'help', 'ga naar kamer X' of 'stop'.");
        System.out.println("Kies a, b, c of d als je een vraag krijgt.");
        System.out.println();

        boolean gameInProgress = true;
        while (gameInProgress) {
            toonKamerOpties();
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("stop")) {
                System.out.println("Tot ziens!");
                gameInProgress = false;
            } else if (input.equals("status")) {
                scoreboard.update();
                System.out.println();
            } else if (input.equals("help")) {
                toonHelp();
                System.out.println();
            } else if (input.startsWith("ga naar kamer")) {
                try {
                    String argument = input.substring("ga naar kamer".length()).trim();
                    Kamer gekozenKamer = null;

                    // Probeer nummer
                    try {
                        int nummer = Integer.parseInt(argument) - 1;
                        if (nummer >= 0 && nummer < kamers.size()) {
                            gekozenKamer = kamers.get(nummer);
                        }
                    } catch (NumberFormatException e) {
                        // Blokkeer directe toegang tot de finale kamer
                        String normaleNaam = argument.replaceAll("\\s+", "").toLowerCase();
                        if (normaleNaam.equals("finaletiakamer–waaromscrum?")) {
                            System.out.println("Je dacht dat je slim was he😏? Dacht het niet!!!");
                            continue;
                        } else {
                            gekozenKamer = kamerFactory.getKamer(normaleNaam);
                        }
                    }


                    if (gekozenKamer != null) {
                        if (!gekozenKamer.isVoltooid()) {
                            gekozenKamer.betreed(speler);
                            scoreboard.update();
                            if (gekozenKamer.isVoltooid()) {
                                System.out.println("Deze kamer is voltooid!");
                            }
                        } else {
                            System.out.println("Deze kamer is al voltooid.");
                        }

                        if (alleKamersVoltooid()) {
                            System.out.println("Alle kamers voltooid! Je gaat nu naar de Finale TIA kamer.");
                            Kamer finaleKamer = kamerFactory.getKamer("Finale TIA Kamer – Waarom Scrum?");
                            finaleKamer.betreed(speler);
                            scoreboard.update();
                            gameInProgress = false;
                        }
                    } else {
                        System.out.println("Onbekende kamer: " + argument);
                        System.out.println();
                    }
                } catch (Exception e) {
                    System.out.println("Gebruik: ga naar kamer X");
                    System.out.println();
                }
            } else {
                System.out.println("Onbekend commando. Kies 'status', 'help', 'ga naar kamer X' of 'stop'.");
                System.out.println();
            }
        }
    }

//    Toont hoeveel kamers je nog moet voltooien exclusief je de finale kamer.
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
        System.out.println("'ga naar kamer X' - Ga naar een kamer via nummer of naam. Voorbeeld:");
        System.out.println("  'ga naar kamer 1' of 'ga naar kamer Scrum Board'");
        System.out.println("'stop' - Stop het spel.");
    }
}