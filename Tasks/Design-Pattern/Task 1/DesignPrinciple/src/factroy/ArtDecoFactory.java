package factroy;

import Furniture.com.*;

public class ArtDecoFactory implements AbstractFactory{

    public FurnitureI get(FurnitureType furnitureType) {
        switch (furnitureType){
            case Chair :
                return new ArtDecoChair();
            case Sofa:
                return new ArtDecoSofa();
            case CoffeTable:
                return new ArtDecoCoffeTable();
            default:
                return null;
        }

    }
}
