package task3;


public class Triangle extends Shape{

    private int cathetus1;
    private int cathetus2;
    private int hypotenuse;

    public Triangle(int cathetus1, int cathetus2, int hypotenuse, String color) {
        super(color);
        this.cathetus1 = cathetus1;
        this.cathetus2 = cathetus2;
        this.hypotenuse = hypotenuse;
    }

    @Override
    public void displayFigure() {
        System.out.println("Triangle{" +
                "color='" + color + '\'' +
                ", cathetus1=" + cathetus1 +
                ", cathetus2=" + cathetus2 +
                ", hypotenuse=" + hypotenuse +
                '}');
    }
}
