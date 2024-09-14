import java.util.Scanner;

public class 실습1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("$1=1200원입니다 ");
        System.out.print("달러를 입력하세요 : ");
        int ekffj = scanner.nextInt();

        int won = ekffj * 1200;

        System.out.println("$" +ekffj +"는 " + won +"원 입니다");

        scanner.close();
    }
}
