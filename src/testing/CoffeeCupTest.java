package testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoffeeCupTest {

    private CoffeeCup cup = new CoffeeCup(50,40);

    @BeforeEach
    public void setup() {
        cup = new CoffeeCup(50, 40);
    }

    @Test
    void testConstructor() {
        assertEquals(cup.getCapacity(), 50);
        assertEquals(cup.getCurrentVolume(), 40);
        assertNotSame(cup.getCapacity(), 0);
        assertNotSame(cup.getCurrentVolume(), 0);
    }

    @Test
    void testIncreaseVolume() {
        cup.increaseCupSize(20);
        assertNotSame(cup.getCapacity(), 50);
        assertEquals(cup.getCapacity(), 70);

    }

    @Test
    void testDrink() {
        cup.drinkCoffee(30);
        assertEquals(cup.getCapacity(), 50);
        assertEquals(cup.getCurrentVolume(), 10);
        assertNotSame(cup.getCurrentVolume(), 50);
        assertThrows(IllegalArgumentException.class, () -> {
            cup.drinkCoffee(100);
        });
        cup.drinkCoffee(5);
        assertEquals(cup.getCurrentVolume(), 5);
    }

    @Test
    void testFill() {
        assertEquals(cup.getCurrentVolume(), 40);
        cup.fillCoffee(10);
        assertEquals(cup.getCurrentVolume(), 50);
        assertThrows(IllegalArgumentException.class, () -> {
            cup.fillCoffee(1);
        });
        cup.increaseCupSize(20);
        assertEquals(cup.getCapacity(), 70);
        cup.fillCoffee(1);
        assertEquals(cup.getCurrentVolume(), 51);
        assertThrows(IllegalArgumentException.class, () -> {
            cup.fillCoffee(20);
        });
    }

}
