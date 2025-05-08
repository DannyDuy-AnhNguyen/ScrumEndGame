package Game;

public class KamerReview extends Kamer {
    @Override
    public String getNaam() {
        return "Sprint Review";
    }

    @Override
    public void betreed(Speler speler) {
        System.out.println("Je bent nu in de kamer: Sprint Review.");
        System.out.println("Vraag: Wat gebeurt er tijdens een sprint review?");
        // Hier kun je meer interactieve logica toevoegen
    }
}
