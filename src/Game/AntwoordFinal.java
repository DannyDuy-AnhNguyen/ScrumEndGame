package Game;

public class AntwoordFinal implements Antwoord{
    @Override
    public boolean verwerkAntwoord(String antwoord, int vraagIndex) {
        if (vraagIndex == 0) {
            return antwoord.equals("a");
        } else if (vraagIndex == 1) {
            return antwoord.equals("a");
        } else if (vraagIndex == 2) {
            return antwoord.matches("[a-d]");
        }
        return false;
    }
}
