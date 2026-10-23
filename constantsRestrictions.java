// Constants and Restrictions (final + static)
// Write a program for a Circle and Shape scenario that demonstrates all three uses of final:
// • Declare static final double PI = 3.14159 and use it to compute area and circumference.
// • Declare a blank final variable id in Circle and initialize it through the constructor.
// • Declare a final method display() in class Shape and try to override it in Circle.

class Shape {
    public final void Display() {
        System.out.println("This is a generic Shape class");
    }
}

class Circle extends Shape {
    public static final double PI = 3.14159;

    public final int id;
    double radius;

    public Circle(int id, double r) {
        this.id = id;
        this.radius = r;
    }

    public double calculateArea() {
        return PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * PI * radius;
    }

    public void displayCircleDetails() {
        System.out.println("Circle ID            : " + id);
        System.out.println("Radius               : " + radius);
        System.out.println("Area                 : " + calculateArea());
        System.out.println("Circumference        : " + calculateCircumference());
        System.out.println("-----------------------------------");
    }
}

public class constantsRestrictions {
    public static void main(String[] args) throws Exception {
        Shape shape = new Shape();
        System.out.println("Shape Display");
        shape.Display();
        System.out.println();

        Circle circle1 = new Circle(101, 5.0);
        Circle circle2 = new Circle(102, 7.5);

        System.out.println("---- CIRCLE DETAILS -----");
        circle1.displayCircleDetails();
        circle2.displayCircleDetails();

        System.out.println("Value of PI (constant): " + Circle.PI);

    }
}
