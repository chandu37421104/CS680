package umbcs680.statedesign;


interface ScooterState {
    void sideStandRemoved(OlaScooter scooter);
    void sideStandParked(OlaScooter scooter);
    void powerButtonPressed(OlaScooter scooter);
    void musicStarted(OlaScooter scooter);
    void musicStopped(OlaScooter scooter);
}

class ParkedState implements ScooterState {
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

class StandbyState implements ScooterState {
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

class RideState implements ScooterState {
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

class ParkedWithMusicState implements ScooterState {
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


class OlaScooter {
    private ScooterState state;

    public OlaScooter(ScooterState state) {
        this.state = state;
    }

    public void setState(ScooterState state) {
        this.state = state;
    }

    public ScooterState getState() {
        return state;
    }

    public void sideStandRemoved() {
        state.sideStandRemoved(this);
    }

    public void sideStandParked() {
        state.sideStandParked(this);
    }

    public void powerButtonPressed() {
        state.powerButtonPressed(this);
    }

    public void musicStarted() {
        state.musicStarted(this);
    }

    public void musicStopped() {
        state.musicStopped(this);
    }
}
