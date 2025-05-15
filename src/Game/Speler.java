package Game;

import java.util.ArrayList;
import java.util.List;

public class Speler {
    private String naam;
    private int positie;
    private int score = 0;
    private int streak = 0;
    private List<Integer> voltooideKamers = new ArrayList<>();
    private List<String> monsters = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    // === Naam ===
    public void setNaam(String naam) {
        this.naam = naam;
        notifyObservers();
    }

    public String getNaam() {
        return naam;
    }

    // === Positie ===
    public void setPositie(int positie) {
        this.positie = positie;
        notifyObservers();
    }

    public int getPositie() {
        return positie;
    }

    // === Score en streak ===
    public int getScore() {
        return score;
    }

    public void verhoogScore(int punten) {
        score += punten;
        notifyObservers();
    }

    public void verlaagScore(int punten) {
        this.score -= punten;
        if (this.score < 0) {
            this.score = 0;
        }
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
        notifyObservers();
    }

    // === Voltooide kamers ===
    public void voegVoltooideKamerToe(int kamerIndex) {
        if (!voltooideKamers.contains(kamerIndex)) {
            voltooideKamers.add(kamerIndex);
            notifyObservers();
        }
    }

    public List<Integer> getVoltooideKamers() {
        return voltooideKamers;
    }

    // === Monsters ===
    public void voegMonsterToe(String monster) {
        if (!monsters.contains(monster)) {
            monsters.add(monster);
            notifyObservers();
        }
    }

    public void verwijderMonster(String monster) {
        monsters.remove(monster);
        notifyObservers();
    }

    public List<String> getMonsters() {
        return monsters;
    }

    // === Observer pattern ===
    public void voegObserverToe(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    // === Statusweergave ===
    public void status() {
        System.out.println("=== STATUS ===");
        System.out.println("Speler: " + naam);
        System.out.println("Huidige kamer: " + (positie + 1));
        System.out.println("Score: " + score);
        System.out.println("Streak: " + streak);
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