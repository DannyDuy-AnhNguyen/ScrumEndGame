package Game.antwoord;

// de strategy klasse voor KamerPlanning
public class AntwoordPlanning implements Antwoord {
    @Override
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        if (huidigeVraag == 0) {
            return antwoord.equals("d");
        } else if (huidigeVraag == 1) {
            return antwoord.equals("b");
        }
        return false;
    }
}