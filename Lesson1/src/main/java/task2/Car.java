package task2;

import lombok.ToString;


@ToString
public abstract class Car implements Moveable, Openable {
    protected Engine engine;
    protected String color;
    protected String name;

    {
        name = "Car";
    }

    @Override
    public void open() {
        System.out.println(name + " is opening");
    }

    @Override
    public void stop() {
        System.out.println(name + " is stopping");
    }

    @Override
    public void move() {
        if (engine != null) {
            System.out.println(name + " is moving");
            return;
        }
        System.out.println(name + " cannot moves Engine is null");
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}




