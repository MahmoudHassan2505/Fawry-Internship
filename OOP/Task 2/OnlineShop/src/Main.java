
public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop",30000);
        Product p2 = new Product("PC",53000);
        Product p3 = new Product("Phone",25300);
        Product p4 = new Product("Headphone",1250);
        Product p5 = new Product("Mouse",800);
        Product p6 = new Product("Charger",450);


        ShoppingCart s1=new ShoppingCart();
        s1.addItem(p1);
        s1.addItem(p2);
        s1.addItem(p3);
        s1.removeItem(2);

        OrderProcessor o=new OrderProcessor();
        o.placeOrder(s1);

    }
}