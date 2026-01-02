package behavioural.state;

public class NeutralGear implements Gear{
    @Override
    public void up(Vechile vechile) {
        vechile.setCurrentGear(new FirstGear());
    }

    @Override
    public void down(Vechile vechile) {
        // no down gear
    }
}
