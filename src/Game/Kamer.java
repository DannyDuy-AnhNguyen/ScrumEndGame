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

    // abstract methoden die concrete kamers moeten implementeren
    public abstract void betreed(Speler speler);

    public abstract boolean verwerkAntwoord(String antwoord, Speler speler);

    // Nieuw: methode om score te updaten per gegeven antwoord
    public void updateScore(boolean correct, Speler speler) {
        if (correct) {
            // verhoog streak met 1
            speler.setStreak(speler.getStreak() + 1);
            int bonus = speler.getStreak() * 10; // 10 punten per antwoord + bonus afhankelijk van streak
            speler.verhoogScore(bonus);
            System.out.println("Goed gedaan! Je krijgt " + bonus + " punten. (Streak: " + speler.getStreak() + ")");
        } else {
            // foute antwoord: -10 punten, reset streak
            speler.verlaagScore(10);
            speler.setStreak(0);
            System.out.println("Fout antwoord! Je verliest 10 punten en je streak is gereset.");
        }
    }

    // hulpfunctie voor de help-tekst
    public void toonHelp() {
        typeText("\n📜 Beschikbare commando's:", 30);
        typeText("- a / b / c / d     : Kies een antwoordoptie", 30);
        typeText("- help           : Toon deze uitleg", 30);
        typeText("- status         : Bekijk je huidige status", 30);
        typeText("- naar kamer [x] : Ga handmatig naar een andere kamer (als dit ondersteund is)\n", 30);
    }

    // typ-effect
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
}