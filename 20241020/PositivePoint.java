public class PositivePoint extends Point {

    public PositivePoint() {
        super(0, 0);  // 기본 좌표 (0,0)으로 설정
    }

    public PositivePoint(int x, int y) {
        super(x >= 0 ? x : 0, y >= 0 ? y : 0);  // 음수일 경우 0으로 설정
    }

    @Override
    public void move(int x, int y) {
        if (x >= 0 && y >= 0) {
            super.move(x, y);  // 양수일 때만 이동
        }
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")의 점";
    }

    public static void main(String[] args) {
        PositivePoint p = new PositivePoint(10, 10);
        p.move(5, 5);
        System.out.println(p.toString() + "입니다.");

        p.move(2, -2);  // 음수 좌표는 무시됨
        System.out.println(p.toString() + "입니다.");

        PositivePoint q = new PositivePoint(-10, -10);  // 음수는 기본 좌표 (0,0)로 초기화됨
        System.out.println(q.toString() + "입니다.");
    }
}