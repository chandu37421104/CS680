package umbcs680.statedesign;

public class ParkedWithMusicState implements ScooterState {
    private static final ParkedWithMusicState instance = new ParkedWithMusicState();

    private ParkedWithMusicState() {}

    public static ParkedWithMusicState getInstance() {
        return instance;
    }

    @Override
    public void sideStandRemoved(OlaScooter scooter) {
        System.out.println("Press powerbutton to ride.");
        scooter.setState(StandbyState.getInstance());
    }

    @Override
    public void sideStandParked(OlaScooter scooter) {
        System.out.println("Music stops. Colored lights off.");
        scooter.setState(ParkedState.getInstance());
    }

    @Override
    public void powerButtonPressed(OlaScooter scooter) {
        System.out.println("Please remove the side stand to ride.");
    }

    @Override
    public void musicStarted(OlaScooter scooter) {
        System.out.println("Music is already playing in ParkedWithMusicState.");
    }

    @Override
    public void musicStopped(OlaScooter scooter) {
        System.out.println("Stopping music, transitioning to ParkedState.");
        scooter.setState(ParkedState.getInstance());
    }
}