package Game;

public class AntwoordRetrospective implements Antwoord {

    @Override
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        switch (huidigeVraag) {
            case 0:
                if (antwoord.equals("c")) {
                    System.out.println(" Het doel van de Sprint Retrospective is verbeteren door terug te kijken op het proces.");
                    return true;
                } else {
                    System.out.println(" De retrospective gaat over procesverbetering, niet over het product.");
                    return false;
                }

            case 1:
                if (antwoord.equals("b")) {
                    System.out.println(" De Sprint Retrospective vindt plaats na de Sprint Review.");
                    return true;
                } else {
                    System.out.println(" De retrospective gebeurt altijd aan het einde van een sprint.");
                    return false;
                }

            default:
                System.out.println("❌ Ongeldige vraagindex.");
                return false;
        }
    }
}
