package ElevatorSystem.floor;

import ElevatorSystem.ENUM.Direction;
import ElevatorSystem.ENUM.ELEVATOR_TYPE;
import ElevatorSystem.elevator.ElevatorSystem;

public class Floor {
    public final int floorNumber;
    public final ElevatorSystem elevatorSystem;

    public Floor(int floorNumber, ElevatorSystem elevatorSystem) {
        this.elevatorSystem = elevatorSystem;
        this.floorNumber = floorNumber;
    }

    public boolean makeRequest(Direction direction, ELEVATOR_TYPE elevatorType) {
        return elevatorSystem.handleElevatorRequest(direction, this, elevatorType);
    }

}
