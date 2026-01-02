package behavioural.state;

public class FirstGear implements Gear{
    @Override
    public void up(Vechile vechile) {
        // up the gear
    }

    @Override
    public void down(Vechile vechile) {
        vechile.setCurrentGear(new NeutralGear());
    }
}
