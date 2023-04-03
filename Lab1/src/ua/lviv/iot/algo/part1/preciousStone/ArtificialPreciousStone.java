package ua.lviv.iot.algo.part1.preciousStone;

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

    @Override
    public double getFullPrice(){ return weightInGrams * pricePerGram ;}
}
