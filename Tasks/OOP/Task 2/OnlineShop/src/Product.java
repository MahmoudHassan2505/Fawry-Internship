public class Product {
    private String Name;
    private float Price;

public Product(String productName,float productPrice){
    setName(productName);
    setPrice(productPrice);
}
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
       if(price<=0)
           throw new RuntimeException("Price cannot be a negative number");
       this.Price = price;
    }
}
