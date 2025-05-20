package Game;

public class AntwoordScrumBoard implements Antwoord {

    @Override
    public boolean verwerkAntwoord(String antwoord, int huidigeVraag) {
        switch (huidigeVraag) {
            case 0:
                if (antwoord.equals("a")) {
                    System.out.println(" De juiste volgorde is: Epics > Userstories > Taken.");
                    return true;
                } else {
                    System.out.println(" De juiste volgorde is: Epics > Userstories > Taken.");
                    return false;
                }

            case 1:
                if (antwoord.equals("b")) {
                    System.out.println(" Een volledig Scrumboard bevat: To Do, Doing, Testing en Done.");
                    return true;
                } else {
                    System.out.println(" Een compleet Scrumboard bevat alle stappen inclusief To Do en Testing.");
                    return false;
                }

            default:
                System.out.println("❌ Ongeldige vraagindex.");
                return false;
        }
    }
}
