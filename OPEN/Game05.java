import java.util.Scanner;

abstract class Player {
    protected String[] choices = {"묵", "찌", "빠"};
    protected String name;
    protected String lastChoice = null;

    protected Player(String name) { this.name = name; }

    public String getName() { return name; }
    public String getChoice() { return lastChoice; }
    abstract public String nextMove();
}

class Human extends Player {
    private Scanner scanner = new Scanner(System.in);

    public Human(String name) {
        super(name);
    }

    @Override
    public String nextMove() {
        while (true) {
            System.out.print(name + ">>");
            String input = scanner.next();
            for (String option : choices) {
                if (input.equals(option)) {
                    lastChoice = input;
                    return lastChoice;
                }
            }
            System.out.println("묵, 찌, 빠 중 하나를 입력하세요.");
        }
    }
}

class Computer extends Player {
    public Computer(String name) {
        super(name);
    }

    @Override
    public String nextMove() {
        int index = (int)(Math.random() * choices.length);
        System.out.println(name + ">> 선택 완료");
        lastChoice = choices[index];
        return lastChoice;
    }
}

class Game {
    private Player[] players = new Player[2];
    private Scanner scanner = new Scanner(System.in);

    public Game() { }

    private void setupPlayers() {
        System.out.print("사람 이름 입력>>");
        String name = scanner.next();
        players[0] = new Human(name);

        System.out.print("컴퓨터 이름 입력>>");
        name = scanner.next();
        players[1] = new Computer(name);
        System.out.println("두 명의 플레이어가 설정되었습니다...\n");
    }

    public void play() {
        System.out.println("***** 묵찌빠 게임 시작 *****");
        setupPlayers();
        int ownerIndex = 0;
        while (true) {
            String ownerMove = players[ownerIndex].nextMove();
            int opponentIndex = (ownerIndex + 1) % 2;
            String opponentMove = players[opponentIndex].nextMove();

            System.out.println(players[ownerIndex].getName() + " : " + players[ownerIndex].getChoice() +
                    ", " + players[opponentIndex].getName() + " : " + players[opponentIndex].getChoice());

            if (ownerMove.equals(opponentMove)) {
                System.out.println("\n" + players[ownerIndex].getName() + " 승리!");
                break;
            }

            if ((ownerMove.equals("묵") && opponentMove.equals("빠")) ||
                    (ownerMove.equals("찌") && opponentMove.equals("묵")) ||
                    (ownerMove.equals("빠") && opponentMove.equals("찌"))) {
                ownerIndex = opponentIndex;
                System.out.println("오너가 " + players[ownerIndex].getName() + "로 변경되었습니다.");
            }
            System.out.println();
        }

        System.out.println("게임 종료");
    }
}

public class Game05 {

    public static void main(String[] args) {
        new Game().play();
    }

}
