package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<ProductModel> products;
    public ProductRepository(){
        products = new ArrayList<>();
        products.add(new ProductModel("Car",5));
        products.add(new ProductModel("aaa",6));
        products.add(new ProductModel("ddr",7));
        products.add(new ProductModel("asdaw",8));
    }

    public void add(String name,int id){
        products.add(new ProductModel(name,id));
    }

    public void remove(String name,int id){
        products.remove(new ProductModel(name,id));
    }

    public List<ProductModel> listAll(){

        return products;
    }
}
