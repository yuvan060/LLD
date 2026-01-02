package behavioural.state;

public class Vechile {
    private Gear currentGear;

    public Vechile() {
        currentGear = new NeutralGear();
    }

    public void setCurrentGear(Gear gear) {
        currentGear = gear;
    }

    public boolean upGear() {
        currentGear.up(this);
        return true;
    }

    public boolean downGear() {
        currentGear.down(this);
        return true;
    }
}
