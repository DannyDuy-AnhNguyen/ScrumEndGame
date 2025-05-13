package Game;

public class AntwoordScrum implements Antwoord{
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        if (huidigeVraag == 0) {
            return antwoord.equals("a");
        } else if (huidigeVraag == 1) {
            return antwoord.equals("a");
        } else {
            return false;
        }
    }
}
