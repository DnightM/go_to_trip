public class Stack {
    private Node node;
    private int  size = 0;

    public void push(int n) {
        if (node == null) {
            node = new Node(n);
        } else {
            Node temp = new Node(n);
            temp.prev = node;
            node = temp;
        }
        size++;
    }

    public int peek() {
        return node.n;
    }

    public int pop() {
        int n = node.n;
        remove();
        return n;
    }

    public int size() {
        return size;
    }

    public void clear() {
        node = null;
        size = 0;
    }

    private void remove(){
        node = node.prev;
        size--;
    }

    private static class Node {
        int  n;
        Node prev;

        public Node(int n) {
            this.n = n;
        }
    }
}
