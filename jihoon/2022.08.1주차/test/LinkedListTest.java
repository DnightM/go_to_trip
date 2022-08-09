import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LinkedListTest {
    private final LinkedList                    linkedList     = new LinkedList();
    private final java.util.LinkedList<Integer> javaLinkedList = new java.util.LinkedList<>();

    @Test
    void test() {

        int testCount = 1000;
        for (int i = 0; i < testCount; i++) {
            linkedList.add(i);
            javaLinkedList.add(i);

            equal(linkedList, javaLinkedList);
        }

        int removeCount = 100;

        for (int i = 0; i < removeCount; i++) {
            linkedList.remove(0);
            javaLinkedList.remove(0);

            equal(linkedList, javaLinkedList);
        }

        for (int i = 0; i < removeCount; i++) {
            linkedList.remove(linkedList.size() / 2);
            javaLinkedList.remove(javaLinkedList.size() / 2);

            equal(linkedList, javaLinkedList);
        }

        testCount -= removeCount * 2;

        while (testCount-- > 0) {
            linkedList.remove(linkedList.size() - 1);
            javaLinkedList.remove(javaLinkedList.size() - 1);

            equal(linkedList, javaLinkedList);
        }

        Assertions.assertEquals(linkedList.size(), javaLinkedList.size());
    }

    public void equal(LinkedList l1, java.util.LinkedList<Integer> l2) {
        if (l1.size() != l2.size()) {
            Assertions.fail(String.format("not equals size. l1.size() = %d | l2.size() = %d", l1.size(), l2.size()));
        }

        int size = l1.size();
        for (int i = 0; i < size; i++) {
            if (l1.get(i) != l2.get(i)) {
                Assertions.fail(String.format("not equals value. l1.get(%d) = %d |  l2.get(%d) = %d", i, l1.get(i), i, l2.get(i)));
            }
        }
    }

    @Test
    void time() {
        int testCount = 1000000;

        System.out.println("===============================");
        System.out.println("LinkedList Speed");

        long time = System.currentTimeMillis();
        for (int i = 0; i < testCount; i++) {
            linkedList.add(i);
        }

        int removeCount = 100;

        for (int i = 0; i < removeCount; i++) {
            linkedList.remove(0);
        }

        for (int i = 0; i < removeCount; i++) {
            linkedList.remove(linkedList.size() / 2);
        }

        int t = testCount - removeCount * 2;

        while (t-- > 0) {
            linkedList.remove(linkedList.size() - 1);
        }
        System.out.printf("Time: %,d ms%n", System.currentTimeMillis() - time);

        //////////////////////////////////////////////////////////////////////////

        System.out.println("===============================");
        System.out.println("Java LinkedList Speed");

        time = System.currentTimeMillis();
        for (int i = 0; i < testCount; i++) {
            javaLinkedList.add(i);
        }

        for (int i = 0; i < removeCount; i++) {
            javaLinkedList.remove(0);
        }

        for (int i = 0; i < removeCount; i++) {
            javaLinkedList.remove(javaLinkedList.size() / 2);
        }

        t = testCount - removeCount * 2;

        while (t-- > 0) {
            javaLinkedList.remove(javaLinkedList.size() - 1);
        }
        System.out.printf("Time: %,d ms%n", System.currentTimeMillis() - time);
        System.out.println("===============================");
    }
}
