import java.util.Scanner;

abstract class Box {
    protected int size;

    public Box(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public abstract boolean consume();
    public abstract void print();
}

class IngredientBox extends Box {
    private String name;

    public IngredientBox(String name, int size) {
        super(size);
        this.name = name;
    }

    @Override
    public boolean consume() {
        if (!isEmpty()) {
            size--;
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        System.out.print(name + " ");
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println(" " + size);
    }
}

public class Coffee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IngredientBox coffee = new IngredientBox("커피", 5);
        IngredientBox cream = new IngredientBox("프림", 5);
        IngredientBox sugar = new IngredientBox("설탕", 5);

        System.out.println("*****청춘 커피 자판기 입니다.*****");

        while (true) {
            coffee.print();
            cream.print();
            sugar.print();

            System.out.print("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>> ");
            int choice = sc.nextInt();

            if (choice == 4) {
                System.out.println("청춘 커피 자판기 프로그램을 종료합니다.");
                break;
            }

            boolean success = false;

            switch (choice) {
                case 1:
                    if (coffee.consume() && cream.consume() && sugar.consume()) {
                        success = true;
                    }
                    break;
                case 2:
                    if (coffee.consume() && sugar.consume()) {
                        success = true;
                    }
                    break;
                case 3:
                    if (coffee.consume()) {
                        success = true;
                    }
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
                    continue;
            }

            if (!success) {
                System.out.println("원료가 부족합니다.");
            }
        }

        sc.close();
    }
}
