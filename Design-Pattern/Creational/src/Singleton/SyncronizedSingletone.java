package Singleton;

public class SyncronizedSingletone {

    private static SyncronizedSingletone instance;
    private SyncronizedSingletone(){}
    //to Avoide Multithreading Problem We put synchronized annotation before method
    //this make when one thread go in the method it suspends the others until it Done in method
    public static synchronized SyncronizedSingletone getInstance(){
        if(instance==null)
            instance= new SyncronizedSingletone();
        return instance;
    }
}
//The Proplem with this Implementation if we already have an instance it
// still just one thread can Access the method in the same time
