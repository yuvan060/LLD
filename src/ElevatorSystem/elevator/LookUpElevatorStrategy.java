package ElevatorSystem.elevator;

import ElevatorSystem.ENUM.Direction;
import ElevatorSystem.floor.Floor;

import java.util.List;

public class LookUpElevatorStrategy implements ElevatorStrategy{
    @Override
    public Elevator getBestElevator(List<Elevator> elevators, Direction requestDirection, Floor floor) {
        Elevator bestElevator = null;
        int minCost = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            int cost = calculateRoutingCost(elevator, requestDirection, floor.floorNumber);

            if (cost < minCost) {
                minCost = cost;
                bestElevator = elevator;
            }
        }

        return bestElevator;
    }

    private int calculateRoutingCost(Elevator elevator, Direction requestDirection, int targetFloor) {
        int currentFloor = elevator.currentFloor;
        Direction elevatorDirection = elevator.elevatorDirection;

        int distance = Math.abs(currentFloor - targetFloor);

        if (elevator.elevatorState instanceof IdleState) {
            return distance;
        }

        boolean isApproachingUp = (requestDirection == Direction.UP &&
                elevatorDirection == Direction.UP &&
                currentFloor <= targetFloor);

        boolean isApproachingDown = (requestDirection == Direction.Down &&
                elevatorDirection == Direction.Down &&
                currentFloor >= targetFloor);

        if (isApproachingUp || isApproachingDown) {
            return distance;
        }

        return distance + 1000;
    }
}
