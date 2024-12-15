import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberExpectationGame {
    private List<Player> players = new ArrayList<>();
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    public void initializePlayers() {
        System.out.print("게임에 참여할 선수들 이름>> ");
        String[] names = scanner.nextLine().split(" ");
        for (String name : names) {
            Player player = new Player(name);
            player.chooseNumber();
            players.add(player);
        }
    }

    public void playGame() {
        while (true) {
            System.out.println("Enter키 입력>>");
            scanner.nextLine();
            int[] randomNumbers = new int[15];
            for (int i = 0; i < randomNumbers.length; i++) {
                randomNumbers[i] = random.nextInt(10) + 1;
                System.out.print(randomNumbers[i] + " ");
            }
            System.out.println();

            for (Player player : players) {
                int count = 0;
                for (int number : randomNumbers) {
                    if (number == player.getFavoriteNumber()) {
                        count++;
                    }
                }
                player.setMatchCount(count);
                System.out.println("[" + player.getName() + "] 맞춘 개수: " + count);
            }

            int minCount = Integer.MAX_VALUE;
            for (Player player : players) {
                if (player.getMatchCount() < minCount) {
                    minCount = player.getMatchCount();
                }
            }

            List<Player> losers = new ArrayList<>();
            for (Player player : players) {
                if (player.getMatchCount() == minCount) {
                    losers.add(player);
                }
            }

            if (losers.size() == 1) {
                System.out.println("\n최종 패자는 " + losers.get(0).getName() + "입니다.");
                break;
            } else {
                System.out.print("현재 패자들 : ");
                for (Player loser : losers) {
                    System.out.print(loser.getName() + " ");
                }
                System.out.println();
                players = losers;
            }
        }
    }

    public static void main(String[] args) {
        NumberExpectationGame game = new NumberExpectationGame();
        game.initializePlayers();
        game.playGame();
    }
}
