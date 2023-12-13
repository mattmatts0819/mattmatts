public class SinglyLinkedIntList {

    private Node<Integer> head; // very first node in the list...

    public SinglyLinkedIntList() {
        this.head = null;
    }

    // "static factory method"
    public static SinglyLinkedIntList of(Integer ... nums) {
        SinglyLinkedIntList result = new SinglyLinkedIntList();
        for (Integer x : nums) {
            result.add(x);
        }
        return result;
    }

    // adds toAdd to the end of THIS singly linked int list...
    public void add(Integer toAdd) {

        // first case: the list is empty...
        if (head == null) {
            Node<Integer> nn = new Node<>(toAdd, null);
            head = nn;
            return;
        }
        //
        Node<Integer> curr = head;
        while (curr.next != null) { // "while we haven't reached the end of the chain"
            curr = curr.next;
        }

        // by the time the above while loop is done, we need to create a new node and
        // make curr point to it...
        Node<Integer> nn = new Node<>(toAdd, null);
        curr.next = nn;
    }

    /*public Integer get(int index) {
        Node<Integer> theNodeAtIndex = nodeAt(index);
        // TODO
    }*/

    // TODO: write this method recursively..... (you can use a helper method).
    private Node<Integer> nodeAtIterative(int index) {
        // Way 1: iterative...
        int counter = 0;
        Node<Integer> curr = head;
        while (counter < index) {
            curr = curr.next;
            counter++;
        }
        return curr; // returns a reference to whatever node we stopped at.
    }

    private Node<Integer> nodeAtRecursive(int targetIndex) {
        return nodeAtRecursive(0, targetIndex, head);
    }

    private Node<Integer> nodeAtRecursive(int currIndex, int targetIndex, Node<Integer> currNode) {
        if (currIndex > targetIndex) {
            return null;
        }
        if (currIndex == targetIndex) {
            return currNode;
        }
        return nodeAtRecursive(currIndex + 1, targetIndex, currNode.next);
    }

    public void swap(int i, int j) {
        // TODO:
    }

    @Override
    public String toString() {
        String str = "";
        Node<Integer> curr = head;
        while (curr != null) {
            str = str + curr.data + " -> ";
            curr = curr.next;
        }
        return str + "null";
    }

    public static void main(String[] args) {
        SinglyLinkedIntList myList = SinglyLinkedIntList.of(20, 30, 40, 50, 60);
        System.out.println("here's the list: " + myList);
        int x = 0;
    }



}
