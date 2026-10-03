import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class BeatTest {

    @Test
    public void testGetBeatIdReturnsCorrectId() {
        Beat beat = new Beat("BEAT_01", "City of stars", "Street bench", "Dim blue", "Stage right");

        assertEquals("BEAT_01", beat.getBeatId());
    }

    @Test
    public void testGetLyricsReturnsCorrectText() {
        Beat beat = new Beat("BEAT_01", "City of stars", "Street bench", "Dim blue", "Stage right");

        assertEquals("City of stars", beat.getLyrics());        
    }

    @Test
    public void testSetLightingUpdatesCorrectly() {
         Beat beat = new Beat("BEAT_01", "City of stars", "Street bench", "Dim blue", "Stage right");

         beat.setLighting("Bright amber");
         
         assertEquals("Bright amber", beat.getLighting());
    }

    @Test
    public void testNoArgConstructorInitializesObject() {
        Beat beat = new Beat();

        assertNotNull(beat);
    }


    
}
