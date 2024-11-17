import java.util.*;

public class P10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("문자열들을 입력하세요>>");
            String input = scanner.nextLine();
            if (input.equals("그만")) {
                break;
            }

            String[] words = input.split(" ");
            ArrayList<String> uniqueWords = new ArrayList<>();

            for (String word : words) {
                if (!uniqueWords.contains(word.toLowerCase())) {
                    uniqueWords.add(word.toLowerCase());
                }
            }

            for (String word : uniqueWords) {
                System.out.print(word + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
