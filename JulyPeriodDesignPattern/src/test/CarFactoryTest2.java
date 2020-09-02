package test;

import factory.AbstractFactory;
import factory.ConcreteAudiFactory;
import factory.simplefactory.CarFactory;

public class CarFactoryTest2 {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteAudiFactory();
        CarFactory carFactory = factory.makeCar();
        carFactory.getCarName();
    }
}
