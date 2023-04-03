package ua.lviv.iot.algo.part1.preciousStone;

public class FossilStone extends Stone{
    private double energyPerBurnedGram;

    public FossilStone(String name, String color, double weightInGrams, double pricePerGram, double energyPerBurnedGram){
        super(name, color, weightInGrams, pricePerGram);
        this.energyPerBurnedGram = energyPerBurnedGram;
    }
    @Override
    public double getFullPrice() {
        return pricePerGram * energyPerBurnedGram;
    }
}
