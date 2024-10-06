class Average {
    private int[] numbers = new int[10];
    private int count = 0;

    public void put(int num) {
        if (count < 10) {
            numbers[count] = num;
            count++;
        } else {
            System.out.println("더 이상 저장할 수 없습니다. 최대 10개까지만 저장할 수 있습니다.");
        }
    }

    public void showAll() {
        System.out.println("***** 저장된 데이터 모두 출력 *****");
        for (int i = 0; i < count; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public double getAvg() {
        if (count == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += numbers[i];
        }
        return (double) sum / count;
    }

    public static void main(String[] args) {
        Average avg = new Average();
        avg.put(10);
        avg.put(15);
        avg.put(100);
        avg.showAll();

        System.out.print("평균은 " + avg.getAvg());
    }
}
