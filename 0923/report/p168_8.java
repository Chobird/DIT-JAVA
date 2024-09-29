import java.util.Scanner;

public class p168_8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 몇 개 저장하시겠습니까>> ");
        int count = scanner.nextInt();

        int[] numbers = new int[count];
        int index = 0;

        while (index < count) {
            int randomNum = (int)(Math.random() * 100) + 1;
            boolean isDuplicate = false;

            // 중복 확인
            for (int i = 0; i < index; i++) {
                if (numbers[i] == randomNum) {
                    isDuplicate = true;
                    break;
                }
            }

            // 중복이 아니면 배열에 저장
            if (!isDuplicate) {
                numbers[index] = randomNum;
                index++;
            }
        }

        int total = 0;
        System.out.print("랜덤한 정수들...");
        for (int num : numbers) {
            System.out.print(num + " ");
            total += num;
        }

        System.out.println();
        System.out.println("평균은 " + (double) total / count);

        scanner.close();
    }
}
