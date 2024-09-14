import java.util.Scanner;

public class 실습3 {
    public static void main(String[] args) {
        final int price_1 = 2000;//떡볶이
        final int price_2 = 1000;//김말이
        final int price_3 = 3000;//쫄면

        Scanner scanner = new Scanner(System.in);

        System.out.println("**** 자바 분식입니다. 주문하면 금액을 알려드립니다. ****");

        System.out.print("떡볶이 몇 인분>>");
        int ttok = scanner.nextInt();//떡볶이

        System.out.print("김말이 몇 인분>>");
        int gim = scanner.nextInt();//김말이

        System.out.print("쫄면 몇 인분>>");
        int mun = scanner.nextInt();//쫄면

        int total = (ttok * price_1) +
                (gim * price_2) +
                (mun * price_3);

        System.out.println("전체 금액은 " + total + "원입니다.");

        scanner.close();
    }
}
