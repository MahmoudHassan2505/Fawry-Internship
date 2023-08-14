package Decorator;

public class CheeseDecorator extends SandwichDecorator {
    public CheeseDecorator(Sandwich sandwich){
        super(sandwich);
    }

    @Override
    public String make(){
        return super.make()+" + Cheese";
    }

    @Override
    public double getPrice(){
        return super.getPrice()+10;
    }
}
