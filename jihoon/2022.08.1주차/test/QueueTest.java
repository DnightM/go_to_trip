import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class QueueTest {
    private final Queue                    queue     = new Queue();
    private final java.util.Queue<Integer> javaQueue = new java.util.LinkedList<>();

    @Test
    void test() {
        Random r = new Random();

        int testCount = 1000;
        for (int i = 0; i < testCount; i++) {
            int n = r.nextInt();
            queue.add(n);
            javaQueue.add(n);

            Assertions.assertEquals(queue.peek(), javaQueue.peek());
            Assertions.assertEquals(queue.size(), javaQueue.size());
        }

        while (queue.size() > 0) {
            Assertions.assertEquals(queue.peek(), javaQueue.peek());
            Assertions.assertEquals(queue.poll(), javaQueue.poll());
            Assertions.assertEquals(queue.size(), javaQueue.size());

            if (testCount-- > 0) {
                int n = r.nextInt();
                queue.add(n);
                javaQueue.add(n);

                Assertions.assertEquals(queue.size(), javaQueue.size());
                Assertions.assertEquals(queue.peek(), javaQueue.peek());
            }
        }

        Assertions.assertEquals(queue.size(), javaQueue.size());
    }

    @Test
    void time() {
        int testCount = 10000000;

        System.out.println("===============================");
        System.out.println("My Queue Speed");

        long time = System.currentTimeMillis();
        for (int i = 0; i < testCount; i++) {
            queue.add(i);
        }

        int t = testCount;

        while (t-- > 0) {
            queue.poll();
        }
        System.out.printf("Time: %,d ms%n", System.currentTimeMillis() - time);

        //////////////////////////////////////////////////////////////////////////

        System.out.println("===============================");
        System.out.println("Java Queue Speed");

        time = System.currentTimeMillis();
        for (int i = 0; i < testCount; i++) {
            javaQueue.add(i);
        }

        t = testCount;

        while (t-- > 0) {
            javaQueue.poll();
        }
        System.out.printf("Time: %,d ms%n", System.currentTimeMillis() - time);
        System.out.println("===============================");
    }
}