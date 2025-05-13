package Game;

import java.util.ArrayList;
import java.util.List;

public class Speler {
    private String naam;
    private int positie;
    private List<Integer> voltooideKamers = new ArrayList<>();
    private List<String> monsters = new ArrayList<>();

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

    public void voegVoltooideKamerToe(int kamerIndex) {
        if (!voltooideKamers.contains(kamerIndex)) {
            voltooideKamers.add(kamerIndex);
        }
    }

    public void voegMonsterToe(String monster) {
        if (!monsters.contains(monster)) {
            monsters.add(monster);
        }
    }

    public void verwijderMonster(String monster) {
        monsters.remove(monster);
    }

    public void status() {
        System.out.println("=== STATUS ===");
        System.out.println("Speler: " + naam);
        System.out.println("Huidige kamer: " + (positie + 1));
        System.out.println("Voltooide kamers: " + voltooideKamers.size());

        if (!monsters.isEmpty()) {
            System.out.println("Actieve monsters:");
            for (String monster : monsters) {
                System.out.println("👾 " + monster);
            }
        } else {
            System.out.println("Geen actieve monsters.");
        }

        System.out.println("====================");
    }
}