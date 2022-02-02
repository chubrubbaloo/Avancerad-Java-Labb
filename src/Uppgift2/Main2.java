package Uppgift2;

public class Main2 {

 public static void main(String[] args) {
  CarFactory carFactory = new CarFactory();

  Car fastCar = carFactory.buildCar(CarType.SPORTS);
  Car economyCar = carFactory.buildCar(CarType.HATCHBACK);
  Car familyCar = carFactory.buildCar(CarType.SUV);

  fastCar.makeCarNoise();
  economyCar.makeCarNoise();
  familyCar.makeCarNoise();

 }


}
