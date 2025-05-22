package Game.core;

import java.util.ArrayList;
import java.util.List;

public class Speler {
    private String naam;
    private int positie;
    private int score = 0;
    private int streak = 0;
    private int sleutels = 1; // Start met 1 algemene sleutel

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
        score -= punten;
        if (score < 0) {
            score = 0;
        }
        notifyObservers();
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
        notifyObservers();
    }

    // === Sleutelsysteem ===
    public int getSleutels() {
        return sleutels;
    }

    public void voegSleutelToe() {
        sleutels++;
        System.out.println("🔑 Je hebt een sleutel verdiend! Totaal sleutels: " + sleutels);
        notifyObservers();
    }

    public boolean gebruikSleutel() {
        if (sleutels > 0) {
            sleutels--;
            System.out.println("🔓 Sleutel gebruikt. Resterende sleutels: " + sleutels);
            notifyObservers();
            return true;
        } else {
            System.out.println("❌ Je hebt geen sleutels om deze deur te openen.");
            return false;
        }
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
}