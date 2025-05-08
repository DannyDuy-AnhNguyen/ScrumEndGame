package Game;

import java.util.ArrayList;
import java.util.List;

public class Speler {
    private String naam;
    private int positie;
    private List<String> monstersOpgelost; // Om op te slaan welke monsters opgelost zijn

    public Speler() {
        this.monstersOpgelost = new ArrayList<>();
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void setPositie(int positie) {
        this.positie = positie;
    }

    public int getPositie() {
        return positie;
    }

    public void voegMonsterToe(String monster) {
        monstersOpgelost.add(monster);
    }

    public boolean heeftMonsterOpTeLossen() {
        return monstersOpgelost.size() > 0;
    }

    public void status() {
        System.out.println("Speler: " + naam);
        System.out.println("Huidige kamer: " + (positie + 1));
        System.out.println("Aantal voltooide kamers: " + monstersOpgelost.size());
        if (heeftMonsterOpTeLossen()) {
            System.out.println("Er zijn nog monsters (impediments) die je moet oplossen!");
        } else {
            System.out.println("Alle monsters zijn opgelost!");
        }
    }
}