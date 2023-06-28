package work.src.main.java.ua.lviv.iot;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArtificialPreciousStone extends Stone{

    private String stoneLaboratoryName;

    public ArtificialPreciousStone(String name, String color, double weightInGrams, double pricePerGram, String stoneLaboratoryName){
        super(name, color, weightInGrams, pricePerGram);
        this.stoneLaboratoryName = stoneLaboratoryName;
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~HEADER
    @Override
    public String getHeaders(){
        return super.getHeaders() + "," + "stoneLaboratoryName";
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CSV
    @Override
    public String toCSV() {
        return super.toCSV() + "," + stoneLaboratoryName;
    }

    @Override
    public double getFullPrice(){ return weightInGrams * pricePerGram ;}
}
