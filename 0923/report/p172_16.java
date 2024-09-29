import java.util.Scanner;

public class p172_16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = 0;

        System.out.print("양의 정수를 입력하세요. -1은 입력 끝>>");
        while (true) {
            String input = scanner.next();

            if (input.equals("-1")) {
                break;
            }

            try {
                int num = Integer.parseInt(input);

                if (num > 0) {
                    sum += num;
                    count++;
                } else {
                    System.out.println(num + " 제외");
                }
            } catch (NumberFormatException e) {
                System.out.println(input + " 제외");
            }
        }

        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("평균은 " + (int) average);
        } else {
            System.out.println("입력된 양의 정수가 없습니다.");
        }

        scanner.close();
    }
}
