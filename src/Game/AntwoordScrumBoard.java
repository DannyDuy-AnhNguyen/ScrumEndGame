package Game;

//de strategy klasse voor KamerBoard
public class AntwoordScrumBoard implements Antwoord{
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        if (huidigeVraag == 0) {
            return antwoord.equals("a");
        } else if (huidigeVraag == 1) {
            return antwoord.equals("b");
        } else {
            return false;
        }
    }
}
