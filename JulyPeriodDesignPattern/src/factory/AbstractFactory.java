package factory;

import factory.simplefactory.AudiCar;
import factory.simplefactory.BenzCar;
import factory.simplefactory.CarFactory;

public interface AbstractFactory {
    public CarFactory makeCar();
}
