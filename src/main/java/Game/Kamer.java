package Game;

public abstract class Kamer {
    protected String naam;
    protected boolean voltooid = false;
    protected Deur deur;

    public Kamer(String naam) {
        this.naam = naam;
        this.deur = new Deur();
        deur.setOpen(true); // deur standaard open bij aanmaken kamer
    }

    public String getNaam() {
        return naam;
    }

    public boolean isVoltooid() {
        return voltooid;
    }

    public void setVoltooid() {
        this.voltooid = true;
        deur.setOpen(true); // deur open bij voltooiing kamer
    }

    public Deur getDeur() {
        return deur;
    }

    // Abstracte methoden die concrete kamers moeten implementeren
    public abstract void betreedIntro();

    public abstract void betreed(Speler speler);

    public abstract boolean verwerkAntwoord(String antwoord, Speler speler);

    public abstract void verwerkFeedback(int huidigeVraag);

//    Bevat de vragen van de bestaande vragen oftewel de opdrachten om de kamer te voltooien
    public abstract void verwerkOpdracht(int huidigeVraag);

//    Deze functie controleert de resultaten van de gemaakte vraag.
    public abstract void verwerkResultaat(boolean antwoordstrategie, Speler speler);

    // Methode om score te updaten per gegeven antwoord
    public void updateScore(boolean correct, Speler speler) {
        if (correct) {
            speler.setStreak(speler.getStreak() + 1);
            int bonus = speler.getStreak() * 10;
            speler.verhoogScore(bonus);
            System.out.println("Goed gedaan! Je krijgt " + bonus + " punten. (Streak: " + speler.getStreak() + ")");
        } else {
            speler.verlaagScore(10);
            speler.setStreak(0);
            System.out.println("Fout antwoord! Je verliest 10 punten en je streak is gereset.");
        }
    }

    /**
     * Methode om na een beurt (antwoord) de deur te openen of te sluiten.
     * Bij fout antwoord deur dicht, bij goed antwoord deur blijft zoals die is (meestal open).
     */
    public void beurtVoltooid(boolean correct) {
        if (!correct) {
            deur.setOpen(false);
        }
        // Geen actie bij correct antwoord, deur blijft open of zoals hij was
    }

    // Hulpfunctie voor de help-tekst
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
}