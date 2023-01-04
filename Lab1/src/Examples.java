import static org.junit.Assert.*;

import com.sun.tracing.dtrace.Attributes;
import org.junit.Test;

public class Examples {
    Album Plans = new Album("Death Cab For Cutie", "Indie Rock");
    Song HapBD = new Song("Happy Birthday", 18, Plans);


    public Examples(){}
    @Test
    public void checkHBlen() {
        assertEquals(18, HapBD.lenInSeconds);
    }
    @Test
    public void checkAlbum() {
        assertEquals(Plans, HapBD.onAlbum);
    }
    @Test
    public void checkSongName() {
        assertEquals("", HapBD.title);
    }

    /*
    // This shows what a test case looks like
    @Test 
    public void simpleCheck() {
	assertEquals(4, 4);
    }
    */

}