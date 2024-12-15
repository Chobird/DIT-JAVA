import java.util.Random;
import java.util.Scanner;

public class WordGame {
    private static final String[] words = {"happy", "morning", "package", "together", "lovely", "sunny", "extract", "nation", "cookie", "connect"};
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("10초 안에 단어를 맞추세요!!");

        while (true) {
            String word = words[random.nextInt(words.length)];
            String shuffled = shuffleWord(word);
            System.out.println(shuffled);

            long startTime = System.currentTimeMillis();
            String userInput = scanner.nextLine();
            long endTime = System.currentTimeMillis();
            long elapsedTime = (endTime - startTime) / 1000;

            if (userInput.equals("그만")) {
                break;
            }

            if (userInput.equals(word) && elapsedTime <= 10) {
                System.out.println("성공!!!");
            } else if (userInput.equals(word)) {
                System.out.println("실패!!! 10초가 넘었습니다.");
            } else {
                System.out.println("실패!!! 정답은 " + word + " 입니다.");
            }
        }

        scanner.close();
    }

    private static String shuffleWord(String word) {
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int j = random.nextInt(letters.length);
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }
}
