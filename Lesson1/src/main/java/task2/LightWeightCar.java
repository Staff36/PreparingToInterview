package task2;

public class LightWeightCar extends Car {

    //Simple constructor to display difference between cars
    public LightWeightCar(String name) {
        super.name = name;
    }

    public LightWeightCar() {
    }

    @Override
    public void open() {
        System.out.println("Car is open");
    }

}
