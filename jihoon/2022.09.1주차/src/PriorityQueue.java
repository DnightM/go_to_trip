public class PriorityQueue {
    private int[] buffer;
    private int   bufferSize;
    private int   size = 0;

    public PriorityQueue() {
        this.bufferSize = 1000001;
        this.buffer = new int[bufferSize];
    }

    public PriorityQueue(int bufferSize) {
        this.bufferSize = bufferSize;
        this.buffer = new int[bufferSize];
    }

    public void add(int n) {
        size++;
        if (size >= bufferSize) {
            int[] temp = new int[bufferSize = bufferSize << 1];
            System.arraycopy(buffer, 0, temp, 0, size);
            buffer = temp;
        }
        int t = size;
        buffer[t] = n;
        while (t > 1) {
            if (buffer[t] < buffer[t >> 1]) {
                swap(t, t = t >> 1);
            } else {
                break;
            }
        }
    }

    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int t = buffer[1];
        int idx = 1;
        buffer[idx] = buffer[size];
        while (idx << 1 < size) {
            if (buffer[idx] > buffer[idx << 1] || buffer[idx] > buffer[(idx << 1) + 1]) {
                if (buffer[idx << 1] > buffer[(idx << 1) + 1]) {
                    swap(idx, idx = (idx << 1) + 1);
                } else {
                    swap(idx, idx = idx << 1);
                }
            } else {
                break;
            }
        }

        size--;
        return t;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return buffer[1];
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }

    private void swap(int idx1, int idx2) {
        int temp = buffer[idx1];
        buffer[idx1] = buffer[idx2];
        buffer[idx2] = temp;
    }

    public void printTree() {
        int height = getTreeHeight(size);
        System.out.println();
        System.out.println("==================================");
        int w = 1;
        int idx = 1;
        int d = 1;
        while (idx <= size) {
            String blank = getBlank(height - d);
            for (int i = 0; i < w && idx <= size; i++) {
                System.out.print(blank);
                System.out.printf("%2s", buffer[idx++]);
            }

            System.out.println();
            w = w << 1;
            d++;
        }
    }

    private String getBlank(int height) {
        StringBuilder sb = new StringBuilder();
        int t = height * 2;
        for (int i = 0; i < t; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    private int getTreeHeight(int size) {
        int sum = 1;
        int height = 0;
        while (sum <= size) {
            sum = sum << 1;
            height++;
        }
        return height;
    }
}
