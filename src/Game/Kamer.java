package Game;

public abstract class Kamer {
    protected String naam;
    protected boolean voltooid = false;
    protected boolean vraagBeantwoord = false;
    protected boolean inVraag = false;
    protected int kamerNummer; // Voeg kamerNummer toe

    public Kamer(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public boolean isVoltooid() {
        return voltooid;
    }

    public void setVoltooid() {
        this.voltooid = true;
    }

    public boolean isVraagBeantwoord() {
        return vraagBeantwoord;
    }

    public void setVraagBeantwoord(boolean vraagBeantwoord) {
        this.vraagBeantwoord = vraagBeantwoord;
    }

    public boolean isInVraag() {
        return inVraag;
    }

    public void setInVraag(boolean inVraag) {
        this.inVraag = inVraag;
    }

    // Getter en setter voor kamerNummer
    public int getKamerNummer() {
        return kamerNummer;
    }

    public void setKamerNummer(int kamerNummer) {
        this.kamerNummer = kamerNummer;
    }

    /**
     * Methode die wordt aangeroepen wanneer de speler een kamer betreedt.
     * Dit triggert de vraag in de kamer of begint de activiteit.
     */
    public void betreed(Speler speler) {
        if (!inVraag) {
            // Begin de vraag of activiteit in de kamer.
            this.inVraag = true;
            stelVraag(speler); // Stel de vraag of voer de actie uit.
        }
    }

    /**
     * Abstracte methode voor het stellen van een vraag. De specifieke implementatie hangt af van de kamer.
     */
    public abstract void stelVraag(Speler speler);

    /**
     * Verwerkt het antwoord van de speler en bepaalt of de vraag goed beantwoord is.
     * @param antwoord Het antwoord van de speler.
     * @return boolean of het antwoord juist is.
     */
    public abstract boolean verwerkAntwoord(String antwoord);

    /**
     * Deze methode wordt aangeroepen wanneer de speler de status opvraagt.
     * Dit zorgt ervoor dat er geen monster verschijnt wanneer de status wordt getoond.
     */
    public void toonStatus(Speler speler) {
        // Hier geef je de status van de speler weer zonder verder de voortgang van de kamer te beïnvloeden.
        speler.status();
    }

    /**
     * Deze methode zorgt ervoor dat de kamer kan worden voltooid.
     * Dit kan worden aangeroepen als de vraag correct is beantwoord.
     */
    public void voltooiKamer() {
        this.voltooid = true;
        this.inVraag = false;  // Eindig de vraag en stel de speler in staat door te gaan.
    }
}