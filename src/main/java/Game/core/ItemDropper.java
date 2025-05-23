package Game.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemDropper {
    private static final Random random = new Random();

    public static List<Item> genereerItemsVoorKamer() {
        List<Item> drops = new ArrayList<>();

        // 40% kans op nutteloze rots
        if (random.nextDouble() < 0.4) {
            drops.add(new Item("Rots", "nutteloos"));
        }

        // Kies 1-2 andere bruikbare items uit deze lijst
        List<Item> mogelijkeItems = List.of(
                new Item("Hint Scroll", "hint"),
                new Item("Scrum Zwaard", "kill"),
                new Item("Energie Snack", "boost"),
                new Item("Magische Post-it", "unlock")
        );

        int aantal = 1 + random.nextInt(2); // 1 of 2 extra items
        List<Item> kopie = new ArrayList<>(mogelijkeItems);
        for (int i = 0; i < aantal && !kopie.isEmpty(); i++) {
            int index = random.nextInt(kopie.size());
            drops.add(kopie.remove(index));
        }

        return drops;
    }
}
