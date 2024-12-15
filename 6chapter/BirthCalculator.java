import java.util.Calendar;
import java.util.Scanner;

public class BirthCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calendar today = Calendar.getInstance();
        System.out.println("오늘은 " + today.get(Calendar.YEAR) + "년 " + (today.get(Calendar.MONTH) + 1) + "월 " + today.get(Calendar.DAY_OF_MONTH) + "일");

        while (true) {
            System.out.print("생일 입력(년 월 일)>> ");
            String input = scanner.nextLine();
            if (input.equals("그만"))
                break;

            String[] birthDate = input.split(" ");
            int birthYear = Integer.parseInt(birthDate[0]);
            int birthMonth = Integer.parseInt(birthDate[1]) - 1;
            int birthDay = Integer.parseInt(birthDate[2]);

            Calendar birth = Calendar.getInstance();
            birth.set(birthYear, birthMonth, birthDay);

            long diffInMillis = today.getTimeInMillis() - birth.getTimeInMillis();
            int daysLived = (int) (diffInMillis / (1000 * 60 * 60 * 24)) + 1;

            if (daysLived > 0) {
                System.out.println("오늘까지 " + daysLived + "일 살아왔습니다.");
            } else {
                System.out.println(-daysLived + "일 더 살아야 생일이 됩니다.");
            }
        }
        scanner.close();
    }
}
