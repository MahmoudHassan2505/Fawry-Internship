package Singleton;

public class BestSingletone {
    private static BestSingletone instance;
    private BestSingletone(){
        //For more safety
        if(instance!=null)
            throw new RuntimeException("Error");
    }

    //we put the syncronized annotation in the middle of the body of the method not on the header
    public static BestSingletone getInstance(){
        if(instance==null){
                //syncronized Block
            synchronized (BestSingletone.class){
                if(instance==null)
                    instance=new BestSingletone();

            }
        }
        return instance;
    }
}
