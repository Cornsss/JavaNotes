package factory;

import factory.simplefactory.CarFactory;

public class ConcreteBenzFactory implements AbstractFactory{

    @Override
    public CarFactory makeCar() {
        return new BenzCar();
    }
}
