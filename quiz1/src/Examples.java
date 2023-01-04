import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {
    SuperMarket PriceChopper = new SuperMarket("Price Chopper", "", true, 50, 1500);
    SuperMarket Target = new SuperMarket("Target", "", true, 100, 3000);

    @Test
    public void test1() {
        assertFalse(PriceChopper.busierThan(Target));
    }

}
