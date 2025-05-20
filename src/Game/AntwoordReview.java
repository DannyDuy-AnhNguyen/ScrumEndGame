package Game;

public class AntwoordReview implements Antwoord {

    @Override
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        switch (huidigeVraag) {
            case 0:
                if (antwoord.equals("c")) {
                    System.out.println(" De Sprint Review vindt plaats aan het einde van de sprint.");
                    return true;
                } else {
                    System.out.println(" De Sprint Review komt altijd aan het einde, niet eerder.");
                    return false;
                }

            case 1:
                if (antwoord.equals("b")) {
                    System.out.println(" Tijdens de Review wordt het increment bekeken en feedback verzameld.");
                    return true;
                } else {
                    System.out.println(" Het draait om inspectie van het increment en waardevolle feedback.");
                    return false;
                }

            case 2:
                if (antwoord.equals("b")) {
                    System.out.println(" Voordelen zijn transparantie, snelle feedback en alignment.");
                    return true;
                } else {
                    System.out.println("Denk aan samenwerking en directe terugkoppeling.");
                    return false;
                }

            default:
                System.out.println("❌ Ongeldige vraagindex.");
                return false;
        }
    }
}
