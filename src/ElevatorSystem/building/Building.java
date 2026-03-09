package ElevatorSystem.building;

import ElevatorSystem.elevator.ElevatorSystem;
import ElevatorSystem.floor.Floor;

import java.util.ArrayList;
import java.util.List;

public class Building {
    public final List<Floor> floors;
    public final ElevatorSystem elevatorSystem;

    public Building() {
        this.floors = new ArrayList<>();
        this.elevatorSystem = ElevatorSystem.getInstance();
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }
}
