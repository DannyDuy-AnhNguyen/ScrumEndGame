package Game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Deze klasse zorgt voor OCP, omdat je het niet in de spel (onze main waar ons spel werkt) aangepast hoeft te worden.
//Als er aanpassingen plaats vindt, dan kun je in deze klasse dingen aanpassen.
public class KamerFactory {
//    De Map zorgt ervoor dat de attribuut kamer de bijbehorende String en natuurlijk de kamer klasse toegevoegd wordt
    private final Map<String, Kamer> kamers = new HashMap<>();

    // Bij de toegevoegde kamers zijn ook de bijbehorende antwoord (Strategy Klasse) bij toegevoegd. Zie in de Constructor
    //Als er nieuwe kamers gemaakt worden, dan wordt het ook hierbij toegevoegd, anders werkt het spel niet meer🙂
    public KamerFactory() {
        kamers.put(normaliseer("Sprint Planning"), new KamerPlanning(new AntwoordPlanning()));
        kamers.put(normaliseer("Sprint Review"), new KamerReview(new AntwoordReview()));
        kamers.put(normaliseer("Scrum Board"), new KamerScrumBoard(new AntwoordScrumBoard()));
        kamers.put(normaliseer("Sprint Retrospective"), new KamerRetrospective(new AntwoordRetrospective()));
        kamers.put(normaliseer("Daily Scrum"), new KamerDailyScrum(new AntwoordDailyScrum()));

        // Als alle kamers voltooid zijn, dan pas mag de speler naar de finale kamer
        kamers.put(normaliseer("Finale TIA Kamer – Waarom Scrum?"), new KamerFinaleTIA(new AntwoordFinaleTIA()));

    }

//    Deze klasse zorgt ervoor dat je de kamer kunt oproepen. Dit wordt alleen gebruikt voor de Finale kamer.
    public Kamer getKamer(String key) {
        return kamers.get(normaliseer(key));
    }

//    De lijst van bestaande
    public List<String> getKamerKeys(){
        return List.of("Sprint Planning", "Sprint Review", "Scrum Board", "Sprint Retrospective", "Daily Scrum");
    }

//    Omdat in de normaliseer ding spatie er tussen zit, wordt er gebruikt gemaakt van dit zodat je in de scanner in gewoon de spatie kunt typen.
    private String normaliseer(String s) {
        return s.toLowerCase().replaceAll("\\s+", "");
    }
}
