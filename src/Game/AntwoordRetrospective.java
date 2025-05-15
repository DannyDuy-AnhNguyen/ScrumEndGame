package Game;

public class AntwoordRetrospective implements Antwoord {

    @Override
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        switch (huidigeVraag) {
            case 0:
                return antwoord.equals("c");
            case 1:
                return antwoord.equals("b");
            default:
                return false;
        }
    }
}