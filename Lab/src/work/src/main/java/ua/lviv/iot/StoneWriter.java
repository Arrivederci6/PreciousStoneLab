package work.src.main.java.ua.lviv.iot;

import lombok.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@ToString
@Getter

public class StoneWriter {

    public void writeToFile(List<Stone> stones) {
        try {
            FileWriter writer = new FileWriter("stones.csv");

            writer.write(stones.get(0).getHeaders() + "\n");

            for (Stone stone : stones) {
                writer.write(stone.toCSV() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error" + e.getMessage());
        }
    }
}




