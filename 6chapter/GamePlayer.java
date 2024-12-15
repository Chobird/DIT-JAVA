import java.util.Scanner;

public class GamePlayer {
    private String name;
    private Scanner scanner = new Scanner(System.in);

    public GamePlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void getEnterKey() {
        scanner.nextLine();
    }

    public boolean turn() {
        System.out.print("[" + name + "]:<Enter>");
        getEnterKey();

        int[] num = new int[3];
        for (int i = 0; i < num.length; i++) {
            num[i] = (int)(Math.random() * 3 + 1);
        }

        System.out.print("\t");
        for (int n : num) {
            System.out.print(n + "  ");
        }

        boolean result = true;
        for (int n : num) {
            if (n != num[0]) {
                result = false;
                break;
            }
        }

        return result;
    }
}
