package Singleton;

public class ClassicSingletone {
    private static ClassicSingletone instance;
    //create a Private Constructor to Prevent anyone from Creating object from the class
    private ClassicSingletone(){}
    //Create a Static method to allow any one to access this method without creating object
    public static ClassicSingletone getInstance(){
        if(instance==null)
            instance= new ClassicSingletone();
        return instance;
    }
}
//problem with this implemntation is when using Multithreading

