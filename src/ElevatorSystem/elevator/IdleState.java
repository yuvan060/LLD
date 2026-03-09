package ElevatorSystem.elevator;

import ElevatorSystem.ENUM.Direction;

public class IdleState implements ElevatorState{
    @Override
    public void openDoor(Elevator elevator) {
        elevator.door.openDoor();
    }

    @Override
    public void closeDoor(Elevator elevator) {
        elevator.door.closeDoor();
    }

    @Override
    public void moveNextFloor(Elevator elevator) {
        if(elevator.elevatorDirection == Direction.UP) {
            elevator.elevatorState = new MoveUpState();
        } else {
          elevator.elevatorState = new MoveDownState();
        }
    }

    @Override
    public void stopElevator(Elevator elevator) {
        //already in idle
    }

    @Override
    public void maintenanceMode(Elevator elevator) {
        elevator.elevatorState = new MaintainenceState();
    }
}
