package work.src.test.java.ua.lviv.iot.writters;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import work.src.main.java.ua.lviv.iot.manager.StoneManager;
import work.src.main.java.ua.lviv.iot.models.ArtificialPreciousStone;
import work.src.main.java.ua.lviv.iot.models.DestroyedStone;
import work.src.main.java.ua.lviv.iot.models.FossilStone;
import work.src.main.java.ua.lviv.iot.models.PreciousStone;
import work.src.main.java.ua.lviv.iot.writter.StoneWriter;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

class StoneWriterTest {
    private static final String EXPECTED_FILENAME = "expected.csv";
    private static final String RESULT_FILENAME = "result.csv";
    private StoneWriter writer;
    private StoneManager manager;

    @BeforeEach
    public void setUp() {
        this.writer = new StoneWriter();
        this.manager = new StoneManager();

        manager.addStone(new PreciousStone("Diamondo","Aqua-Blue", 99.9, 59.9, 1));
        manager.addStone(new ArtificialPreciousStone("Emeraldo","Light-Green", 99.9, 19.9, "LPNU"));
        manager.addStone(new FossilStone("Coal","Dark", 99.9, 9.9, 100));
        manager.addStone(new DestroyedStone("Destroyed Amethyst","Purple", 99.9, 39.9, 8.5));

        writer.writeToFile(manager.getStones(), EXPECTED_FILENAME);
    }

    @Test
    public void testWriteIfListIsEmpty() throws IOException{
        assertTrue(new File(RESULT_FILENAME).exists());
        assertNull(writer.writeToFile(List.of(),RESULT_FILENAME));

    }

    @Test
    public void testWriteListOfStones() throws IOException{
        Path expected = new File(EXPECTED_FILENAME).toPath();
        Path result = new File(RESULT_FILENAME).toPath();

        writer.writeToFile(manager.getStones(), RESULT_FILENAME);

        assertEquals(-1L, Files.mismatch(expected, result));
    }

//    @Test
//    public void testWriteCheckIfFileIsCreated(){
//        File result = new File(RESULT_FILENAME);
//        result.write("text for test");
//
//        assertTrue(result.exists());
//    }
    @Test
    public void testWriterOverride() throws IOException {
        File result = new File(RESULT_FILENAME);
        result.write("text for test");
        result.close();
        testWriteListOfStones();
//        StoneWriter testWriter = new StoneWriter(RESULT_FILENAME);
//        testWriter.write("error");
//        StoneWriter expectedWriter = new StoneWriter(EXPECTED_FILENAME);
//        testWriter.write("error");
//        writer.writeToFile(stones, RESULT_FILENAME);
//        assertNotEquals(RESULT_FILENAME,EXPECTED_FILENAME);
    }
}