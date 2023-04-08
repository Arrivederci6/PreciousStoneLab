package ua.lviv.iot.algo.part1.preciousStone;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DestroyedStoneTest {

    private PreciousStone preciousStone;

    @BeforeEach
    public void setUp() {
        preciousStone = new PreciousStone();
    }

    @Test
    void testGetFullPrice(){
        double weightInGrams = 50.0;
        double pricePerGram = 10.0;
        double clarity = 0.9;
        double expectedFullPrice = 50.0 * 10.0 * 0.9;
        double actualFullPrice = preciousStone.getFullPrice();
        assertEquals(expectedFullPrice, actualFullPrice);
    }
}