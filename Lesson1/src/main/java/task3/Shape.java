package task3;

import lombok.Data;

@Data
public abstract class Shape {

    String color;

    public Shape(String color) {
        this.color = color;
    }

    public abstract void displayFigure();
}
