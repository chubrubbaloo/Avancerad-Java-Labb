package Uppgift2;

public class CarFactory {

    public Car buildCar(CarType carType) {
        return switch (carType){
            case SPORTS -> new Bmw();
            case HATCHBACK -> new Honda();
            case SUV -> new Toyota();
        };

    }

}
