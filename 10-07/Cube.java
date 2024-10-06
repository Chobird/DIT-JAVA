class Cube {
    private int length;
    private int width;
    private int height;

    public Cube(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getVolume() {
        return length * width * height;
    }

    public void Increase(int length, int width, int height) {
        this.length += length;
        this.width += width;
        this.height += height;
    }

    public boolean IsZero() {
        return getVolume() == 0;
    }

    public static void main(String[] args) {
        Cube cube = new Cube(1, 2, 3);
        System.out.println("큐브의 부피는 " + cube.getVolume());
        cube.Increase(1, 2, 3);
        System.out.println("큐브의 부피는 " + cube.getVolume());
        if (cube.IsZero()) {
            System.out.println("큐브의 부피는 0");
        } else {
            System.out.println("큐브의 부피는 0이 아님");
        }
    }
}
