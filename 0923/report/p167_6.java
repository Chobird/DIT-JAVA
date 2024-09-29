import java.util.Scanner;

public class p167_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n[] = new int[10];

        System.out.print("양의 정수 10개 입력>>");
        for (int i = 0; i < 10; i++) {
            n[i] = scanner.nextInt();
        }

        System.out.print("자리수의 합이 9인 것은 ...");
        for (int i = 0; i < 10; i++) {
            int num = n[i];
            int sum = 0;
            while (num > 0) {
                sum = sum + (num % 10);
                num = num / 10;
            }
            if (sum == 9) {
                System.out.print(n[i] + " ");
            }
        }

        System.out.println();
        scanner.close();
    }
}
