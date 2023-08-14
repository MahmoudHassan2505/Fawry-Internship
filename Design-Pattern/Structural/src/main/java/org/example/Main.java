package org.example;


import Adapter.EmplyeeAdapter;
import Adapter.NewEmplyee;
import Adapter.OldEmployeeImp;
import Adapter.OldEmplyeeI;
import Decorator.*;
import Facade.FacadeShape;
import Proxy.CommandExecuterProxy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Adapter Pattern
        List<OldEmplyeeI> employee=new ArrayList<>();

        employee.add(new OldEmployeeImp("Mahmoud","Ghania",2500));
        employee.add(new OldEmployeeImp("Ahmed","Mohamed",3000));

        NewEmplyee e1= new NewEmplyee("Ziad","Ahmed",5000);
        employee.add(new EmplyeeAdapter(e1));

        System.out.println(employee);
        //---------------------------------------------------------------------------------

        //Decorator Pattern

        Sandwich doublemeatSandwich;
        doublemeatSandwich = new MeatDecorator(new MeatDecorator(new SimpleSandwich()));
        System.out.println(doublemeatSandwich.make()+" = "+doublemeatSandwich.getPrice());

        Sandwich cheesemeatSandwich;
        cheesemeatSandwich = new CheeseDecorator(new MeatDecorator(new SimpleSandwich()));
        System.out.println(cheesemeatSandwich.make()+" = "+cheesemeatSandwich.getPrice());
        //--------------------------------------------------------------------------------------

        //Facade Pattern
        FacadeShape facadeShape =new FacadeShape();

        facadeShape.drawCircle();
        facadeShape.drawRectangle();
        facadeShape.drawSquare();
        //-----------------------------------------------------------------------------------------

        //Proxy Pattern

        CommandExecuterProxy cmd =new CommandExecuterProxy("admin","123");
        cmd.run("HHH");

    }
}