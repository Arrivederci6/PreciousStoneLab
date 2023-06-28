package work.src.main.java.ua.lviv.iot.writter;

import lombok.*;
import work.src.main.java.ua.lviv.iot.models.Stone;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

@ToString
@Getter
public class StoneWriter {
    public String writeToFile(List<Stone> stones, String fileName) {
        if(stones == null || stones.isEmpty()){
            return null;
        }

        File file = new File(fileName);

        try (PrintWriter stoneWriter = new PrintWriter(file)){
            for (var stone : stones) {
                stoneWriter.println(stone.getHeaders());
                stoneWriter.println(stone.toCSV());
            }
        }
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return fileName;
    };
}