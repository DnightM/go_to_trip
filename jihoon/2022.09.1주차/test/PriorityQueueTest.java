import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class PriorityQueueTest {
    Random r = new Random();

    @Test
    public void precision() {
        PriorityQueue queue = new PriorityQueue();
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();

        for (int c = 0; c < 10; c++) {
            int roof = 1000;

            for (int i = 0; i < roof; i++) {
                int t = r.nextInt();
                queue.add(t);
                pq.add(t);
            }

            while (queue.size() > 0) {
                Assertions.assertEquals(queue.size(), pq.size());
                Assertions.assertEquals(queue.peek(), pq.peek());
                Assertions.assertEquals(queue.poll(), pq.poll());
            }

            // size 0일때
            Assertions.assertEquals(queue.peek(), pq.peek());
            Assertions.assertEquals(queue.poll(), pq.poll());
            Assertions.assertEquals(queue.size(), pq.size());

            queue.clear();
            pq.clear();
        }
    }

    int   size  = 5000000;
    int[] array = new int[size];

    {
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt();
        }
    }

    @Test
    public void javaQueueTime() {
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
        for (int data : array) {
            pq.add(data);
        }
        while (pq.size() > 0) {
            pq.poll();
        }
        pq.clear();
    }

    @Test
    public void madeQueueTime() {
        PriorityQueue queue = new PriorityQueue(size + 1);
        for (int data : array) {
            queue.add(data);
        }
        while (queue.size() > 0) {
            queue.poll();
        }
        queue.clear();
    }
}