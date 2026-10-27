import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.watchparty.beat.Beat;

public class BeatTest {

    @Test
    public void testGetContentReturnsCorrectText() {
        Beat beat = new Beat("City of stars", "Street bench", "Dim blue", "Stage right");

        assertEquals("City of stars", beat.getContent());
    }

    @Test
    public void testSetContentUpdatesCorrectly() {
        Beat beat = new Beat("City of stars", "Street bench", "Dim blue", "Stage right");

        beat.setContent("New content");

        assertEquals("New content", beat.getContent());
    }

    @Test
    public void testSetLightingUpdatesCorrectly() {
         Beat beat = new Beat("City of stars", "Street bench", "Dim blue", "Stage right");

         beat.setLighting("Bright amber");
         
         assertEquals("Bright amber", beat.getLighting());
    }

    @Test
    public void testNoArgConstructorInitializesObject() {
        Beat beat = new Beat();

        assertNotNull(beat);
    }


    
}
