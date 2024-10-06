import java.util.Scanner;

class Player {
    private String name;
    private int winnerCount;
    private int lastGuessNumber;

    public Player(String name) {
        this.name = name;
        this.winnerCount = 0;
    }

    public String getName() { return name; }
    public int getWinnerCount() { return winnerCount; }
    public void addWinnerCount() { winnerCount++; }

    public int getGuessNumber() { return lastGuessNumber; }
    public void setGuessNumber(int n) { lastGuessNumber = n; }

    public void show() {
        System.out.print(name + ":" + winnerCount);
    }
}

public class GuessGame {
    private String name;
    private Player[] players = null;
    private Scanner scanner = new Scanner(System.in);

    public GuessGame(String name) {
        this.name = name;
    }

    private void createPlayers() {
        System.out.print("게임에 참여할 선수 수>>");
        int n = scanner.nextInt();
        players = new Player[n];
        for (int i = 0; i < n; i++) {
            System.out.print("선수 이름>>");
            String name = scanner.next();
            players[i] = new Player(name);
        }
    }

    private void doGame() {
        while (true) {
            int hiddenAnswer = (int)(Math.random() * 100 + 1);
            System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");

            for (int i = 0; i < players.length; i++) {
                String playerName = players[i].getName();
                System.out.print(playerName + ">>");
                int guessNumber = scanner.nextInt();
                if (guessNumber <= 0 || guessNumber > 100) {
                    System.out.println("1~100사이의 숫자만 입력하세요!!");
                    i--;
                    continue;
                }
                players[i].setGuessNumber(guessNumber);
            }

            Player nearestPlayer = decideNearestPlayer(hiddenAnswer);
            nearestPlayer.addWinnerCount();

            System.out.println("정답은 " + hiddenAnswer + ". " + nearestPlayer.getName() + "이 이겼습니다. 승점 1점 확보!");
            System.out.print("계속하려면 yes 입력>>");
            String res = scanner.next();
            if (res.equals("yes"))
                continue;
            else {
                Player winner = decideWinner();
                printAllWinnerCount();
                System.out.print(winner.getName() + "이 최종 승리하였습니다.");
                break;
            }
        }
    }

    private Player decideNearestPlayer(int hiddenAnswer) {
        Player nearestPlayer = players[0];
        int nearestDiff = Math.abs(hiddenAnswer - nearestPlayer.getGuessNumber());
        for (int i = 0; i < players.length; i++) {
            int diff = Math.abs(hiddenAnswer - players[i].getGuessNumber());
            if (diff < nearestDiff) {
                nearestDiff = diff;
                nearestPlayer = players[i];
            }
        }

        return nearestPlayer;
    }

    private Player decideWinner() {
        Player winner = players[0];
        for (int i = 0; i < players.length; i++) {
            if (winner.getWinnerCount() < players[i].getWinnerCount())
                winner = players[i];
        }

        return winner;
    }

    private void printAllWinnerCount() {
        for (int i = 0; i < players.length; i++) {
            players[i].show();
            System.out.print(" ");
        }
        System.out.println();
    }

    public void run() {
        System.out.println("*** " + name + "을 시작합니다. ***");
        createPlayers();
        doGame();
    }

    public static void main(String[] args) {
        GuessGame game = new GuessGame("예측 게임");
        game.run();
    }
}
