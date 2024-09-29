import java.util.Scanner;
import java.util.Random;

public class p169_12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String boyMiddleList[] = {"기","민","용","종","현","진","재","승","소","상","지"};
        String boyLastList[] = {"태","진","광","혁","우","철","빈","준","구","호","석"};
        String girlMiddleList[] = {"은","원","경","수","현","예","여","송","서","채","하"};
        String girlLastList[] = {"진","연","경","서","리","숙","미","원","린","희","수"};

        System.out.println("작명 프로그램이 실행됩니다.");

        while (true) {
            System.out.print("남/여 선택>>");
            String gender = scanner.next();

            if (gender.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (!(gender.equals("남") || gender.equals("여"))) {
                System.out.println("남/여/그만 중에서 입력하세요!");
                continue;
            }

            System.out.print("성 입력>>");
            String lastName = scanner.next();

            String middleName = "";
            String finalName = "";

            if (gender.equals("남")) {
                middleName = boyMiddleList[random.nextInt(boyMiddleList.length)];
                finalName = boyLastList[random.nextInt(boyLastList.length)];
            } else if (gender.equals("여")) {
                middleName = girlMiddleList[random.nextInt(girlMiddleList.length)];
                finalName = girlLastList[random.nextInt(girlLastList.length)];
            }

            System.out.println("추천 이름: " + lastName + middleName + finalName);
        }

        scanner.close();
    }
}
