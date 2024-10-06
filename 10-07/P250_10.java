import java.util.Scanner;

class DayDiary {
    private String text;

    public DayDiary() {
        this.text = "";
    }

    public void setText(String text) {
        if (text.length() <= 4 && !text.contains(" ")) {
            this.text = text;
        } else {
            System.out.println("빈칸 없이 4글자 이하로 입력하세요.");
        }
    }

    public String getText() {
        return text;
    }
}

class MonthDiary {
    private int year;
    private int month;
    private DayDiary[] days;
    private Scanner scanner;

    public MonthDiary(int year, int month) {
        this.year = year;
        this.month = month;
        this.days = new DayDiary[30];
        for (int i = 0; i < 30; i++) {
            days[i] = new DayDiary();
        }
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("***** " + year + "년 " + month + "월 다이어리 *****");
        while (true) {
            int menu = getMenu();
            if (menu == 1) {
                write();
            } else if (menu == 2) {
                show();
            } else if (menu == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    private int getMenu() {
        System.out.print("기록:1, 보기:2, 종료:3>>");
        return scanner.nextInt();
    }

    private void write() {
        System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>>");
        int day = scanner.nextInt();
        String text = scanner.next();
        if (day < 1 || day > 30) {
            System.out.println("날짜는 1~30 사이로 입력하세요.");
            return;
        }
        days[day - 1].setText(text);
    }

    private void show() {
        for (int i = 0; i < 30; i++) {
            String text = days[i].getText();
            if (!text.equals("")) {
                System.out.print((i + 1) + "일: " + text + "\t");
            } else {
                System.out.print((i + 1) + "일: ...\t");
            }
            if ((i + 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}

public class P250_10{
    public static void main(String[] args) {
        MonthDiary monthDiary = new MonthDiary(2024, 10); // 2024년 10월 다이어리
        monthDiary.run();
    }
}
