import java.util.Scanner;

public class Grade {

    public static void error(String msg, String input) {
        System.out.println(msg + ":" + input);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력>>");
            String line = scanner.nextLine();
            if(line.equals("그만"))
                break;
            line = line.toUpperCase();
            String[] gradeArray = line.split(" ");
            boolean errorFlag = false;
            double sum = 0;
            for(String s : gradeArray) {
                switch(s) {
                    case "A": sum += 100; break;
                    case "B": sum += 90; break;
                    case "C": sum += 80; break;
                    case "D": sum += 70; break;
                    case "F": sum += 0; break;
                    default:
                        error("입력 오류", s);
                        errorFlag = true;
                        break;
                }
            }
            if(!errorFlag)
                System.out.println("평균은 " + sum / gradeArray.length);
        }
        scanner.close();
    }
}
