import java.util.Scanner;

public class 실습2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("생일 입력 하세요>>");
        int birth = scanner.nextInt();

        int year = birth / 10000;
        int monnth = (birth % 10000) / 100;
        int day = birth % 100;

        System.out.println(year +"년" + monnth+ "월"+ day +"일");

        scanner.close();
    }
}
