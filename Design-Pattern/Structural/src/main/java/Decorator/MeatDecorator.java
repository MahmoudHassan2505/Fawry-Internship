package Decorator;

public class MeatDecorator extends SandwichDecorator{

    public MeatDecorator(Sandwich sandwich){
        super(sandwich);
    }

    @Override
    public String make(){
        return super.make()+" + Meat";
    }

    @Override
    public double getPrice(){
        return super.getPrice()+50;
    }
}
