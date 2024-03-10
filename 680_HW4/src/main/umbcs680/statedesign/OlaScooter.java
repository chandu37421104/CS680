package umbcs680.statedesign;

public class OlaScooter {
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
