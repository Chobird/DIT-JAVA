interface Shape {
    double PI = 3.14;
    void draw();
    double getArea();
    default public void redraw() {
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("반지름이 " + radius + "인 원");
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }
}

class Oval implements Shape {
    private int width, height;

    public Oval(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(width + "x" + height + "에 내접하는 타원");
    }

    @Override
    public double getArea() {
        return PI * width * height;
    }
}

class Rect implements Shape {
    private int width, height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(width + "x" + height + "크기의 사각형");
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

public class ShapeEx {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(5);
        shapes[1] = new Oval(20, 30);
        shapes[2] = new Rect(10, 40);

        for (Shape shape : shapes) shape.redraw();
        for (Shape shape : shapes) System.out.println("면적은 " + shape.getArea());
    }
}
