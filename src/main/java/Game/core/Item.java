package Game.core;

public class Item {
    private String naam;
    private String effect; // Bijvoorbeeld: "hint", "kill", "extra"

    public Item(String naam, String effect) {
        this.naam = naam;
        this.effect = effect;
    }

    public String getNaam() {
        return naam;
    }

    public String getEffect() {
        return effect;
    }

    @Override
    public String toString() {
        return naam + " (" + effect + ")";
    }
}

