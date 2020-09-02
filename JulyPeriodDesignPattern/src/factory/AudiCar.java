package factory;

import factory.simplefactory.CarFactory;

public class AudiCar implements CarFactory {
    public void getCarName() {
        System.out.println("This is Audi!!!!");
    }
}
