package umbcs680.statedesign;

public class RideState implements ScooterState {
    private static final RideState instance = new RideState();

    private RideState() {}

    public static RideState getInstance() {
        return instance;
    }

    @Override
    public void sideStandRemoved(OlaScooter scooter) {
        System.out.println("No action taken, Scooter is in Ride Mode.");
    }

    @Override
    public void sideStandParked(OlaScooter scooter) {
        System.out.println("No action taken, Scooter remains in Ride Mode.");
    }

    @Override
    public void powerButtonPressed(OlaScooter scooter) {
        System.out.println("Transitioning to StandbyState.");
        scooter.setState(StandbyState.getInstance());
    }

    @Override
    public void musicStarted(OlaScooter scooter) {
        System.out.println("Music cannot start in RideState.");
    }

    @Override
    public void musicStopped(OlaScooter scooter) {
        System.out.println("Music cannot play in RideState.");
    }
}