import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car pobi;

    @BeforeEach
    void initializePobi() {
        pobi = new Car("pobi");
    }

    @Test
    void carCreationTest() {
        assertEquals(pobi.getName(), "pobi");
        assertEquals(pobi.getLocation(), 0);
    }

    @Test
    void goForwardTest() {
        pobi.goForward();
        assertEquals(pobi.getLocation(), 1);
    }

    @Test
    void moveTest() {
        pobi.move();
        assertTrue(pobi.getLocation() == 0 || pobi.getLocation() == 1);
    }
}