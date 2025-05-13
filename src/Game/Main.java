package Game;

public class Main {
    public static void main(String[] args) {
        Speler testSpeler = new Speler();
        testSpeler.setNaam("Testpersoon");

        Kamer finale = new KamerFinaleTIA();
        finale.betreed(testSpeler);
    }
}
