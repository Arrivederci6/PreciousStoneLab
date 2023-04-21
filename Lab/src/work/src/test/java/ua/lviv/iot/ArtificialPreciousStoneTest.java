package work.src.test.java.ua.lviv.iot;





import lombok.*;
import org.junit.jupiter.api.*;
import work.src.main.java.ua.lviv.iot.PreciousStone;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class ArtificialPreciousStoneTest {

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