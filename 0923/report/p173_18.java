import java.util.InputMismatchException;
import java.util.Scanner;

public class p173_18 {
    public static void main(String[] args) {
        int[] studentId = new int[10];
        int[] scores = new int[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("10명 학생의 학번과 점수 입력");
        for (int i = 0; i < 10; i++) {
            while (true) {
                System.out.print((i + 1) + ">>");
                try {
                    studentId[i] = scanner.nextInt();
                    scores[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("경고!! 정수를 입력하세요.");
                    scanner.nextLine();
                }
            }
        }

        while (true) {
            System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");
            int choice = -1;
            while (true) {
                try {
                    choice = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("경고!! 정수를 입력하세요.");
                    scanner.nextLine();
                }
            }

            if (choice == 1) {
                System.out.print("학번>>");
                int id = -1;
                while (true) {
                    try {
                        id = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.nextLine();
                    }
                }

                boolean found = false;
                for (int i = 0; i < 10; i++) {
                    if (studentId[i] == id) {
                        System.out.println(scores[i] + "점");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println(id + "의 학생은 없습니다.");
                }
            } else if (choice == 2) {
                System.out.print("점수>>");
                int score = -1;
                while (true) {
                    try {
                        score = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.nextLine();
                    }
                }

                boolean found = false;
                System.out.print("점수가 " + score + "인 학생은 ");
                for (int i = 0; i < 10; i++) {
                    if (scores[i] == score) {
                        System.out.print(studentId[i] + " ");
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("없습니다.");
                } else {
                    System.out.println("입니다.");
                }
            } else if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 선택입니다.");
            }
        }

        scanner.close();
    }
}
