import java.util.Scanner;

public class Player {
    private String name;
    private int favoriteNumber;
    private int matchCount;
    private Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getFavoriteNumber() {
        return favoriteNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void setMatchCount(int count) {
        this.matchCount = count;
    }

    public void chooseNumber() {
        System.out.print("[" + name + "] 정수 선택(1~10)>>");
        this.favoriteNumber = scanner.nextInt();
    }
}
