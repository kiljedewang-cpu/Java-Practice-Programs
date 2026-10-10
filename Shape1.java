abstract class Shape {

    abstract void calc_area();

    abstract void calc_volume();
}

// Sphere
class Sphere extends Shape {

    double radius;

    Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    void calc_area() {
        double area = 4 * Math.PI * radius * radius;
        System.out.println("Sphere Area = " + area);
    }

    @Override
    void calc_volume() {
        double volume = (4.0 / 3.0) * Math.PI * radius * radius * radius;
        System.out.println("Sphere Volume = " + volume);
    }
}

// Cone
class Cone extends Shape {

    double radius;
    double height;

    Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    void calc_area() {
        double slantHeight = Math.sqrt(
            radius * radius + height * height
        );

        double area = Math.PI * radius *
                      (radius + slantHeight);

        System.out.println("Cone Area = " + area);
    }

    @Override
    void calc_volume() {
        double volume = (1.0 / 3.0) * Math.PI *
                        radius * radius * height;

        System.out.println("Cone Volume = " + volume);
    }
}

// Cylinder
class Cylinder extends Shape {

    double radius;
    double height;

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    void calc_area() {
        double area = 2 * Math.PI * radius *
                      (radius + height);

        System.out.println("Cylinder Area = " + area);
    }

    @Override
    void calc_volume() {
        double volume = Math.PI * radius *
                        radius * height;

        System.out.println("Cylinder Volume = " + volume);
    }
}

// Box
class Box extends Shape {

    double length;
    double breadth;
    double height;

    Box(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    @Override
    void calc_area() {
        double area = 2 * (
            length * breadth +
            breadth * height +
            length * height
        );

        System.out.println("Box Area = " + area);
    }

    @Override
    void calc_volume() {
        double volume = length * breadth * height;

        System.out.println("Box Volume = " + volume);
    }
}

// Main class
public class Shape1 {

    public static void main(String[] args) {

        Shape s1 = new Sphere(5);
        Shape s2 = new Cone(5, 10);
        Shape s3 = new Cylinder(5, 10);
        Shape s4 = new Box(5, 6, 10);

        System.out.println("----- SPHERE -----");
        s1.calc_area();
        s1.calc_volume();

        System.out.println("\n----- CONE -----");
        s2.calc_area();
        s2.calc_volume();

        System.out.println("\n----- CYLINDER -----");
        s3.calc_area();
        s3.calc_volume();

        System.out.println("\n----- BOX -----");
        s4.calc_area();
        s4.calc_volume();
    }
}
