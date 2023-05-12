package work.src.test.java.ua.lviv.iot;

import lombok.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import work.src.main.java.ua.lviv.iot.PreciousStone;
import work.src.main.java.ua.lviv.iot.StoneManager;

import static org.junit.jupiter.api.Assertions.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class StoneManagerTest {

    private PreciousStone preciousStone;
    private PreciousStone preciousStone1;
    private StoneManager manager;
    @BeforeEach
    public void setUp() {
        this.preciousStone = new PreciousStone("Coal", "Black", 99.99, 0.00, 0.69);
        this.preciousStone1 = new PreciousStone("Turf", "Brown", 49.99, 99.99, 0.49);
        this.manager = new StoneManager();
    }

    @Test
    void testAddStone(){
        manager.addStone(preciousStone);
        manager.addStone(preciousStone1);
        assertEquals(2, manager.getStones().size());
    }

    @Test
    void testFindStonesWithPricePerGramHigherThan(){
        manager.addStone(preciousStone);
        manager.addStone(preciousStone1);

        var result = manager.findStonesWithPricePerGramHigherThan(50.0);

        assertEquals(2, result.size());

        for (var resultCheck: result) {
            assertEquals(50.0, resultCheck.getPricePerGram());
        }
    }
    @Test
    void testFindStonesByColor(){
        manager.addStone(preciousStone);
        manager.addStone(preciousStone1);

        var result = manager.findStonesByColor("Black");

        assertEquals(2, result.size());

        for (var resultCheck: result) {
            assertEquals("Black", resultCheck.getColor());
        }
    }
}