package Game;

public class Scorebord {
    private Speler speler;

    public Scorebord(Speler speler) {
        this.speler = speler;
    }

    public void update() {
        System.out.println("\n=== SCOREBOARD ===");
        System.out.println("Speler: " + speler.getNaam());
        System.out.println("Score: " + speler.getScore());
        System.out.println("Voltooide kamers: " + speler.getVoltooideKamers().size());
        if (!speler.getMonsters().isEmpty()) {
            System.out.println("Actieve monsters: " + speler.getMonsters());
        } else {
            System.out.println("Geen actieve monsters.");
        }
        System.out.println("==================\n");
    }
}