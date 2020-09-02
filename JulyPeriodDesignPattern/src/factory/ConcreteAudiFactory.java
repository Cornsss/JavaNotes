package factory;

import factory.simplefactory.CarFactory;

public class ConcreteAudiFactory implements AbstractFactory{

    @Override
    public CarFactory makeCar() {
        return new AudiCar();
    }
}
