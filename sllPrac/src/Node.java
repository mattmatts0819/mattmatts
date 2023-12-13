public class Node<A> {
    public A data;
    public Node<A> next;

    public Node(A data, Node<A> next) {
        this.data = data;
        this.next = next;
    }
}
