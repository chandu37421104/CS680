package umbcs680.statedesign;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OlaScooterTest {

    @Test
    void ParkedStateToRideStateTransition() {
        OlaScooter scooter = new OlaScooter(ParkedState.getInstance());
        scooter.sideStandRemoved();
        assertTrue(scooter.getState() instanceof RideState, "Scooter should transition to Ride Mode.");
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
    void MusicStartsInParkedState() {
        OlaScooter scooter = new OlaScooter(ParkedState.getInstance());
        scooter.startMusic();
        assertTrue(scooter.getState() instanceof ParkedWithMusicState, "Scooter should transition to Parked Mode with Music.");
    }

    @Test
    void MusicDoesNotStartInRideState() {
        OlaScooter scooter = new OlaScooter(RideState.getInstance());
        scooter.startMusic();
        assertFalse(scooter.getState() instanceof ParkedWithMusicState, "Scooter should not transition to Parked Mode with Music from Ride Mode.");
    }

    @Test
    void MusicStopsAndTransitionsToParkedState() {
        OlaScooter scooter = new OlaScooter(ParkedWithMusicState.getInstance());
        scooter.sideStandParked();
        assertTrue(scooter.getState() instanceof ParkedState, "Scooter should transition back to Parked Mode when the side stand is parked.");
    }

    @Test
    void TransitionFromMusicStateToRideState() {
        OlaScooter scooter = new OlaScooter(ParkedWithMusicState.getInstance());
        scooter.sideStandRemoved();
        assertTrue(scooter.getState() instanceof RideState, "Scooter should transition to Ride Mode when the side stand is removed.");
    }

    @Test
    void NoMusicTransitionWhenAlreadyPlaying() {
        OlaScooter scooter = new OlaScooter(ParkedWithMusicState.getInstance());
        scooter.startMusic();
        assertTrue(scooter.getState() instanceof ParkedWithMusicState, "Scooter should remain in Parked Mode with Music if music is already playing.");
    }
    
    @Test
    void RideStateNoTransitionOnStartMusic() {
        OlaScooter scooter = new OlaScooter(RideState.getInstance());
        scooter.startMusic();
        assertTrue(scooter.getState() instanceof RideState, "Scooter in Ride Mode should not transition when music starts.");
    }

    @Test
    void ParkedStateNoTransitionOnSideStandParked() {
        OlaScooter scooter = new OlaScooter(ParkedState.getInstance());
        scooter.sideStandParked();
        assertTrue(scooter.getState() instanceof ParkedState, "Scooter in Parked State should not transition on side stand parked.");
    }
}
