package Decorator;

public class SimpleSandwich implements Sandwich{

    @Override
    public String make() {
        return "Making Simple Sandwich";
    }

    @Override
    public double getPrice() {
        return 30.0;
    }
}
