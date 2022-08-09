public class Dequeue {
    private Node first;
    private Node last;
    private int  size = 0;


    public void addFirst(int n) {
        if (first == null) {
            first = new Node(n);
            last = first;
        } else {
            Node temp = new Node(n);
            temp.next = first;
            first.prev = temp;
            first = temp;
        }
        size++;
    }

    public void addLast(int n) {
        if (last == null) {
            last = new Node(n);
            first = last;
        } else {
            Node temp = new Node(n);
            temp.prev = last;
            last.next = temp;
            last = temp;
        }
        size++;
    }

    public int peekFirst() {
        return first.n;
    }

    public int peekLast() {
        return last.n;
    }

    public int pollFirst() {
        int n = first.n;
        removeFirst();
        return n;
    }

    public int pollLast() {
        int n = last.n;
        removeLast();
        return n;
    }

    public void removeFirst() {
        first = first.next;
        size--;
    }

    public void removeLast() {
        last = last.prev;
        size--;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private static class Node {
        int  n;
        Node next;
        Node prev;

        public Node(int n) {
            this.n = n;
        }
    }
}
