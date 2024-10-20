import java.util.ArrayList;
import java.util.Scanner;

abstract class Shape { // 추상 클래스 Shape
    public abstract void draw();
}

class Line extends Shape { // Line 클래스
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape { // Rect 클래스
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape { // Circle 클래스
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

public class GraphicEditor {
    private ArrayList<Shape> shapes = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void insert() {
        System.out.print("Line(1), Rect(2), Circle(3)>>");
        int choice = scanner.nextInt();
        Shape shape = null;
        switch (choice) {
            case 1:
                shape = new Line();
                break;
            case 2:
                shape = new Rect();
                break;
            case 3:
                shape = new Circle();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                return;
        }
        shapes.add(shape);
    }

    public void delete() {
        System.out.print("삭제할 도형의 위치>>");
        int index = scanner.nextInt();
        if (index < 1 || index > shapes.size()) {
            System.out.println("삭제할 수 없습니다.");
        } else {
            shapes.remove(index - 1);
        }
    }

    public void viewAll() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public void run() {
        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    viewAll();
                    break;
                case 4:
                    System.out.println("Beauty Graphic Editor를 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.run();
    }
}