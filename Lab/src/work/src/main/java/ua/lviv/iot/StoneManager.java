package work.src.main.java.ua.lviv.iot;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


public class StoneManager {

    @Getter
    public static List<Stone> stones = new ArrayList();

    public void addStone(final Stone stone){
        stones.add(stone);
    }

    public List<Stone> findStonesWithPricePerGramHigherThan(double price){
        return stones
                .stream()
                .filter(stone -> stone.pricePerGram > price)
                .toList();
    }

    public List<Stone> findStonesByColor(String color){
        return stones
                .stream()
                .filter(stone -> stone.color.equals(color))
                .toList();
    }
}

