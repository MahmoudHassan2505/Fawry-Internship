package factroy;

import Furniture.com.*;

public class VictorianFactory implements AbstractFactory{

    @Override
    public FurnitureI get(FurnitureType furnitureType) {
        switch (furnitureType){
            case Chair :
                return new VictorianChair();
            case Sofa:
                return new VictorianSofa();
            case CoffeTable:
                return new VictorianCoffeTable();
            default:
                return null;
        }    }
}
