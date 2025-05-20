package Game;

import java.util.Scanner;

public class KamerReview extends Kamer {
    private Antwoord antwoordStrategie;
    private int huidigeVraag = 0;
    private Status status;

    public KamerReview(Antwoord antwoordStrategie) {
        super("Sprint Review");
        this.antwoordStrategie = antwoordStrategie;
        // Deur start standaard gesloten (als dat in Kamer constructor gebeurt)
    }

    @Override
    public void betreedIntro(){
        System.out.println();
        System.out.println("Je bent nu in de kamer: " + naam);
        deur.toonStatus();
        System.out.println();
    }

    //    De feedback die je krijgt voor elke vraag die je goed beantwoord
    @Override
    public void verwerkFeedback(int huidigeVraag) {
        if (huidigeVraag == 0) {
            System.out.println("Sprintreview wordt met je product owner gehouden om te kijken waar de scrumteam tot nu toe uitgevoerd heeft en of het voldaan is.");
        } else if(huidigeVraag == 1){
            System.out.println("Sprint Review zorgt ervoor dat de scrumteam de feedback verzameld en wat de Product Owner nu van het product vindt.");
        } else if(huidigeVraag == 2){
            System.out.println("Dankzij Sprint Review weten beide kanten zowel de product owner als scrumteam wat er gedaan kan worden en wat er verwacht wordt.");
        }
    }

    @Override
    public void verwerkOpdracht(int huidigeVraag){
        if(huidigeVraag == 0){
            System.out.println("Wanneer wordt er een sprintreview gehouden?");
            System.out.println("a) Aan het begin van de sprint");
            System.out.println("b) Tijdens de sprint");
            System.out.println("c) Aan het einde van de sprint");
        } else if(huidigeVraag == 1){
            System.out.println("Wat is het belangrijkste doel van de Sprint Review?");
            System.out.println("a) De Scrum Master evalueren");
            System.out.println("b) Het increment inspecteren en feedback verzamelen");
            System.out.println("c) De volgende sprint alvast plannen");
            System.out.println("d) Vorige sprint doornemen");
        } else if(huidigeVraag == 2){
            System.out.println("De voordelen van een Sprint Review zijn...?");
            System.out.println("a) Meer vergaderingen = meer productiviteit");
            System.out.println("b) Transparantie, snelle feedback, alignment met stakeholders");
            System.out.println("c) Langer werken zonder pauzes");
            System.out.println("d) De product owner tevreden houden");
        }
    }

    @Override
    public void verwerkResultaat(boolean correct, Speler speler){
        if (correct) {
            speler.verhoogScore(10); // score verhogen
            verwerkFeedback(huidigeVraag);
            huidigeVraag++;
            System.out.println("Correct!\n");
        } else {
            speler.voegMonsterToe("Sprint Confusie");
            System.out.println("Monster 'Sprint Confusie' verschijnt! Probeer het opnieuw.\n");
        }
    }

    @Override
    public void betreed(Speler speler) {
        if (!deur.isOpen()) {
            System.out.println("🚪 De deur is gesloten, je kunt deze kamer nog niet betreden.");
            deur.toonStatus();
            return;
        }

        this.status = new Status(speler);
        Scanner scanner = new Scanner(System.in);

        while (huidigeVraag < 3) {
            betreedIntro();
            verwerkOpdracht(huidigeVraag);  //De vragen worden uit deze abstracte methode opgeroepen

            String antwoord = scanner.nextLine().trim().toLowerCase();

            if (antwoord.equals("help")) {
                toonHelp();
                System.out.println();
            } else if (antwoord.equals("status")) {
                status.update();
                System.out.println();
            } else if (antwoord.equals("naar andere kamer")) {
                System.out.println("Je verlaat deze kamer.\n");
                return;
            } else if (antwoord.matches("[a-d]")) {
                boolean correct = antwoordStrategie.verwerkAntwoord(antwoord, huidigeVraag); // controleerd de resultaat wat de gebruiker gekozen heeft.
                verwerkResultaat(correct, speler); // toont de resultaat of de speler het goed heeft of niet
            } else {
                System.out.println("Ongeldige invoer. Typ 'a', 'b', 'c', 'd', 'status', 'help' of 'naar andere kamer'.\n");
            }
        }

        System.out.println("Je hebt alle vragen juist beantwoord!\n");
        setVoltooid();

        // Deur openen na voltooiing
        deur.setOpen(true);
        System.out.println("De deur gaat open! Je kunt nu verder.");

        // Kamer als voltooid registreren (index 3? Pas aan naar juiste index)
        speler.voegVoltooideKamerToe(3);
    }

    @Override
    public boolean verwerkAntwoord(String antwoord, Speler speler) {
        return false; // niet gebruikt, strategie regelt dit
    }

    @Override
    public void toonHelp() {
        System.out.println("Typ het letterantwoord: a, b, c of d");
        System.out.println("Gebruik 'status' om je huidige status te zien.");
        System.out.println("Gebruik 'help' om deze hulp te zien.");
        System.out.println("Gebruik 'naar andere kamer' om deze kamer te verlaten.");
    }
}