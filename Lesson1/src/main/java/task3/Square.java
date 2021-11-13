package task3;


public class Square extends Shape{
    private int side;

    public Square(int side, String color) {
        super(color);
        this.side = side;
    }

    @Override
    public void displayFigure() {
        System.out.println("Square{" +
                "color='" + color + '\'' +
                ", side=" + side +
                '}');
    }
}
