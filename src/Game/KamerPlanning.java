package Game;

public class KamerPlanning extends Kamer {
    @Override
    public String getNaam() {
        return "Sprint Planning";
    }

    @Override
    public void betreed(Speler speler) {
        System.out.println("Je bent nu in de kamer: Sprint Planning.");
        System.out.println("Vraag: Wat is het doel van een sprint planning?");
        // Hier kun je meer interactieve logica toevoegen
    }
}

