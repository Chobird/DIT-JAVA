import java.util.HashMap;
import java.util.Scanner;

public class P4 {
    private HashMap<String, Integer> items = new HashMap<>();

    public P4() {
        items.put("고추장", 3000);
        items.put("만두", 500);
        items.put("새우깡", 1500);
        items.put("콜라", 600);
        items.put("참치캔", 2000);
        items.put("치약", 1000);
        items.put("연어", 2500);
        items.put("삼겹살", 2500);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("쇼핑 비용을 계산해드립니다. 구입가능한 물건과 가격은 다음과 같습니다:");
        System.out.println(items);

        while (true) {
            System.out.print("물건과 개수를 입력하세요>>");
            String input = scanner.nextLine();
            if (input.equals("그만"))
                break;

            String[] tokens = input.split(" ");
            if (tokens.length % 2 != 0) {
                System.out.println("입력에 문제가 있습니다!");
                continue;
            }

            int totalCost = 0;
            boolean error = false;

            for (int i = 0; i < tokens.length; i += 2) {
                String item = tokens[i];
                int quantity;

                try {
                    quantity = Integer.parseInt(tokens[i + 1]);
                } catch (NumberFormatException e) {
                    System.out.println("입력에 문제가 있습니다!");
                    error = true;
                    break;
                }

                if (!items.containsKey(item)) {
                    System.out.println(item + "은(는) 없는 상품입니다!");
                    error = true;
                    break;
                }

                totalCost += items.get(item) * quantity;
            }

            if (!error) {
                System.out.println("전체 비용은 " + totalCost + "원입니다");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        P4 app = new P4();
        app.run();
    }
}
