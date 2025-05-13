package Game;

public abstract class Kamer {
    protected String naam;
    protected boolean voltooid = false;
    protected Antwoord antwoordStrategie;

    public Kamer(String naam, Antwoord strategie) {
        this.naam = naam;
        this.antwoordStrategie = strategie;
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

//    Strategy Pattern with Abstract method
    public abstract void betreed(Speler speler);

//    public abstract boolean verwerkAntwoord(String antwoord);

    // Toegevoegde help-methode
    public void toonHelp() {
        System.out.println();
        System.out.println("📜 Beschikbare commando's:");
        System.out.println("- a / b / c      : Kies een antwoordoptie");
        System.out.println("- help           : Toon deze uitleg");
        System.out.println("- status         : Bekijk je huidige status");
        System.out.println("- naar kamer [x] : Ga handmatig naar een andere kamer (als dit ondersteund is)");
        System.out.println();
    }
}