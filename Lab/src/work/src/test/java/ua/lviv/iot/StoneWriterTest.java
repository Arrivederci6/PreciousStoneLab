package work.src.test.java.ua.lviv.iot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import work.src.main.java.ua.lviv.iot.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class StoneWriterTest {
    private static final String EXPECTED_FILENAME = "expected.csv";
    private static final String RESULT_FILENAME = "result.csv";
    private StoneWriter writer;
    private StoneManager manager;

    @BeforeEach
    public void setUp() {
        this.writer = new StoneWriter();
        this.manager = new StoneManager();
    }

    //Якщо ліст manager.getStones() - пустий, і ми його порівнюємо за допомогою assertNull - тест пройдено.
    @Test
    public void testWriteIfListIsEmpty() throws IOException{
        assertNull(writer.writeToFile(manager.getStones(),RESULT_FILENAME));
    }

    //Чи правильно записується ліст. RESULT_FILENAME - записуємо стадіони. EXPECTED_FILENAME - очікуємо в результаті методу врайту.

    @Test
    public void testWriteListOfStones() throws IOException{
        manager.addStone(new PreciousStone("Diamondo","Aqua-Blue", 99.9, 59.9, 1));
        manager.addStone(new ArtificialPreciousStone("Emeraldo","Light-Green", 99.9, 19.9, "LPNU"));
        manager.addStone(new FossilStone("Coal","Dark", 99.9, 9.9, 100));
        manager.addStone(new DestroyedStone("Destroyed Amethyst","Purple", 99.9, 39.9, 8.5));

        Path expected = new File(EXPECTED_FILENAME).toPath();
        Path result = new File(RESULT_FILENAME).toPath();

        writer.writeToFile(manager.getStones(), RESULT_FILENAME);

        assertEquals(-1L, Files.mismatch(expected, result));
    }

    @Test
    public void testWriteCheckIfFileIsCreated() throws IOException{
        manager.addStone(new PreciousStone("Diamondo","Aqua-Blue", 99.9, 59.9, 1));
        manager.addStone(new ArtificialPreciousStone("Emeraldo","Light-Green", 99.9, 19.9, "LPNU"));
        manager.addStone(new FossilStone("Coal","Dark", 99.9, 9.9, 100));
        manager.addStone(new DestroyedStone("Destroyed Amethyst","Purple", 99.9, 39.9, 8.5));

        File result = new File(RESULT_FILENAME);

        assertTrue(result.exists());


    }
}