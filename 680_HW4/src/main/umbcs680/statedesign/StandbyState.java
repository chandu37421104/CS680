package umbcs680.statedesign;

public class StandbyState implements ScooterState {
    private static final StandbyState instance = new StandbyState();

    private StandbyState() {}

    public static StandbyState getInstance() {
        return instance;
    }

    @Override
    public void sideStandRemoved(OlaScooter scooter) {
        System.out.println("No action taken, already in Standby Mode.");
    }

    @Override
    public void sideStandParked(OlaScooter scooter) {
        System.out.println("Transitioning to ParkedState.");
        scooter.setState(ParkedState.getInstance());
    }

    @Override
    public void powerButtonPressed(OlaScooter scooter) {
        System.out.println("Scooter is already in Standby Mode. Ready to ride or park.");
    }

    @Override
    public void musicStarted(OlaScooter scooter) {
        System.out.println("Music cannot start in Standby Mode.");
    }

    @Override
    public void musicStopped(OlaScooter scooter) {
        System.out.println("Music is not playing in Standby Mode.");
    }
}