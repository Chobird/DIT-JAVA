import java.util.Random;
import java.util.Scanner;

public class TimeWordGame {
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
            double elapsedSeconds = (endTime - startTime) / 1000.0;

            if (userInput.equals("그만")) {
                break;
            }

            if (userInput.equals(word)) {
                if (elapsedSeconds <= 10) {
                    System.out.printf("성공!!! %.3f초 경과\n", elapsedSeconds);
                } else {
                    System.out.printf("실패!!! 10초 초과. %.3f초 경과\n", elapsedSeconds);
                }
            } else {
                System.out.printf("실패!!! 정답은 %s 입니다. %.3f초 경과\n", word, elapsedSeconds);
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
