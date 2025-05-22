package Game.core;

public class Status {
    private Speler speler;

    public Status(Speler speler) {
        this.speler = speler;
    }

    public void update() {
        System.out.println("\n=== STATUS ===");
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