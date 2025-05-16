package Game;
//hallo
// De strategy klasse voor KamerDailyScrum
public class AntwoordDailyScrum implements Antwoord {

    @Override
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        if (huidigeVraag == 0) {
            if (antwoord.equals("a")) {
                System.out.println("Correct! Projectleider is geen Scrum-rol.");
                return true;
            } else {
                System.out.println("Fout! Monster 'Misverstand' verschijnt! Probeer het opnieuw.");
                return false;
            }
        } else if (huidigeVraag == 1) {
            if (antwoord.equals("a")) {
                System.out.println("Correct! Een sprint duurt meestal 1 tot 4 weken.");
                return true;
            } else {
                System.out.println("Fout! Monster 'Verwarring' verschijnt! Probeer het opnieuw.");
                return false;
            }
        } else {
            return false;
        }
    }
}