package Game;

// de strategy klasse voor KamerPlanning
public class AntwoordPlanning implements Antwoord {
    @Override
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        if (huidigeVraag == 0) {
            if (antwoord.equals("d")) {
                System.out.println("Correct! Het hele Scrum Team neemt deel aan de Sprint Planning.");
                return true;
            } else {
                System.out.println("Fout! Monster 'Misverstand' verschijnt! Probeer het opnieuw.");
                return false;
            }
        } else if (huidigeVraag == 1) {
            if (antwoord.equals("b")) {
                System.out.println("Correct! Tijdens de Sprint Planning worden het sprintdoel en de backlog-items vastgesteld.");
                return true;
            } else {
                System.out.println("Fout! Monster 'Verwarring' verschijnt! Probeer het opnieuw.");
                return false;
            }
        }

        return false;
    }
}