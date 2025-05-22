package Game.core;

import Game.kamer.Kamer;
import Game.kamer.KamerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spel {
    private Speler speler;
    private List<Kamer> kamers;
    private Scanner scanner;
    private Status status;
    private KamerFactory kamerFactory;
    private int sleutels;

    public Spel() {
        this.scanner = new Scanner(System.in);
        this.speler = new Speler();
        this.kamers = new ArrayList<>();
        this.status = new Status(speler);
        this.kamerFactory = new KamerFactory();
        this.sleutels = 1; // Begin met 1 algemene sleutel

        List<String> kamerKeys = kamerFactory.getKamerKeys();
        for (String key : kamerKeys) {
            Kamer kamer = kamerFactory.getKamer(key);
            kamer.getDeur().setOpen(false); // alle deuren beginnen dicht
            kamers.add(kamer);
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

        while (true) {
            toonKamerOpties();
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("stop")) {
                System.out.println("Tot ziens!");
                break;
            } else if (input.equals("status")) {
                status.update();
                toonSleutels();
            } else if (input.equals("help")) {
                toonHelp();
            } else if (input.startsWith("ga naar kamer")) {
                verwerkKamerCommando(input);
            } else {
                System.out.println("Onbekend commando. Kies 'status', 'help', 'ga naar kamer X' of 'stop'.");
            }
        }
    }

    private void verwerkKamerCommando(String input) {
        try {
            String argument = input.substring("ga naar kamer".length()).trim();
            Kamer gekozenKamer = null;

            try {
                int nummer = Integer.parseInt(argument) - 1;
                if (nummer >= 0 && nummer < kamers.size()) {
                    gekozenKamer = kamers.get(nummer);
                }
            } catch (NumberFormatException e) {
                gekozenKamer = kamerFactory.getKamer(argument.replaceAll("\\s+", "").toLowerCase());
            }

            if (gekozenKamer != null) {
                if (!gekozenKamer.getDeur().isOpen()) {
                    if (sleutels > 0 && !gekozenKamer.getNaam().toLowerCase().contains("finale")) {
                        // Open de kamer met een sleutel
                        gekozenKamer.getDeur().setOpen(true);
                        sleutels--;
                        System.out.println("Je gebruikte een algemene sleutel om de deur naar '" + gekozenKamer.getNaam() + "' te openen.");
                    } else {
                        System.out.println("De deur is gesloten. Je hebt geen sleutel of dit is de finale kamer.");
                        return;
                    }
                }

                if (!gekozenKamer.isVoltooid()) {
                    gekozenKamer.betreed(speler);
                    status.update();

                    if (gekozenKamer.isVoltooid()) {
                        System.out.println("Deze kamer is voltooid!");
                        if (!gekozenKamer.getNaam().toLowerCase().contains("finale")) {
                            sleutels++;
                            System.out.println("Je hebt een sleutel verdiend!");
                        }
                    }
                } else {
                    System.out.println("Deze kamer is al voltooid.");
                }

                // Check of alle normale kamers voltooid zijn en finale kamer nog niet open is
                if (alleNormaleKamersVoltooid() && !isFinaleKamerVoltooid()) {
                    Kamer finaleKamer = kamerFactory.getKamer("Finale TIA Kamer – Waarom Scrum?");
                    if (sleutels >= 5) {
                        if (!kamers.contains(finaleKamer)) {
                            finaleKamer.getDeur().setOpen(true);
                            kamers.add(finaleKamer);
                            System.out.println("Je hebt 5 sleutels verzameld! De finale deur is nu open.");
                        }

                        // Optioneel: automatisch doorsturen naar de finale kamer
                    System.out.println("Je hebt genoeg sleutels om naar de finale kamer te gaan! Je gaat nu automatisch naar de finale kamer!");
                    finaleKamer.betreed(speler);
                    status.update();
                    if (finaleKamer.isVoltooid()) {
                        System.out.println("Gefeliciteerd, je hebt het spel voltooid!");
                        System.exit(0);
                    }
                    return;
                    }
                }

                if (isFinaleKamerVoltooid()) {
                    printGefeliciteerdArt();
                    System.exit(0);
                }
            } else {
                System.out.println("Onbekende kamer: " + argument);
            }

        } catch (Exception e) {
            System.out.println("Gebruik: ga naar kamer X");
        }
    }

    private void printGefeliciteerdArt() {
        String art =
                "𝕲𝖊𝖋𝖊𝖑𝖎𝖈𝖎𝖙𝖊𝖊𝖗𝖉! 𝖏𝖊 𝖍𝖊𝖇𝖙 𝖍𝖊𝖙 𝖘𝖕𝖊𝖑 𝖛𝖔𝖑𝖙𝖔𝖔𝖎𝖉!\n" +
                        "  𝕮𝖔𝖓𝖌𝖗𝖆𝖙𝖘! 𝕿𝖎𝖒𝖊 𝖙𝖔 𝖈𝖊𝖑𝖊𝖇𝖗𝖆𝖙𝖊 🎉\n" +
                        "\n" +
                        "  𝕯𝖎𝖙 𝖎𝖘 𝖏𝖊 𝖈𝖗𝖔𝖜𝖓 𝖔𝖋 𝖛𝖎𝖈𝖙𝖔𝖗𝖞!\n" +
                        "  𝕬𝖑𝖑𝖊 𝖕𝖗𝖔𝖌𝖗𝖆𝖒𝖒𝖆 𝖎𝖘 𝖉𝖔𝖓𝖊, 𝖈𝖔𝖉𝖊𝖗.\n\n" +

                        "　　　　＿＿\n" +
                        "　　　🌸＞　　フ   I don't want likes I want ham sandwich\n" +
                        "　　　| 　_　 _ l        (edit: Got ham sandwich)\n" +
                        "　　　／` ミ_wノ\n" +
                        "　　 /　　　 　 |\n" +
                        "　　 /　 ヽ　　 ﾉ\n" +
                        "　  │　　|　|　|\n" +
                        "　／￣|　　 |　|　|\n" +
                        "　| (￣ヽ＿_ヽ_)__)\n" +
                        "　＼二つ\n";

        System.out.println(art);
    }

    private void toonKamerOpties() {
        System.out.println("Beschikbare kamers:");
        for (int i = 0; i < kamers.size(); i++) {
            if (!kamers.get(i).isVoltooid()) {
                System.out.println((i + 1) + ". " + kamers.get(i).getNaam());
            }
        }
    }

    private boolean alleNormaleKamersVoltooid() {
        for (Kamer kamer : kamers) {
            String naam = kamer.getNaam().toLowerCase();
            if (!kamer.isVoltooid() && !naam.contains("finale")) {
                return false;
            }
        }
        return true;
    }

    private boolean isFinaleKamerVoltooid() {
        for (Kamer kamer : kamers) {
            if (kamer.getNaam().toLowerCase().contains("finale") && kamer.isVoltooid()) {
                return true;
            }
        }
        return false;
    }

    private void toonSleutels() {
        System.out.println("Aantal algemene sleutels: " + sleutels);
        System.out.println();
    }

    private void toonHelp() {
        System.out.println("Help:");
        System.out.println("'status' - Bekijk je status en aantal sleutels.");
        System.out.println("'help' - Toon deze hulptekst.");
        System.out.println("'ga naar kamer X' - Ga naar een kamer die open is of gebruik een sleutel.");
        System.out.println("'stop' - Stop het spel.");
    }
}