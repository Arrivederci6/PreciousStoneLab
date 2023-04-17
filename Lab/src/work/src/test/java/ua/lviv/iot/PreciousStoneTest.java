package work.src.test.java.ua.lviv.iot;

import lombok.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import work.src.main.java.ua.lviv.iot.FossilStone;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
        double initialClarity = preciousStone.getClarity();

        preciousStone.increaseClarity();

        double updatedClarity = preciousStone.getClarity();

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


    @Test
    public void testGetHeadersWithClaritySuccess() {
        FossilStone coal = new FossilStone("Coal", "Black", 99.9, 0.9,  0.5);
        String expectedHeaders = "name,color,weightInGrams,pricePerGram,clarity";
        String actualHeaders = coal.getHeaders();
        assertEquals(expectedHeaders, actualHeaders);
    }

    @Test
    public void testGetHeadersEmptyFileFailure() throws IOException {
        String fileName = "emptyFile.txt";
        createTempFile(fileName, "");
        FossilStone fossilStone = new FossilStone();
        try {
            fossilStone.getHeaders(fileName);
            fail("exception");
        } catch (IOException e) {
            assertEquals("file is empty", e.getMessage());
        }
    }
}