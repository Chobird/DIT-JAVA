import java.util.InputMismatchException;
import java.util.Scanner;

public class p172_17 {

    public static void main(String[] args) {
        String coffee[] = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int price[] = {3000, 3500, 4000, 5000};

        Scanner scanner = new Scanner(System.in);

        for(int i=0; i<coffee.length; i++) {
            if(i == coffee.length - 1)
                System.out.print(coffee[i] + " ");
            else
                System.out.print(coffee[i] + ", ");
        }
        System.out.println("있습니다.");

        while(true) {
            System.out.print("주문>>");
            String name = scanner.next();
            if(name.equals("그만"))
                break;

            int count = 0;
            try {
                count = scanner.nextInt();
            }
            catch(InputMismatchException e) {
                System.out.println("잔 수는 양의 정수로 입력해주세요!");
                scanner.nextLine();
                continue;
            }

            if(count <= 0) {
                System.out.println("잔 수는 양의 정수로 입력해주세요!");
                continue;
            }

            boolean found = false;
            int cost = 0;
            for(int i=0; i<coffee.length; i++) {
                if(coffee[i].equals(name)) {
                    cost = price[i]*count;
                    System.out.println("가격은 " +  cost + "원입니다.");
                    found = true;
                    break;
                }
            }

            if(found == false) {
                System.out.println(name + "은 없는 메뉴입니다.");
            }
        }
        scanner.close();
    }
}
