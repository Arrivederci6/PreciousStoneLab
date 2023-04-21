package work.src.main.java.ua.lviv.iot;

import lombok.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

@ToString
@Getter
public class StoneWriter {
    public String writeToFile(List<Stone> stones, String fileName) {
        File file = new File(fileName);

        try (PrintWriter stoneWriter = new PrintWriter(file)){
            Stone stoneType = stones.get(0);
            stoneWriter.println(stones.get(0).getHeaders());
            for (var stone : stones) {
                if (stoneType.getClass() != stone.getClass()) {
                    stoneType = stone;
                    stoneType.println(stone.getHeaders());
                }
                stoneWriter.println(stone.toCSV());
            }
        }
        catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return fileName;
    };
}

//У даному коді створюється об'єкт класу PrintWriter, який використовується для запису даних у файл.
//
//Далі використовується змінна stones, яка містить список каменів. У рядку Stone stoneType = stones.get(0);
// створюється змінна stoneType з посиланням на перший камінь у списку stones.
// Це виконується для того, щоб зберегти тип першого каменю у змінній stoneType та далі порівнювати цей тип з типами інших каменів.
//
//Далі у рядку stoneWriter.println(stones.get(0).getHeaders()); записується рядок заголовків для каменів у файл. Це виконується лише один раз на початку запису.
//
//Потім використовується цикл for (var stone : stones), який проходить по всіх каменях у списку.
// У цьому циклі спочатку порівнюється тип поточного каменю з типом збереженого у змінній stoneType у рядку if (stoneType.getClass() != stone.getClass()).
// Якщо типи не співпадають, то значення змінної stoneType змінюється на тип поточного каменю і записуються рядки заголовків для цього типу каменю у файл.
//
//Після цього записується рядок з даними про камінь у файл, використовуючи метод toCSV() класу Stone. Цей процес повторюється для кожного каменю у списку.
//
//Усі ці дії виконуються у try-with-resources блоку, що дозволяє автоматично закривати об'єкт PrintWriter після завершення запису даних у файл або
// виникнення будь-якого винятку.