package Game.hint;

public class HelpHint implements Hint {
    private final String tekst;

    public HelpHint(String tekst) {
        this.tekst = tekst;
    }

    @Override
    public void toon() {
        System.out.println("💡 Hint: " + tekst);
    }
}
