public class LinkedList {
    private Node first;
    private Node last;
    private int  size = 0;

    public void add(int n) {
        if (first == null) {
            first = new Node(n);
            last = first;
        } else {
            Node temp = new Node(n);
            last.next = temp;
            temp.prev = last;
            last = temp;
        }
        size++;
    }

    public int get(int idx) {
        return find(idx).n;
    }

    public int size() {
        return size;
    }

    public void remove(int idx) {
        Node target = find(idx);
        if (idx == 0) {
            first = target.next;
        } else if (idx == size - 1) {
            last = target.prev;
        } else {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }
        size--;
    }

    private Node find(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException("size < 0");
        }
        if (size <= idx) {
            throw new IndexOutOfBoundsException("size <= idx");
        }
        Node temp;
        if (size >> 1 >= idx) {
            temp = first;
            while (idx-- > 0) {
                temp = temp.next;
            }
        } else {
            temp = last;
            idx = size - idx - 1;
            while (idx-- > 0) {
                temp = temp.prev;
            }
        }
        return temp;
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
