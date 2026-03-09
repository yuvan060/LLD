package ElevatorSystem;

public class ElevatorSystem {
    /*
    Elevator System needs to be designed,
    A building has N number of floors and M number of elevators
    each floor has a request panel whether to Go Up or Down
    based on the user request, an elevator will start to move towards the floor
    after user enters the lift, he can click the desirable floor to leave.


    ENUMS :
    DIRECTION - UP, DOWN

    State Design Patter :
    ElevatorState  : openDoor(), closeDoor(), stopLift(), moveNextFloor();
    implemented by ServingState, MaintenanceState, DoorOpenState, IdleState

    Entities

        Floor - number

        Door - DOOR STATE - OPEN/CLOSED

        Elevator - id, PriorityQueue<Integers> upDirection, downDirection, ElevatorState, Direction, currentFloor, Door;
                    getCurrentFloor(), addExternalRequest(Direction, Floor), addInternalRequest(floor), openDoor(), closeDoor(), goMaintenanceState(), stopLift(), moveNextFloor()

        Building - List<Floors> floors, ElevatorSystem elevatorSystem;
                    addFloors(), addElevator(), addRequest(floor, direction)

        ElevatorSystem - Map<ElevatorType, List<Elevators>> elevators, Map<ElevatorType, List<ElevatorStrategy>> elevatorStrategy;
                         handleRequest(floor, elevatorType, direction) -> finds the best elevator for the current request from the elevatorStrategy
                         and assign the elevator the request;
      */
}
