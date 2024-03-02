package umbcs680.statedesign;


interface ScooterState {
    void sideStandRemoved(OlaScooter scooter);
    void sideStandParked(OlaScooter scooter);
    void startMusic(OlaScooter scooter);
}


class ParkedState implements ScooterState {
    private static final ParkedState instance = new ParkedState();

    private ParkedState() {}

    public static ParkedState getInstance() {
        return instance;
    }

    @Override
    public void sideStandRemoved(OlaScooter scooter) {
        System.out.println("HMI lock screen pops up. Ready to ride.");
        scooter.setState(RideState.getInstance());
    }

    @Override
    public void sideStandParked(OlaScooter scooter) {
        System.out.println("No action taken, already in Parked Mode.");
    }

    @Override
    public void startMusic(OlaScooter scooter) {
        System.out.println("Music starts playing. Colored lights blinking.");
        scooter.setState(ParkedWithMusicState.getInstance());
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
    public void startMusic(OlaScooter scooter) {
        System.out.println("No action taken, music cannot play in Ride Mode.");
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
        System.out.println("HMI lock screen pops up. Ready to ride.");
        scooter.setState(RideState.getInstance());
    }

    @Override
    public void sideStandParked(OlaScooter scooter) {
        System.out.println("Music stops. Colored lights off.");
        scooter.setState(ParkedState.getInstance());
    }

    @Override
    public void startMusic(OlaScooter scooter) {
        System.out.println("Music is already playing.");
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

    public void startMusic() {
        state.startMusic(this);
    }
}
