package ua.lviv.iot.algo.part1.preciousStone;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class PreciousStone extends Stone {
    private double clarity;
    private static PreciousStone instance = new PreciousStone();

    public PreciousStone(String name, String color, double weightInGrams, double pricePerGram, double clarity){
        super(name, color, weightInGrams, pricePerGram);
        this.clarity = clarity;
    }

    public static PreciousStone getInstance() {
        return instance;
    }

    public void increaseClarity() {
        clarity++;
    }

    public void increasePrice(double percentage) {
        pricePerGram += pricePerGram / percentage;
    }

    @Override
    public double getFullPrice() {
        return weightInGrams * pricePerGram * clarity;
    }

}
