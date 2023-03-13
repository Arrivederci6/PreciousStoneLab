package ua.lviv.iot.algo.part1.preciousStone;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PreciousStone {
    private String name;
    private double carat;
    private String color;
    private double clarity;
    private double pricePerCarat;
    private static PreciousStone instance = new PreciousStone();

    public static PreciousStone getInstance() {
        return instance;
    }

    public double getTotalPrice(){
        return carat * pricePerCarat;
    }

    public void increaseClarity(){
        clarity++;
    }

    public void increasePrice(double percentage){
        pricePerCarat += pricePerCarat / percentage;
    }

    public static void main(String[] args) {
        PreciousStone[] preciousStoneArray = {
                new PreciousStone(),
                new PreciousStone("Diamond", 12.5, "Aqua-Blue", 19.9, 9.99),
                PreciousStone.getInstance(),
                PreciousStone.getInstance()};

        for (PreciousStone stone: preciousStoneArray) {
            System.out.println(stone);
        }
    }
}