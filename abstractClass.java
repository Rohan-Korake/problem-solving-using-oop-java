abstract class Shape {
    String name;

    public Shape(String name) {
        this.name = name;
    }

    abstract double area();

    void displayInfo() {
        System.out.println("Shape : " + name + " & Area : " + area());
    }
}

class Reactangle extends Shape {
    double length, width;

    public Reactangle(double length, double width) {
        super("Reactangle");
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    double area() {
        return 3.14 * radius * radius;
    }
}

class Triangle extends Shape {
    double base;
    double height;

    public Triangle(double base, double height) {
        super("Triangle");
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
};

public class abstractClass {
    public static void main(String args[]) {

        Shape[] shape = new Shape[3];
        shape[0] = new Reactangle(10.2, 20.5);
        shape[1] = new Circle(10.5);
        shape[2] = new Triangle(10.4, 20.5);

        for (Shape sh : shape) {
            sh.displayInfo();
        }
        return;
    }
}