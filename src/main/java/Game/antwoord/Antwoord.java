package Game.antwoord;

//De interface voor de strategy klasses
public interface Antwoord {
    boolean verwerkAntwoord(String antwoord, int vraagIndex);
}