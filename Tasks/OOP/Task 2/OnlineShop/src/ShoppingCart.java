import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> items;

    public ArrayList<Product> getItems() {
        return items;
    }

    public ShoppingCart(){
        items=new ArrayList<>();
    }

    public void addItem(Product p){
        items.add(p);
    }
    public void removeItem(int itemNum){
       if(itemNum<=items.size()-1)
           items.remove(itemNum);
       else
           throw new RuntimeException("Product Not Found");
    }
    public float totalCost(){
        float cost=0f;

        for(int i=0;i<items.size();i++){
            cost+=items.get(i).getPrice();
        }
        return cost;
    }


}
