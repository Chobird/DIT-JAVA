import java.util.Scanner;
import java.util.Arrays;

public class SortedArray extends BaseArray {

    public SortedArray(int size) {
        super(size);
    }

    @Override
    public void add(int n) {
        if (nextIndex == array.length)
            return;
        array[nextIndex] = n;
        nextIndex++;
        Arrays.sort(array, 0, nextIndex);
    }

    public static void main(String[] args) {
        SortedArray sArray = new SortedArray(10);
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>");
        for (int i = 0; i < sArray.length(); i++) {
            int n = scanner.nextInt();
            sArray.add(n);
        }
        sArray.print();
        scanner.close();
    }
}
