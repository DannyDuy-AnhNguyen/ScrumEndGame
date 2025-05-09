package Game;

import java.util.List;

public class Speler {
    private String naam;
    private Kamer huidigeKamer;
    private List<Kamer> kamers;

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
                if (!kamer.isVraagBeantwoord() && !kamer.isInVraag()) { // Geen monsters als we in een vraag zitten
                    heeftMonsters = true;
                }
            }
        }

        System.out.println("Aantal voltooide kamers: " + voltooidAantal);
        System.out.println("Heb je nog monsters (impediments) op te lossen? " + (heeftMonsters ? "Ja" : "Nee"));

        System.out.println("Je kunt op elk moment 'status' intypen om te zien waar je bent, hoeveel kamers je al hebt gehaald, en of je nog monsters (impediments) hebt om op te lossen.\n");
    }
}
