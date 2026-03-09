package ElevatorSystem.elevator;

import ElevatorSystem.ENUM.Direction;
import ElevatorSystem.ENUM.ELEVATOR_TYPE;
import ElevatorSystem.floor.Floor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElevatorSystem {
    public final Map<ELEVATOR_TYPE, List<Elevator>> elevators;
    public final Map<ELEVATOR_TYPE, ElevatorStrategy> elevatorStrategyMap;

    private ElevatorSystem() {
        elevators = new HashMap<>();
        elevatorStrategyMap = new HashMap<>();
    }

    public void addElevator(Elevator elevator) {
        if(!elevators.containsKey(elevator.elevatorType)) {
            elevators.put(elevator.elevatorType, new ArrayList<>());
        }
        elevators.get(elevator.elevatorType).add(elevator);
    }

    public void addElevatorStrategy(ELEVATOR_TYPE elevatorType, ElevatorStrategy elevatorStrategy) {
        elevatorStrategyMap.put(elevatorType, elevatorStrategy);
    }
    
    public boolean handleElevatorRequest(Direction direction, Floor floor, ELEVATOR_TYPE elevatorType) {

        Elevator elevator = elevatorStrategyMap.get(elevatorType).getBestElevator(elevators.get(elevatorType), direction, floor);

        if(elevator == null) return  false;

        elevator.addExternalRequest(floor, direction);

        return true;
    }

    public static class ElevatorSystemInstanceHolder {
        private final static ElevatorSystem elevatorSystem = new ElevatorSystem();

        public static ElevatorSystem getElevatorSystemInstance() {
            return elevatorSystem;
        }
    }

    public static ElevatorSystem getInstance() {
        return ElevatorSystemInstanceHolder.getElevatorSystemInstance();
    }
}
