package Game;

public class Speler {
    private String naam;
    private int positie;

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

    public void status() {
        System.out.println("Speler: " + naam);
        System.out.println("Huidige kamer: " + (positie + 1));
    }
}