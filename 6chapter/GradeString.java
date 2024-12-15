import java.util.Scanner;
import java.util.StringTokenizer;

public class GradeString {

    public static void error(String message, String input) {
        System.out.println(message + ": " + input);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력>> ");
            String inputLine = scanner.nextLine();
            if (inputLine.equals("그만"))
                break;
            inputLine = inputLine.toUpperCase();

            StringTokenizer tokens = new StringTokenizer(inputLine, " ");
            int totalCount = tokens.countTokens();
            boolean hasError = false;
            double totalScore = 0;
            while (tokens.hasMoreTokens()) {
                String grade = tokens.nextToken();
                switch (grade) {
                    case "A": totalScore += 100; break;
                    case "B": totalScore += 90; break;
                    case "C": totalScore += 80; break;
                    case "D": totalScore += 70; break;
                    case "F": totalScore += 0; break;
                    default:
                        error("입력 오류", grade);
                        hasError = true;
                        break;
                }
            }
            if (!hasError)
                System.out.println("평균은 " + totalScore / totalCount);
        }
        scanner.close();
    }
}
