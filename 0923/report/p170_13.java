import java.util.Scanner;

public class p170_13 {

    public static void main(String[] args) {
        String[][] courseAndGrade = {
                {"C", "A"},
                {"C++", "B+"},
                {"Python", "B"},
                {"Java", "A+"},
                {"HTML5", "D"}
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("과목>>");
            String searchCourse = scanner.next();
            if (searchCourse.equals("그만")) {
                break;
            }

            boolean found = false;
            for (int i = 0; i < courseAndGrade.length; i++) {
                if (courseAndGrade[i][0].equals(searchCourse)) {
                    System.out.println(searchCourse + " 학점은 " + courseAndGrade[i][1]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(searchCourse + "는 없는 과목입니다.");
            }
        }

        scanner.close();
    }
}
