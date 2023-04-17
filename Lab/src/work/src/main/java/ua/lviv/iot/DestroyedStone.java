package work.src.main.java.ua.lviv.iot;

public class DestroyedStone extends Stone{

    private double destructionIndex;

    public DestroyedStone(String name, String color, double weightInGrams, double pricePerGram, double destructionIndex){
        super(name, color, weightInGrams, pricePerGram);
        this.destructionIndex = destructionIndex;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HEADER
    public String getHeaders(){
        return super.getHeaders() + "," + "destructionIndex";
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CSV
    public String toCSV() {
        return super.toCSV() + "," + destructionIndex;
    }

    @Override
    public double getFullPrice() {
        return pricePerGram / destructionIndex;
    }
}
