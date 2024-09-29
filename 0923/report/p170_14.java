import java.util.Scanner;
import java.util.Random;

public class p170_14 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        System.out.println("갬블링 게임을 시작합니다.");

        while (true) {
            System.out.print("엔터키 입력>>");
            scanner.nextLine();  // 사용자가 엔터키를 입력할 때까지 대기

            int num1 = r.nextInt(3);
            int num2 = r.nextInt(3);
            int num3 = r.nextInt(3);

            System.out.println(num1 + " " + num2 + " " + num3);

            if (num1 == num2 && num2 == num3) {
                System.out.println("성공! 대박났어요!");

                System.out.print("계속하시겠습니까?(yes/no)>>");
                String answer = scanner.next();
                if (answer.equalsIgnoreCase("no")) {
                    System.out.println("게임을 종료합니다.");
                    break;
                }
                scanner.nextLine(); // 버퍼 초기화
            }
        }

        scanner.close();
    }
}
