public class OrderProcessor {

    public void placeOrder(ShoppingCart s){
        for (int i=0;i<s.getItems().size();i++){
            System.out.print(
                    "Name: "+s.getItems().get(i).getName()+"\t"+
                    "Price: "+s.getItems().get(i).getPrice()+"\n");
        }
        System.out.println("Total Cost= "+s.totalCost());
    }
}
