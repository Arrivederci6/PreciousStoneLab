package ua.lviv.iot.algo.part1.preciousStone;

import lombok.*;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StoneManager {

    @Getter
    public List<Stone> stones = new ArrayList();

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

    public static void main(String[] args) {

        var stoneManager = new StoneManager();

        FossilStone fossilStoneFirst = new FossilStone("Coal", "Black", 99.99, 14.99, 0.69);
        FossilStone fossilStoneSecond = new FossilStone("Turf", "Brown", 49.99, 99.99, 0.49);

        DestroyedStone destroyedStoneFirst = new DestroyedStone("Ruby", "Red", 49.99, 99.99, 0.49);
        DestroyedStone destroyedStoneSecond = new DestroyedStone("Sapphire", "Black", 9.99, 399.99, 1);

        PreciousStone preciousStoneFirst = new PreciousStone("Diamondo", "Aqua", 9.99, 499.99, 1);
        PreciousStone preciousStoneSecond = new PreciousStone("Emeraldo", "Green", 9.99, 299.99, 1);

        ArtificialPreciousStone artificialPreciousStoneFirst = new ArtificialPreciousStone("Fake Diamondo","Blue",9.99,0.99,"LPNU");
        ArtificialPreciousStone artificialPreciousStoneSecond = new ArtificialPreciousStone("Not Fake Diamondo","Aqua - Blue",9.99,0.09,"LvivNationalLab");

        stoneManager.addStone(fossilStoneFirst);
        stoneManager.addStone(fossilStoneSecond);
        stoneManager.addStone(destroyedStoneFirst);
        stoneManager.addStone(destroyedStoneSecond);
        stoneManager.addStone(preciousStoneFirst);
        stoneManager.addStone(preciousStoneSecond);
        stoneManager.addStone(artificialPreciousStoneFirst);
        stoneManager.addStone(artificialPreciousStoneSecond);

        var highCostStones = stoneManager.findStonesWithPricePerGramHigherThan(69.99);
        var blackStones = stoneManager.findStonesByColor("Black");

        System.out.println("\n");
        for (var stone : stoneManager.stones) {
            System.out.println(stone);
        }
        System.out.println("\n");
        for (var highCostStone: highCostStones) {
            System.out.println(highCostStone);
        }
        System.out.println("\n");
        for (var blackStone: blackStones) {
            System.out.println(blackStone);
        }
    }
}

