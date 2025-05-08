package Class;

public abstract class Kamer {
    protected String naam;
    protected boolean voltooid;

    public Kamer(String naam) {
        this.naam = naam;
        this.voltooid = false;
    }

    public abstract void betreed();
    public abstract void verwerkAntwoord(String antwoord);
}

