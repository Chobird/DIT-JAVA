import java.util.Scanner;

public class p168_11 {

    public static void main(String[] args) {
        System.out.println("***** 구구단 퀴즈입니다. *****");
        Scanner scanner = new Scanner(System.in);

        int incorrectAnswers = 0;
        while (true) {
            int n = (int) (Math.random() * 9) + 1;
            int m = (int) (Math.random() * 9) + 1;
            int correctAnswer = n * m;

            System.out.print(n + " x " + m + " = ");
            int Answer = scanner.nextInt();

            if (Answer == correctAnswer) {
                System.out.println("정답입니다!");
            } else {
                incorrectAnswers++;
                if (incorrectAnswers == 3) {
                    System.out.println(incorrectAnswers + "번 틀렸습니다. 퀴즈를 종료합니다.");
                    break;
                } else {
                    System.out.println("틀렸습니다. 지금까지 " + incorrectAnswers + "번 틀렸습니다.");
                }
            }
        }
        scanner.close();
    }
}
