import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class DequeueTest {
    private final Dequeue                  dequeue   = new Dequeue();
    private final java.util.Deque<Integer> javaDeque = new java.util.LinkedList<>();

    @Test
    void test() {
        Random r = new Random();

        int testCount = 1000;
        for (int i = 0; i < testCount; i++) {
            int n = r.nextInt();
            dequeue.addFirst(n);
            javaDeque.addFirst(n);

            Assertions.assertEquals(dequeue.peekFirst(), javaDeque.peekFirst());
            Assertions.assertEquals(dequeue.peekLast(), javaDeque.peekLast());
            Assertions.assertEquals(dequeue.size(), javaDeque.size());

            int n2 = r.nextInt();
            dequeue.addLast(n2);
            javaDeque.addLast(n2);

            Assertions.assertEquals(dequeue.peekFirst(), javaDeque.peekFirst());
            Assertions.assertEquals(dequeue.peekLast(), javaDeque.peekLast());
            Assertions.assertEquals(dequeue.size(), javaDeque.size());
        }

        while (dequeue.size() > 0) {
            Assertions.assertEquals(dequeue.peekFirst(), javaDeque.peekFirst());
            Assertions.assertEquals(dequeue.peekLast(), javaDeque.peekLast());
            if (dequeue.size() % 2 == 0) {
                Assertions.assertEquals(dequeue.pollFirst(), javaDeque.pollFirst());
            } else {
                Assertions.assertEquals(dequeue.pollLast(), javaDeque.pollLast());
            }
            Assertions.assertEquals(dequeue.size(), javaDeque.size());

            if (testCount-- > 0) {
                int n = r.nextInt();
                dequeue.addFirst(n);
                javaDeque.addFirst(n);

                Assertions.assertEquals(dequeue.peekFirst(), javaDeque.peekFirst());
                Assertions.assertEquals(dequeue.peekLast(), javaDeque.peekLast());
                Assertions.assertEquals(dequeue.size(), javaDeque.size());

                int n2 = r.nextInt();
                dequeue.addLast(n2);
                javaDeque.addLast(n2);

                Assertions.assertEquals(dequeue.peekFirst(), javaDeque.peekFirst());
                Assertions.assertEquals(dequeue.peekLast(), javaDeque.peekLast());
                Assertions.assertEquals(dequeue.size(), javaDeque.size());
            }
        }

        Assertions.assertEquals(dequeue.size(), javaDeque.size());
    }

    @Test
    void time() {
        int testCount = 1000000;

        System.out.println("===============================");
        System.out.println("My Dequeue Speed");

        long time = System.currentTimeMillis();
        for (int i = 0; i < testCount; i++) {
            dequeue.addFirst(i);
            dequeue.addLast(i);
        }

        int t = testCount;

        while (t-- > 0) {
            dequeue.pollFirst();
            dequeue.pollLast();
        }
        System.out.printf("Time: %,d ms%n", System.currentTimeMillis() - time);

        //////////////////////////////////////////////////////////////////////////

        System.out.println("===============================");
        System.out.println("Java Dequeue Speed");

        time = System.currentTimeMillis();
        for (int i = 0; i < testCount; i++) {
            javaDeque.addFirst(i);
            javaDeque.addLast(i);
        }

        t = testCount;

        while (t-- > 0) {
            javaDeque.pollFirst();
            javaDeque.pollLast();
        }
        System.out.printf("Time: %,d ms%n", System.currentTimeMillis() - time);
        System.out.println("===============================");
    }
}