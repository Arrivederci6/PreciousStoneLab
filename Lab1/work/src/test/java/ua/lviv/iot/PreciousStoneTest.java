package ua.lviv.iot.algo.part1.preciousStone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreciousStoneTest {

    private PreciousStone preciousStone;

    @BeforeEach
    public void setUp() {
        preciousStone = new PreciousStone();
    }

    @Test
    void getInstance(){
        PreciousStone preciousStone1 = PreciousStone.getInstance();
        PreciousStone preciousStone2 = PreciousStone.getInstance();
        // Ensure both objects are the same instance
        assertSame(preciousStone1, preciousStone2);
    }

    @Test
    void testIncreaseClarity(){
        // Get initial clarity
        double initialClarity = preciousStone.getClarity();
        // Call increaseClarity() method
        preciousStone.increaseClarity();
        // Get updated clarity
        double updatedClarity = preciousStone.getClarity();
        // Ensure clarity is increased by 1
        assertEquals(initialClarity + 1, updatedClarity);
    }

    @Test
    void testIncreasePrice(){
        double initialPrice = 10.0;
        double percentage = 50.0;
        preciousStone.setPricePerGram(initialPrice);

        preciousStone.increasePrice(percentage);

        double expectedPrice = initialPrice + (initialPrice * percentage / 100);
        assertEquals(expectedPrice, preciousStone.pricePerGram);
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