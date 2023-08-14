import Factory.Factorymethod.Website;
import Factory.Factorymethod.WebsiteFactory;
import Factory.Factorymethod.WebsiteType;
import Factory.SimpleFactory.Vehicle;
import Factory.SimpleFactory.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        //SimpleFactory Pattern
        Vehicle v= VehicleFactory.create("Motorcycle");
        //-------------------------------------------------------------------------------
        //Factory Method Pattern
        Website w= WebsiteFactory.getWebsite(WebsiteType.Shop);
        //---------------------------------------------------------------------------------

        }
    }
