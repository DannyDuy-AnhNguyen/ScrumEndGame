package Game;

public class AntwoordDailyScrum implements Antwoord {

    @Override
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        if (huidigeVraag == 0) {
            if (antwoord.equals("a")) {
                System.out.println("✅ Correct! Projectleider is geen Scrum-rol.");
                return true;
            } else {
                System.out.println("❌ Fout! Monster 'Verlies van Focus' verschijnt.");
                return false;
            }
        } else if (huidigeVraag == 1) {
            if (antwoord.equals("a")) {
                System.out.println("✅ Correct! Een sprint duurt meestal 1 tot 4 weken.");
                return true;
            } else {
                System.out.println("❌ Fout! Monster 'Verlies van Focus' verschijnt.");
                return false;
            }
        }

        return false;
    }
}
