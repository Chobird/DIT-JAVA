import java.util.Scanner;

public class WordGameApp {
    private Scanner scanner;
    private String initialWord = "아버지";
    private Player[] participants;

    public WordGameApp() {
        scanner = new Scanner(System.in);
    }

    private void initializePlayers() {
        System.out.print("게임에 참가하는 인원은 몇명입니까>>");
        int numPlayers = scanner.nextInt();
        participants = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("참가자의 이름을 입력하세요>>");
            String name = scanner.next();
            participants[i] = new Player(name);
        }
    }

    private boolean isWordChainValid(String previousWord, String currentWord) {
        return previousWord.charAt(previousWord.length() - 1) == currentWord.charAt(0);
    }

    public void startGame() {
        System.out.println("끝말잇기 게임을 시작합니다...");
        initializePlayers();
        String previousWord = initialWord;

        System.out.println("시작하는 단어는 " + previousWord + "입니다");
        int turn = 0;

        while (true) {
            String currentWord = participants[turn].promptWord();
            if (!isWordChainValid(previousWord, currentWord)) {
                System.out.print(participants[turn].getName() + "이 졌습니다.");
                break;
            }
            turn = (turn + 1) % participants.length;
            previousWord = currentWord;
        }
    }

    public static void main(String[] args) {
        WordGameApp game = new WordGameApp();
        game.startGame();
    }
}

class Player {
    private Scanner scanner;
    private String name;

    public Player(String name) {
        this.name = name;
        scanner = new Scanner(System.in);
    }

    public String getName() {
        return name;
    }

    public String promptWord() {
        System.out.print(name + ">>");
        return scanner.next();
    }
}
