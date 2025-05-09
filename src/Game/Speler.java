package Game;

import java.util.List;

public class Speler {
    private String naam;
    private Kamer huidigeKamer;
    private List<Kamer> kamers;
    private boolean heeftMonster;  // Houdt bij of er een monster actief is

    public Speler() {
        this.heeftMonster = false;  // Begin zonder monsters
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setHuidigeKamer(Kamer kamer) {
        this.huidigeKamer = kamer;
    }

    public Kamer getHuidigeKamer() {
        return huidigeKamer;
    }

    public void setKamers(List<Kamer> kamers) {
        this.kamers = kamers;
    }

    // Methode om monsterstatus bij te werken
    public void setHeeftMonster(boolean heeftMonster) {
        this.heeftMonster = heeftMonster;
    }

    // Verkrijg monsterstatus
    public boolean heeftMonster() {
        return heeftMonster;
    }

    public void status() {
        System.out.println("\n===== STATUS =====");

        if (huidigeKamer != null) {
            System.out.println("Je bent momenteel in kamer " + huidigeKamer.getKamerNummer() + ". " + huidigeKamer.getNaam());
        } else {
            System.out.println("Je bent nog niet in een kamer geweest.");
        }

        int voltooidAantal = 0;
        boolean heeftMonsters = false;

        if (kamers != null) {
            for (Kamer kamer : kamers) {
                if (kamer.isVoltooid()) {
                    voltooidAantal++;
                }
                // Controleer of er monsters zijn door te kijken of de kamer nog niet is voltooid en of er nog een actieve vraag is
                if (!kamer.isVraagBeantwoord() && !kamer.isInVraag()) {
                    heeftMonsters = true;
                }
            }
        }

        // Toon de voortgang van de speler
        System.out.println("Aantal voltooide kamers: " + voltooidAantal);
        // Toon monsterstatus op basis van of er nog monsters zijn
        System.out.println("Heb je nog monsters (impediments) op te lossen? " + (heeftMonsters || heeftMonster ? "Ja" : "Nee"));

        System.out.println("Je kunt op elk moment 'status' intypen om te zien waar je bent, hoeveel kamers je al hebt gehaald, en of je nog monsters (impediments) hebt om op te lossen.\n");
    }
}