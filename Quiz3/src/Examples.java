import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {
    @Test
    public void testStore2() {
        StoreItem redGrapes = new StoreItem("red grapes", "produce", 0, 20210423);
        StoreItem greenGrapes = new StoreItem("green grapes", "produce", 20210423);

        assertTrue(redGrapes.equals(greenGrapes));
    }
}
