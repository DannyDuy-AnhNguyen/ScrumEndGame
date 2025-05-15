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

    // Toon help-commando's
    public void toonHelp() {
        typeText("\n📜 Beschikbare commando's:", 30);
        typeText("- a / b / c / d     : Kies een antwoordoptie", 30);
        typeText("- help           : Toon deze uitleg", 30);
        typeText("- status         : Bekijk je huidige status", 30);
        typeText("- naar kamer [x] : Ga handmatig naar een andere kamer (als dit ondersteund is)\n", 30);
    }

    // Typ-effect
    public void typeText(String text, int delay) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    // ✅ Deur- en monsterhandeling
    public void deurActie(boolean juist, String monsterNaam) {
        if (juist) {
            typeText("✅ Het antwoord is correct. De deur opent langzaam... Je mag verder!", 30);
            setVoltooid();
        } else {
            typeText("❌ Fout antwoord! De deur blijft gesloten.", 30);
            typeText("👾 Monster verschijnt: " + monsterNaam + "!", 30);
        }
    }
}
