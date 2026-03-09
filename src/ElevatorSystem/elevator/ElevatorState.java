package ElevatorSystem.elevator;

public interface ElevatorState {
    public void openDoor(Elevator elevator);
    public void closeDoor(Elevator elevator);
    public void moveNextFloor(Elevator elevator);
    public void stopElevator(Elevator elevator);
    public void maintenanceMode(Elevator elevator);
}
