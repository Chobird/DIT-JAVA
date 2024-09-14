import java.util.Scanner;

public class 실습4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("여행지>>");
        String travel = scanner.nextLine();

        System.out.print("인원수>>");
        int people = scanner.nextInt();

        System.out.print("숙박일>>");
        int home = scanner.nextInt();

        System.out.print("1인당 항공료>>");
        int air = scanner.nextInt();

        System.out.print("1방 숙박비>>");
        int room = scanner.nextInt();

        int manyroom = (people + 1) / 2;

        int totalair = people*air;

        int totalroom = manyroom * room *home;
        int cost = totalair+totalroom;

        System.out.println(people +"명의" + travel +" "+ home + "박 "+(home + 1)+ "일 여행에는 방이" + room + "개 필요하며 경비는 " + cost+"원입니다");
    }
}
