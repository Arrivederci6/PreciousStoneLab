package work.src.main.java.ua.lviv.iot.models;


import work.src.main.java.ua.lviv.iot.models.Stone;

public class FossilStone extends Stone {
    private double energyPerBurnedGram;

    public FossilStone(String name, String color, double weightInGrams, double pricePerGram, double energyPerBurnedGram){
        super(name, color, weightInGrams, pricePerGram);
        this.energyPerBurnedGram = energyPerBurnedGram;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HEADER
    @Override
    public String getHeaders(){
        return super.getHeaders() + "," + "energyPerBurnedGram";
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CSV
    @Override
    public String toCSV() {
        return super.toCSV() + "," + energyPerBurnedGram;
    }

    @Override
    public double getFullPrice() {
        return pricePerGram * energyPerBurnedGram;
    }
}
