package test;

import factory.simplefactory.BenzCar;
import factory.simplefactory.CarFactory;
import factory.simplefactory.SimpleFactory;

public class CarFactoryTest1 {
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        CarFactory car = factory.makeCar("Audi");
        car.getCarName();
    }
}
