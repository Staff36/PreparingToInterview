import task1.Person;
import task2.Car;
import task2.LightWeightCar;
import task2.Lorry;
import task3.Circle;
import task3.Shape;
import task3.Square;
import task3.Triangle;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1");
        Person person = new Person.PersonBuilder()
                .withFirstName("Vasily")
                .withMiddleName("Vasilievich")
                .withLastName("Ivanov")
                .withAddress("Lenina 1")
                .withAge(50)
                .withCountry("UK")
                .withGender("male") //maybe enum?
                .withPhone("89999999999")
                .build();
        System.out.println(person);
        System.out.println("======================================================\n");
        System.out.println("Task2");
        List<Car> cars = List.of(new LightWeightCar("Prius"), new Lorry("Man"), new Lorry());
        cars.forEach(car -> {
            System.out.println(car);
            car.open();
            car.move();
            car.stop();
        });
        System.out.println("======================================================\n");
        System.out.println("Task3");
        List<Shape> shapes = List.of(
                new Triangle(12,11, 20, "Red"),
                new Square(5, "Yellow"),
                new Circle(15, "Green")
        );
        shapes.forEach(Shape::displayFigure);
    }
}
