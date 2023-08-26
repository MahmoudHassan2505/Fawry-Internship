package factroy;

import Furniture.com.*;

public class ModernFactory implements AbstractFactory{

    @Override
    public FurnitureI get(FurnitureType furnitureType) {
        switch (furnitureType){
            case Chair :
                return new ModernChair();
            case Sofa:
                return new ModernSofa();
            case CoffeTable:
                return new ModernCoffeTable();
            default:
                return null;
        }
    }
}
