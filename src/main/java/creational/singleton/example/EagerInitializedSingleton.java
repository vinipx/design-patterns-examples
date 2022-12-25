package creational.singleton.example;

public class EagerInitializedSingleton {
    private static EagerInitializedSingleton instance;
    //private constructor for avoiding client applications for using constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}
