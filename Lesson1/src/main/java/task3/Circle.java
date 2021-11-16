package task3;


public class Circle extends Shape {

    private int radius;

    public Circle(int radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    public void displayFigure() {
        System.out.println("Circle{" +
                "color='" + color + '\'' +
                ", radius=" + radius +
                '}');
    }
}
