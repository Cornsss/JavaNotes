package factory.simplefactory;

public class SimpleFactory {
    public CarFactory makeCar(String type){
        if("Benz".equals(type)){
            return new BenzCar();
        }else if("Audi".equals(type)){
            return new AudiCar();
        }
        return null;
    }
}
