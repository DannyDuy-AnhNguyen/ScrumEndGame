package Class;

import java.util.ArrayList;
import java.util.List;

public class Speler {
    private String naam;
    private int positie;
    private List<Monster> monsters;

    public Speler(String naam) {
        this.naam = naam;
        this.monsters = new ArrayList<>();
        this.positie = 0;
    }

    public void status() {
        System.out.println("Speler: " + naam);
        System.out.println("Huidige kamer: " + (positie + 1));
        if (monsters.isEmpty()) {
            System.out.println("Geen actieve monsters.");
        } else {
            System.out.println("Actieve monsters:");
            for (Monster m : monsters) {
                System.out.println("- " + m.getNaam());
            }
        }
    }

    public void voegMonsterToe(Monster monster) {
        monsters.add(monster);
    }

    public void setPositie(int positie) {
        this.positie = positie;
    }
}
