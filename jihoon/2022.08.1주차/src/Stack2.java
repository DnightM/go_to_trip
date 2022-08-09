package study.A8_1;

public class Stack2 {
    private int[] arr;
    private int   size;
    private int   bufferSize;

    public Stack2(int size) {
        this.arr = new int[size];
        this.bufferSize = size;
        this.size = 0;
    }

    public void push(int n) {
        if (bufferSize == size) {
            bufferSize = bufferSize << 1;
            int[] temp = new int[bufferSize];
            System.arraycopy(arr, 0, temp, 0, size);
            arr = temp;
        }
        arr[size++] = n;
    }

    public int peek() {
        return arr[size - 1];
    }

    public int pop() {
        return arr[--size];
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }
}
