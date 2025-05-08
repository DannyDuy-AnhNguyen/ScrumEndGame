package Game;

public abstract class Kamer {
    protected String naam;
    protected boolean voltooid = false;
    protected boolean vraagBeantwoord = false; // Toegevoegd om bij te houden of de vraag beantwoord is

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

    // Voeg deze methode toe om te controleren of de vraag is beantwoord
    public boolean isVraagBeantwoord() {
        return vraagBeantwoord;
    }

    // Methode om de vraagbeantwoord status bij te werken
    public void setVraagBeantwoord(boolean vraagBeantwoord) {
        this.vraagBeantwoord = vraagBeantwoord;
    }

    public abstract void betreed(Speler speler);

    public abstract boolean verwerkAntwoord(String antwoord);
}