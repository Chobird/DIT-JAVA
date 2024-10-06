import java.util.Scanner;

class Seat {
    private String[] seats;

    public Seat() {
        seats = new String[10];
        for (int i = 0; i < seats.length; i++) {
            seats[i] = "---";
        }
    }

    public void reserve(String name, int seatNumber) {
        if (seats[seatNumber - 1].equals("---")) {
            seats[seatNumber - 1] = name;
        } else {
            System.out.println("이미 예약된 좌석입니다.");
        }
    }

    public void cancel(String name) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].equals(name)) {
                seats[i] = "---";
                return;
            }
        }
        System.out.println("해당 이름의 예약자가 없습니다.");
    }

    public void showSeats() {
        for (int i = 0; i < seats.length; i++) {
            System.out.print(seats[i] + " ");
        }
        System.out.println();
    }
}

class ConcertSystem {
    private Seat sSeat;
    private Seat aSeat;
    private Seat bSeat;
    private Scanner scanner;

    public ConcertSystem() {
        sSeat = new Seat();
        aSeat = new Seat();
        bSeat = new Seat();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("명품콘서트홀 예약 시스템입니다.");
        while (true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    reserve();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    cancel();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }
        }
    }

    private void reserve() {
        System.out.print("좌석구분 S(1), A(2), B(3)>>");
        int seatType = scanner.nextInt();
        System.out.print("이름>>");
        String name = scanner.next();
        System.out.print("번호>>");
        int seatNumber = scanner.nextInt();

        switch (seatType) {
            case 1:
                sSeat.reserve(name, seatNumber);
                break;
            case 2:
                aSeat.reserve(name, seatNumber);
                break;
            case 3:
                bSeat.reserve(name, seatNumber);
                break;
            default:
                System.out.println("잘못된 좌석구분입니다.");
        }
    }

    private void showAll() {
        System.out.print("S>> ");
        sSeat.showSeats();
        System.out.print("A>> ");
        aSeat.showSeats();
        System.out.print("B>> ");
        bSeat.showSeats();
    }

    private void cancel() {
        System.out.print("좌석구분 S(1), A(2), B(3)>>");
        int seatType = scanner.nextInt();
        System.out.print("이름>>");
        String name = scanner.next();

        switch (seatType) {
            case 1:
                sSeat.cancel(name);
                break;
            case 2:
                aSeat.cancel(name);
                break;
            case 3:
                bSeat.cancel(name);
                break;
            default:
                System.out.println("잘못된 좌석구분입니다.");
        }
    }
}

public class Concert {
    public static void main(String[] args) {
        ConcertSystem system = new ConcertSystem();
        system.run();
    }
}
