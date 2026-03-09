package ElevatorSystem.elevator;

import ElevatorSystem.ENUM.Direction;
import ElevatorSystem.floor.Floor;

import java.util.List;

public interface ElevatorStrategy {
    public Elevator getBestElevator(List<Elevator> elevators, Direction direction, Floor floor);
}
