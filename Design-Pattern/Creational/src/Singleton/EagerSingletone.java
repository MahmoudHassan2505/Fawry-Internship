package Singleton;

public class EagerSingletone {
    private static EagerSingletone instance=new EagerSingletone();
    private EagerSingletone(){}
    public static EagerSingletone getInstance(){
                  return instance;
    }
}
//if we implement it like this the object is created
// when running the programm and the programe will be susspended
// until the object is created