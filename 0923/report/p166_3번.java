import java.util.Scanner;

public class p166_3번 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n;
        while (true) {
            System.out.print("양의 정수 입력>>");
            n = scanner.nextInt();
            if (n > 0)
                break;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
