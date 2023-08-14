package Factory.SimpleFactory;

public class VehicleFactory {
    public static Vehicle create(String s){
        Vehicle v=null;
        if(s=="Car")
            v=new Car();
        if(s=="Motorcycle")
            v=new Motorcycle();
        return v;

    }
    //if we have a huge number of types this will become a mess
}
