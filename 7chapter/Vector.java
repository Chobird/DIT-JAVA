import java.util.Scanner;

public class Vector {
    private java.util.Vector<Integer> v = new java.util.Vector<Integer>();

    public Vector() { }

    private void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수 입력(-1이면 입력 끝)>>");
        while (true) {
            int n = scanner.nextInt();
            if (n == -1)
                break;
            v.add(n);
        }
        scanner.close();
    }

    private int findNumber() {
        int least = v.get(0);
        for (int i = 0; i < v.size(); i++) {
            if (least > v.get(i))
                least = v.get(i);
        }
        return least;
    }

    public void run() {
        read();
        int least = findNumber();
        System.out.println("제일 작은 수는 " + least);
    }

    public static void main(String[] args) {
        Vector app = new Vector();
        app.run();
    }
}
