package Game;

import java.util.List;

public class GameContext {
    private static List<Kamer> kamers;

    public static void setKamers(List<Kamer> lijst) {
        kamers = lijst;
    }

    public static List<Kamer> getKamers() {
        return kamers;
    }
}