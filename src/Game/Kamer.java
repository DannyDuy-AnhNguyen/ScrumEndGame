package Game;

public abstract class Kamer {
    protected String naam;

    public Kamer(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public abstract void betreed(Speler speler);
    public abstract void verwerkAntwoord(String antwoord);
}