package umbcs680.statedesign;

public class ParkedState implements ScooterState {
    private static final ParkedState instance = new ParkedState();

    private ParkedState() {}

    public static ParkedState getInstance() {
        return instance;
    }

    @Override
    public void sideStandRemoved(OlaScooter scooter) {
        System.out.println("Press Power Button to ride.");
        scooter.setState(StandbyState.getInstance());
    }

    @Override
    public void sideStandParked(OlaScooter scooter) {
        System.out.println("No action taken, already in Parked Mode.");
    }

    @Override
    public void powerButtonPressed(OlaScooter scooter) {
        System.out.println("Please remove the side stand to ride.");
    }

    @Override
    public void musicStarted(OlaScooter scooter) {
        System.out.println("Transitioning to ParkedWithMusicState.");
        scooter.setState(ParkedWithMusicState.getInstance());
    }

    @Override
    public void musicStopped(OlaScooter scooter) {
        System.out.println("No music playing in ParkedState.");
    }
}