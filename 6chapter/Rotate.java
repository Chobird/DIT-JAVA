import java.util.Scanner;

public class Rotate{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            String rotated = input.substring(i) + input.substring(0, i);
            System.out.println(rotated);
        }

        scanner.close();
    }
}
