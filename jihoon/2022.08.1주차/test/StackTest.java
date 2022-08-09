import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class StackTest {
    private final Stack                    stack     = new Stack();
    private final java.util.Stack<Integer> javaStack = new java.util.Stack<>();

    @Test
    void test() {
        Random r = new Random();

        int testCount = 1000;
        for (int i = 0; i < testCount; i++) {
            int n = r.nextInt();
            stack.push(n);
            javaStack.push(n);

            Assertions.assertEquals(stack.peek(), javaStack.peek());
            Assertions.assertEquals(stack.size(), javaStack.size());
        }

        while (stack.size() > 0) {
            Assertions.assertEquals(stack.peek(), javaStack.peek());
            Assertions.assertEquals(stack.pop(), javaStack.pop());
            Assertions.assertEquals(stack.size(), javaStack.size());

            if (testCount-- > 0) {
                int n = r.nextInt();
                stack.push(n);
                javaStack.push(n);

                Assertions.assertEquals(stack.size(), javaStack.size());
                Assertions.assertEquals(stack.peek(), javaStack.peek());
            }
        }

        Assertions.assertEquals(stack.size(), javaStack.size());
    }

    @Test
    void time() {
        int testCount = 10000000;

        System.out.println("===============================");
        System.out.println("My Stack Speed");

        long time = System.currentTimeMillis();
        for (int i = 0; i < testCount; i++) {
            stack.push(i);
        }

        int t = testCount;

        while (t-- > 0) {
            stack.pop();
        }
        System.out.printf("Time: %,d ms%n", System.currentTimeMillis() - time);

        //////////////////////////////////////////////////////////////////////////

        System.out.println("===============================");
        System.out.println("Java Stack Speed");

        time = System.currentTimeMillis();
        for (int i = 0; i < testCount; i++) {
            javaStack.push(i);
        }

        t = testCount;

        while (t-- > 0) {
            javaStack.pop();
        }
        System.out.printf("Time: %,d ms%n", System.currentTimeMillis() - time);
        System.out.println("===============================");
    }
}