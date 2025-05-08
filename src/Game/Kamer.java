package Game;

public abstract class Kamer {
    protected String naam;
    protected boolean voltooid = false;

    public Kamer(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public boolean isVoltooid() {
        return voltooid;
    }

    public void setVoltooid() {
        this.voltooid = true;
    }

    public abstract void betreed(Speler speler);

    public abstract boolean verwerkAntwoord(String antwoord);
}
