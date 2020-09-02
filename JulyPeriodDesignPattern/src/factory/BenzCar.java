package factory;

import factory.simplefactory.CarFactory;

public class BenzCar implements CarFactory{
    public void getCarName() {
        System.out.println("This is Benz!!!!");
    }
}
