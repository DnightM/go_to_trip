public class Queue {
    private Node first;
    private Node last;
    private int  size;

    public Queue() {
        this.size = 0;
    }

    public void add(int n) {
        if (first == null) {
            first = new Node(n);
            last = first;
        } else {
            last.next = new Node(n);
            last = last.next;
        }
        size++;
    }

    public int peek() {
        return first.n;
    }

    public int poll() {
        int n = first.n;
        remove();
        return n;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private void remove() {
        first = first.next;
        size--;
    }

    private static class Node {
        int  n;
        Node next;

        public Node(int n) {
            this.n = n;
        }
    }
}
