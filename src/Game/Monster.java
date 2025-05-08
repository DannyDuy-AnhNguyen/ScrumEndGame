package Game;

public class Monster {
    private String naam;
    private String effect;

    public Monster(String naam, String effect) {
        this.naam = naam;
        this.effect = effect;
    }

    public String getNaam() {
        return naam;
    }

    public void versla() {
        System.out.println("Je hebt het monster verslagen: " + naam);
    }
}