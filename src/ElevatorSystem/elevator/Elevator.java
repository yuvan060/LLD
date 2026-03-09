package ElevatorSystem.elevator;

import ElevatorSystem.Door.Door;
import ElevatorSystem.ENUM.Direction;
import ElevatorSystem.ENUM.ELEVATOR_TYPE;
import ElevatorSystem.floor.Floor;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Elevator {
    public final int id;
    public int currentFloor;
    public ElevatorState elevatorState;
    public Direction elevatorDirection;
    public final PriorityQueue<Floor> upDirection;
    public final PriorityQueue<Floor> downDirection;
    public final Door door;
    public final ELEVATOR_TYPE elevatorType;

    public Elevator(int id, ELEVATOR_TYPE elevatorType) {
        this.id = id;
        this.upDirection = new PriorityQueue<>(Comparator.comparingInt(a -> a.floorNumber));
        this.downDirection = new PriorityQueue<>((a,b) -> Integer.compare(b.floorNumber, a.floorNumber));
        this.door = new Door();
        this.currentFloor = 0;
        this.elevatorState = new IdleState();
        this.elevatorDirection = Direction.UP;
        this.elevatorType = elevatorType;
    }

    public boolean addExternalRequest(Floor floor, Direction direction) {
        if(direction == Direction.UP) upDirection.add(floor);
        else downDirection.add(floor);
        return true;
    }

    public boolean addInternalRequest(Floor floor) {
        if(elevatorDirection == Direction.UP) upDirection.add(floor);
        else downDirection.add(floor);
        return true;
    }

    public void openDoor() {
        elevatorState.openDoor(this);
    }

    public void closeDoor() {
        elevatorState.closeDoor(this);
    }

    public void moveNextFloor() {
        elevatorState.moveNextFloor(this);
    }

    public void stopLift() {
        elevatorState.stopElevator(this);
    }
}
