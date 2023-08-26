package org.example.Original;

public class OriginalImp implements Original{

    @Override
    public void OriginalDouble(double doubleNumber) {

        System.out.println("Double: "+doubleNumber);
    }

    @Override
    public void OriginalInt(int intNumber) {

        System.out.println("Integer: "+intNumber);
    }

    @Override
    public void OriginalChar(char character) {

        System.out.println("Char: "+character);
    }
}
