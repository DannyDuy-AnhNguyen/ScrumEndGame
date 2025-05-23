package Game.hint;

public class FunnyHint implements Hint {
    private final String tekst;

    public FunnyHint(String tekst) {
        this.tekst = tekst;
    }

    @Override
    public void toon() {
        System.out.println("💡 Hint: " + tekst);
    }
}
