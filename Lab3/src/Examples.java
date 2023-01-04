import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;

public class Examples {
    LinkedList<Double> rain = new LinkedList<Double>();

    Planning rainlist = new Planning(rain, 0,0 );

    public Examples() {
        rain.add(5.0);
        rain.add(7.0);
        rain.add(-4.8);
        rain.add(-999.0);
        rain.add(2.5);
    }

    @Test
    public void testAverageRainfall() {
        assertEquals(6.0, rainlist.rainfall(rain));
    }
}


