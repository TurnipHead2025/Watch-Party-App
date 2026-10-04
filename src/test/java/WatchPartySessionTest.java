import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class WatchPartySessionTest {
    
    @Test
    public void testIsPlayingDefaultsToFalse() {
        WatchPartySession session = new WatchPartySession(new Production());
       assertFalse(session.isPlaying());
    }

    @Test
    public void testPlaySetsIsPlayingToTrue() {
        WatchPartySession session = new WatchPartySession(new Production());
        session.play();
        assertTrue(session.isPlaying()); 
       }

    @Test
    public void testPauseSetsIsPlayingToFalse() {
        WatchPartySession session = new WatchPartySession(new Production());
        session.play();
        session.pause();
        assertFalse(session.isPlaying());
    }  
    
    @Test
    public void testNextBeatDoesNotAdvanceWhenPaused() {
        WatchPartySession session = new WatchPartySession(new Production());
        session.nextBeat(); //isPlaying starts with false
        assertEquals(0, session.getCurrentBeatIndex()); //if nextbeat is called when paused nextBeat should remain 0
    }

    @Test
    public void testNextBeatIncrementsIndexWhenPlaying() {
        WatchPartySession session = new WatchPartySession(new Production());
        session.play();         //isPlaying == true
        session.nextBeat();     // advance to next beat
        assertEquals(1,session.getCurrentBeatIndex());
    }

    @Test
    public void testPreviousBeatDoesNotDropBelowZero() {
         WatchPartySession session = new WatchPartySession(new Production());       
         session.play();  //isPlaying == true
         session.previousBeat();
         assertEquals(0,session.getCurrentBeatIndex());
    }


}
