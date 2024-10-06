class VArray {
    private int[] arr;
    private int size;

    public VArray(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    public int capacity() {
        return arr.length;
    }

    public int size() {
        return size;
    }

    public void add(int value) {
        if (size >= arr.length) {
            expandCapacity();
        }
        arr[size++] = value;
    }

    public void insert(int index, int value) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException("인덱스 초과");
        }
        if (size >= arr.length) {
            expandCapacity();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    public void remove(int index) {
        if (index >= size) {
            System.out.println("인덱스가 범위를 벗어났습니다.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    private void expandCapacity() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class VArrayEx {
    public static void main(String[] args) {
        VArray v = new VArray(5);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());

        for (int i = 0; i < 7; i++) {
            v.add(i);
        }
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        v.insert(3, 100);
        v.insert(5, 200);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        v.remove(10);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        for (int i = 50; i < 55; i++) {
            v.add(i);
        }
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();
    }
}
