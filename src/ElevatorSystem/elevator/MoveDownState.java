package ElevatorSystem.elevator;

import ElevatorSystem.ENUM.Direction;

public class MoveDownState implements ElevatorState{
    @Override
    public void openDoor(Elevator elevator) {

    }

    @Override
    public void closeDoor(Elevator elevator) {

    }

    @Override
    public void moveNextFloor(Elevator elevator) {
        if(!elevator.downDirection.isEmpty()) {
            elevator.currentFloor -= 1;
            return;
        }
        if(!elevator.upDirection.isEmpty()) {
            elevator.elevatorDirection = Direction.UP;
            elevator.elevatorState = new MoveUpState();
            return;
        }
        elevator.elevatorState = new IdleState();
    }

    @Override
    public void stopElevator(Elevator elevator) {

    }

    @Override
    public void maintenanceMode(Elevator elevator) {

    }
}
