public class p167_7 {

    public static void main(String[] args) {
        int[] numbers = new int[10];

        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 9) + 11;
        }

        int total = 0;
        System.out.print("생성된 숫자: ");

        for(int num : numbers) {
            System.out.print(num + " ");
            total += num;
        }

        System.out.println();
        System.out.println("평균값: " + (double) total / numbers.length);
    }

}
