import java.util.Scanner;

class Dictionary {
    private static String[] kor = { "사랑", "아기", "돈", "미래", "희망" };
    private static String[] eng = { "love", "baby", "money", "future", "hope" };

    public static String kor2Eng(String word) {
        for (int i = 0; i < kor.length; i++) {
            if (kor[i].equals(word)) {
                return eng[i];
            }
        }
        return null;
    }
}

public class DicApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램입니다.");

        while (true) {
            System.out.print("한글 단어?");
            String word = scanner.next();

            if (word.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String result = Dictionary.kor2Eng(word);
            if (result != null) {
                System.out.println(word + "은 " + result);
            } else {
                System.out.println(word + "는 저의 사전에 없습니다.");
            }
        }
        scanner.close();
    }
}
