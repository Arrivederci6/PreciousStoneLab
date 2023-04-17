package work.src.test.java.ua.lviv.iot;

import lombok.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import work.src.main.java.ua.lviv.iot.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class FossilStoneTest {

    private PreciousStone preciousStone;
    @BeforeAll
    private void createTempFile(String fileName, String content) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(content);
        writer.close();
    }

    @BeforeEach
    public void setUp() {
        preciousStone = new PreciousStone();

        List<Stone> stones = new ArrayList();

        FossilStone fossilStoneFirst = new FossilStone("Coal", "Black", 99.99, 14.99, 0.69);
        FossilStone fossilStoneSecond = new FossilStone("Turf", "Brown", 49.99, 99.99, 0.49);

        DestroyedStone destroyedStoneFirst = new DestroyedStone("Ruby", "Red", 49.99, 99.99, 0.49);
        DestroyedStone destroyedStoneSecond = new DestroyedStone("Sapphire", "Black", 9.99, 399.99, 1);

        PreciousStone preciousStoneFirst = new PreciousStone("Diamondo", "Aqua", 9.99, 499.99, 1);
        PreciousStone preciousStoneSecond = new PreciousStone("Emeraldo", "Green", 9.99, 299.99, 1);

        ArtificialPreciousStone artificialPreciousStoneFirst = new ArtificialPreciousStone("Fake Diamondo","Blue",9.99,0.99,"LPNU");
        ArtificialPreciousStone artificialPreciousStoneSecond = new ArtificialPreciousStone("Not Fake Diamondo","Aqua - Blue",9.99,0.09,"LvivNationalLab");

        stones.add(fossilStoneFirst);
        stones.add(fossilStoneSecond);
        stones.add(destroyedStoneFirst);
        stones.add(destroyedStoneSecond);
        stones.add(preciousStoneFirst);
        stones.add(preciousStoneSecond);
        stones.add(artificialPreciousStoneFirst);
        stones.add(artificialPreciousStoneSecond);

        StoneWriter stoneWriter = new StoneWriter();
        stoneWriter.writeToFile(stones);

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
    public void testGetHeadersWithEnergyBurnedPerGramSuccess() {
        FossilStone coal = new FossilStone("Coal", "Black", 99.9, 0.9,  0.5);
        String expectedHeaders = "name,color,weightInGrams,pricePerGram,energyBurnedPerGram";
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
