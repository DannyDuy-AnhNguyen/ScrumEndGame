package Game.monster;

import Game.core.Item;

public interface MonsterType {
    String getNaam();
    String getBeschrijving();
    String getVraag();
    boolean beantwoordVraag(String antwoord);
    boolean verslaMetItem(Item item);
    boolean isVerslagen();
}
