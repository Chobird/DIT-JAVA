import java.util.Scanner;

public class p168_10 {

    public static void main(String[] args) {
        int[][] array = new int[4][4];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = (int) (Math.random() * 256);
            }
        }

        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("임계값 입력>> ");
        int threshold = scanner.nextInt();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] > threshold) {
                    array[i][j] = 255;
                } else {
                    array[i][j] = 0;
                }
            }
        }

        System.out.println("임계값 적용 후 배열:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
