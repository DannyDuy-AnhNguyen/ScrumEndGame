package Game;

// de strategy klasse voor KamerScrumBoard
public class AntwoordScrumBoard implements Antwoord {
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        if (huidigeVraag == 0) {
            boolean correct = antwoord.equals("a");
            System.out.println(correct ? "Correct! De juiste volgorde is Epics > Userstories > Taken."
                    : "Fout! De juiste volgorde is Epics > Userstories > Taken.");
            return correct;
        } else if (huidigeVraag == 1) {
            boolean correct = antwoord.equals("b");
            System.out.println(correct ? "Correct! Een volledig Scrumboard bevat To Do, Doing, Testing en Done."
                    : "Fout! Probeer opnieuw!");
            return correct;
        } else {
            return false;
        }
    }
}