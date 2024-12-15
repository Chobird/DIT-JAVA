import java.util.*;

public class Calendar {
    public static void makeCalendar(int year) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(java.util.Calendar.YEAR, year);

        for (int month = 0; month < 12; month++) {
            System.out.println("\n" + year + "년 " + (month + 1) + "월 ");
            System.out.println("일\t월\t화\t수\t목\t금\t토");

            calendar.set(java.util.Calendar.MONTH, month);
            calendar.set(java.util.Calendar.DAY_OF_MONTH, 1);

            int dayOfWeek = calendar.get(java.util.Calendar.DAY_OF_WEEK);

            for (int i = 0; i < dayOfWeek - 1; i++)
                System.out.print("\t");

            int daysInMonth = calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

            for (int day = 1; day <= daysInMonth; day++) {
                System.out.print(day + "\t");
                if (calendar.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.SATURDAY)
                    System.out.println();
                calendar.set(java.util.Calendar.DAY_OF_MONTH, day + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("년도 입력(-1이면 종료)>> ");
            int year = scanner.nextInt();
            if (year == -1)
                break;
            makeCalendar(year);
        }
        scanner.close();
    }
}
