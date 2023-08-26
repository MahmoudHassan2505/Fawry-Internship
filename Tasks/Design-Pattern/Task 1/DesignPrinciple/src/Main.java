import Furniture.com.FurnitureType;
import factroy.AbstractFactory;
import factroy.ArtDecoFactory;
import factroy.VictorianFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory f1=new VictorianFactory();
        f1.get(FurnitureType.CoffeTable).Draw();

        }
    }
