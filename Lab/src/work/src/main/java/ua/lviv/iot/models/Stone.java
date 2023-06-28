    package work.src.main.java.ua.lviv.iot.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public abstract class Stone {

    public String name;
    public String color;
    public double weightInGrams;
    public double pricePerGram;

    public double getFullPrice(){
        return 0;
    }


    public String getHeaders(){
        return "name," + "color," + "weightInGrams," + "pricePerGram";
    }

    public String toCSV() {
        return name + "," + color + "," + weightInGrams + "," + pricePerGram;
    }
}
