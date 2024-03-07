package umbcs680.statedesign;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OlaScooterTest {

    @Test
    void ParkedStateToStandByStateTransition() {
        OlaScooter scooter = new OlaScooter(ParkedState.getInstance());
        scooter.sideStandRemoved();
        assertTrue(scooter.getState() instanceof StandbyState, "Scooter should transition to Standby Mode.");
    }

    @Test
    void RideStateDoesNotChangeOnStandRemoved() {
        OlaScooter scooter = new OlaScooter(RideState.getInstance());
        scooter.sideStandRemoved();
        assertTrue(scooter.getState() instanceof RideState, "Scooter should remain in Ride Mode.");
    }

    @Test
    void RideStateDoesNotChangeOnStandParked() {
        OlaScooter scooter = new OlaScooter(RideState.getInstance());
        scooter.sideStandParked();
        assertTrue(scooter.getState() instanceof RideState, "Scooter should remain in Ride Mode.");
    }

    @Test
    void ParkedStateDoesNotChangeOnStandParked() {
        OlaScooter scooter = new OlaScooter(ParkedState.getInstance());
        scooter.sideStandParked();
        assertTrue(scooter.getState() instanceof ParkedState, "Scooter should remain in Parked Mode.");
    }

    @Test
    void musicStartsInParkedState() {
        OlaScooter scooter = new OlaScooter(ParkedState.getInstance());
        scooter.musicStarted();
        assertTrue(scooter.getState() instanceof ParkedWithMusicState, "Scooter should transition to Parked Mode with Music.");
    }

    @Test
    void musicDoesNotStartInRideState() {
        OlaScooter scooter = new OlaScooter(RideState.getInstance());
        scooter.musicStarted();
        assertFalse(scooter.getState() instanceof ParkedWithMusicState, "Scooter should not transition to Parked Mode with Music from Ride Mode.");
    }

    @Test
    void MusicStopsAndTransitionsToParkedState() {
        OlaScooter scooter = new OlaScooter(ParkedWithMusicState.getInstance());
        scooter.sideStandParked();
        assertTrue(scooter.getState() instanceof ParkedState, "Scooter should transition back to Parked Mode when the side stand is parked.");
    }

    @Test
    void TransitionFromMusicStateToStandbyState() {
        OlaScooter scooter = new OlaScooter(ParkedWithMusicState.getInstance());
        scooter.sideStandRemoved();
        assertTrue(scooter.getState() instanceof StandbyState, "Scooter should transition to Ride Mode when the side stand is removed.");
    }

    @Test
    void noMusicTransitionWhenAlreadyPlaying() {
        OlaScooter scooter = new OlaScooter(ParkedWithMusicState.getInstance());
        scooter.musicStarted();
        assertTrue(scooter.getState() instanceof ParkedWithMusicState, "Scooter should remain in Parked Mode with Music if music is already playing.");
    }
    
    @Test
    void rideStateNoTransitionOnMusicStart() {
        OlaScooter scooter = new OlaScooter(RideState.getInstance());
        scooter.musicStarted();
        assertTrue(scooter.getState() instanceof RideState, "Scooter in Ride Mode should not transition when music starts.");
    }

    @Test
    void ParkedStateNoTransitionOnSideStandParked() {
        OlaScooter scooter = new OlaScooter(ParkedState.getInstance());
        scooter.sideStandParked();
        assertTrue(scooter.getState() instanceof ParkedState, "Scooter in Parked State should not transition on side stand parked.");
    }

    @Test
    void transitionToStandbyStateFromRideStateOnPowerPressed() {
        OlaScooter scooter = new OlaScooter(RideState.getInstance());
        scooter.powerButtonPressed();
        assertTrue(scooter.getState() instanceof StandbyState, "Scooter should transition to Standby Mode when power button is pressed in Ride Mode.");
    }

    @Test
    void standbyStateDoesNotChangeOnMusicStarted() {
        OlaScooter scooter = new OlaScooter(StandbyState.getInstance());
        scooter.musicStarted();
        assertTrue(scooter.getState() instanceof StandbyState, "Scooter should remain in Standby Mode when music is started.");
    }

    @Test
    void transitionToParkedStateFromStandbyStateOnSideStandParked() {
        OlaScooter scooter = new OlaScooter(StandbyState.getInstance());
        scooter.sideStandParked();
        assertTrue(scooter.getState() instanceof ParkedState, "Scooter should transition to Parked Mode when side stand is parked in Standby Mode.");
    }

    @Test
    void parkedStateToStandbyStateOnSideStandRemoved() {
        OlaScooter scooter = new OlaScooter(ParkedState.getInstance());
        scooter.sideStandRemoved();
        assertTrue(scooter.getState() instanceof StandbyState, "Scooter should transition to Standby Mode when side stand is removed in Parked Mode.");
    }

    @Test
    void transitionToRideStateFromStandbyStateOnSideStandRemoved() {
        OlaScooter scooter = new OlaScooter(StandbyState.getInstance());
        scooter.sideStandRemoved();
        assertTrue(scooter.getState() instanceof StandbyState, "Scooter already in Standby Mode.");
    }

    @Test
    void musicStoppedInParkedWithMusicStateTransitionsToParkedState() {
        OlaScooter scooter = new OlaScooter(ParkedWithMusicState.getInstance());
        scooter.musicStopped();
        assertTrue(scooter.getState() instanceof ParkedState, "Scooter should transition to Parked State when music stops in ParkedWithMusic State.");
    }

    @Test
    void musicDoesNotStartInStandbyState() {
        OlaScooter scooter = new OlaScooter(StandbyState.getInstance());
        scooter.musicStarted();
        assertFalse(scooter.getState() instanceof ParkedWithMusicState, "Music should not start in Standby Mode, remaining in Standby State.");
    }

    @Test
    void musicDoesNotStopInStandbyState() {
        OlaScooter scooter = new OlaScooter(StandbyState.getInstance());
        scooter.musicStopped();
        assertTrue(scooter.getState() instanceof StandbyState, "Music stop action should not change Standby State.");
    }
}
