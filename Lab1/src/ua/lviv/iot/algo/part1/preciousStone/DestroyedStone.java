package ua.lviv.iot.algo.part1.preciousStone;

public class DestroyedStone extends Stone{

    private double destructionIndex;

    public DestroyedStone(String name, String color, double weightInGrams, double pricePerGram, double destructionIndex){
        super(name, color, weightInGrams, pricePerGram);
        this.destructionIndex = destructionIndex;
    }
    @Override
    public double getFullPrice() {
        return pricePerGram / destructionIndex;
    }
}
