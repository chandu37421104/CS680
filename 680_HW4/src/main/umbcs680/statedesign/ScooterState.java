package umbcs680.statedesign;

public interface ScooterState {
    void sideStandRemoved(OlaScooter scooter);
    void sideStandParked(OlaScooter scooter);
    void powerButtonPressed(OlaScooter scooter);
    void musicStarted(OlaScooter scooter);
    void musicStopped(OlaScooter scooter);
}