package Game.kamer;

import Game.antwoord.*;
import Game.core.ItemDropper;
import Game.hint.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KamerFactory {
    private final Map<String, Kamer> kamers = new HashMap<>();

    public KamerFactory() {
        KamerPlanning planning = new KamerPlanning(new AntwoordPlanning());
        planning.getItems().addAll(ItemDropper.genereerItemsVoorKamer());
//        voegHintsToeVoorPlanning(planning);
        kamers.put(normaliseer("Sprint Planning"), planning);

        KamerReview review = new KamerReview(new AntwoordReview());
        review.getItems().addAll(ItemDropper.genereerItemsVoorKamer());
//        voegHintsToeVoorReview(review);
        kamers.put(normaliseer("Sprint Review"), review);

        KamerDailyScrum daily = new KamerDailyScrum(new AntwoordDailyScrum());
        daily.getItems().addAll(ItemDropper.genereerItemsVoorKamer());
//        voegHintsToeVoorDaily(daily);
        kamers.put(normaliseer("Daily Scrum"), daily);

        KamerRetrospective retrospective = new KamerRetrospective(new AntwoordRetrospective());
        planning.getItems().addAll(ItemDropper.genereerItemsVoorKamer());
        kamers.put(normaliseer("Sprint Retrospective"), retrospective);

        KamerScrumBoard scrumBoard = new KamerScrumBoard(new AntwoordScrumBoard());
        planning.getItems().addAll(ItemDropper.genereerItemsVoorKamer());
        kamers.put(normaliseer("Sprint ScrumBoard"), scrumBoard);
    }

    private String normaliseer(String s) {
        return s.toLowerCase().replaceAll("\\s+", "");
    }

    public Kamer getKamer(String key) {
        return kamers.get(normaliseer(key));
    }

    public List<String> getKamerKeys() {
        return List.of("Sprint Planning", "Sprint Review", "Daily Scrum", "Sprint Retrospective", "Sprint ScrumBoard");
    }

//    // 👇 Hier voeg je per kamer hints toe
//    private void voegHintsToeVoorPlanning(KamerPlanning kamer) {
//        kamer.getHintContext().voegHintToe(0, new HelpHint("Bij de Sprint Planning doet iedereen mee."));
//        kamer.getHintContext().voegHintToe(1, new FunnyHint("Sprint Poker is geen kaartspel... meestal."));
//    }
//
//    private void voegHintsToeVoorReview(KamerReview kamer) {
//        kamer.getHintContext().voegHintToe(0, new HelpHint("Sprint Review is aan het einde van de Sprint."));
//        kamer.getHintContext().voegHintToe(1, new FunnyHint("Feedback is je beste vriend hier!"));
//    }
//
//    private void voegHintsToeVoorDaily(KamerDailyScrum kamer) {
//        kamer.getHintContext().voegHintToe(0, new HelpHint("Een projectleider is geen Scrum-rol!"));
//        kamer.getHintContext().voegHintToe(1, new FunnyHint("Niet elke sprint is een marathon, meestal 1-4 weken."));
//    }
}
