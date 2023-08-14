package Decorator;

public class SandwichDecorator implements Sandwich{

    private Sandwich sandwich;

    public SandwichDecorator(Sandwich sandwich){
        this.sandwich=sandwich;
    }
    @Override
    public String make() {
        return sandwich.make();
    }

    @Override
    public double getPrice() {
        return sandwich.getPrice();
    }
}
