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

    // Toegevoegde help-methode
    public void toonHelp() {
        typeText("\n📜 Beschikbare commando's:", 30);
        typeText("- a / b / c / d     : Kies een antwoordoptie", 30);
        typeText("- help           : Toon deze uitleg", 30);
        typeText("- status         : Bekijk je huidige status", 30);
        typeText("- naar kamer [x] : Ga handmatig naar een andere kamer (als dit ondersteund is)\n", 30);
    }

    // ✅ NIEUWE typ-effect methode
    public void typeText(String text, int delay) {
        // Deze versie blokkeert gebruikersinvoer totdat de tekst volledig getypt is.
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay); // Wacht een beetje tussen de letters
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // Zorgt voor een nieuwe regel na het typen van de tekst
    }
}