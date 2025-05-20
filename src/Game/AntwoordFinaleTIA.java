package Game;

public class AntwoordFinaleTIA implements Antwoord {

    @Override
    public boolean verwerkAntwoord(String antwoord, int vraagIndex) {
        switch (vraagIndex) {
            case 0:
                if (antwoord.equals("c")) {
                    System.out.println(" Scrum draait om Transparantie, Inspectie en Aanpassing.");
                    return true;
                } else {
                    System.out.println(" Denk goed na over het doel van Scrum.");
                    return false;
                }

            case 1:
                if (antwoord.equals("b")) {
                    System.out.println(" Scrum werd officieel geïntroduceerd in 1995.");
                    return true;
                } else {
                    System.out.println(" Dat is niet het juiste jaar.");
                    return false;
                }

            case 2:
                if (antwoord.equals("c")) {
                    System.out.println(" Transparantie bevordert open communicatie.");
                    return true;
                } else {
                    System.out.println(" Denk aan de Scrum-waarden.");
                    return false;
                }

            default:
                System.out.println("❌ Ongeldige vraagindex.");
                return false;
        }
    }
}
