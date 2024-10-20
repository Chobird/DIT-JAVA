public class ColorPoint2 extends Point {
    private String color;

    public ColorPoint2() {
        super(0, 0);  // 기본 좌표는 (0, 0)
        this.color = "WHITE";
    }

    public ColorPoint2(int x, int y) {
        super(x, y);  // 좌표 지정 생성자
        this.color = "WHITE";
    }

    public ColorPoint2(int x, int y, String color) {
        super(x, y);  // 좌표 및 색상 지정 생성자
        this.color = color;
    }

    public void set(String color) {
        this.color = color;
    }

    public void set(int x, int y) {
        move(x, y);
    }

    public double getDistance(Point p) {
        int dx = getX() - p.getX();
        int dy = getY() - p.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return color + "색의 (" + getX() + "," + getY() + ")의 점";
    }

    public static void main(String[] args) {
        ColorPoint2 zeroPoint = new ColorPoint2();
        System.out.println(zeroPoint.toString() + "입니다.");

        ColorPoint2 cp = new ColorPoint2(10, 10, "RED");
        cp.set("BLUE");
        cp.set(10, 20);
        System.out.println(cp.toString() + "입니다.");

        ColorPoint2 thresholdPoint = new ColorPoint2(100, 100);
        System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
    }
}
