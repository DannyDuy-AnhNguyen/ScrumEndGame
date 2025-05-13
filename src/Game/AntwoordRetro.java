package Game;

public class AntwoordRetro implements Antwoord{
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        if (huidigeVraag == 0) {
            return antwoord.equals("c");
        } else if (huidigeVraag == 1) {
            return antwoord.equals("b");
        } else {
            return false;
        }
    }
}
