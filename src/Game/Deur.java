package Game;

public class Deur {
    private boolean open = false;

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isOpen() {
        return open;
    }

    public void toonStatus() {
        System.out.println(open ? "🚪 De deur is OPEN." : "🚪 De deur is GESLOTEN.");
    }
}
