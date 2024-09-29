import java.util.Scanner;

public class p167_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n[] = new int[10];

        System.out.print("양의 정수 10개 입력>>");
        for (int i = 0; i < n.length; i++) {
            n[i] = scanner.nextInt();
        }

        int count = 0;
        System.out.print("3의 배수는...");
        for (int i = 0; i < n.length; i++) {
            if (n[i] % 3 == 0) {
                System.out.print(n[i] + " ");
                count++;
            }
        }

        if (count == 0) {
            System.out.println("없습니다.");
        } else {
            System.out.println();
        }

        scanner.close();
    }
}
