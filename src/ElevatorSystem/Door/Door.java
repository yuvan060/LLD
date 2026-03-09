package ElevatorSystem.Door;

import ElevatorSystem.ENUM.DoorState;

public class Door {
    public DoorState doorState;
    public Door() {
        this.doorState = DoorState.CLOSED;
    }
    public void openDoor() {
        doorState = DoorState.OPEN;
    }
    public void closeDoor() {
        doorState = DoorState.CLOSED;
    }
}
