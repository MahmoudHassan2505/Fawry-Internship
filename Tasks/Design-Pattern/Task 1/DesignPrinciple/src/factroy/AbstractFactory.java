package factroy;

import Furniture.com.FurnitureI;
import Furniture.com.FurnitureType;

public interface  AbstractFactory {
    public  FurnitureI get(FurnitureType furnitureType);
}
