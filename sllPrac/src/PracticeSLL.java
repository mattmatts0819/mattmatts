import java.util.HashSet;
import java.util.Set;

public class PracticeSLL {
    private Node<Integer> head;
    public PracticeSLL(){this.head = null;}

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

    // Q0:
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }

    //Q1:
    public Set<Integer> toSet(){
        Set<Integer> resultSet = new HashSet<>(); // instantiate empty set
        Node<Integer> currHead = head;
        while(head.next != null){
            resultSet.add(head.data);
            head = head.next;
        }
        return resultSet;
    }

    //Q2:
    public Integer findMax(){
        return findMax(head, head.data);
    }
    public Integer findMax(Node<Integer> currNode, Integer currMax){
        if (currNode == null){
            return currMax;
        }
        if (currMax.compareTo(currNode.data) > 0){
            currMax = currNode.data;
        }
        return findMax(currNode.next, currMax);
    }

    //Q3:
    public boolean allSame(){
        return allSame(head);
    }
    public boolean allSame(Node<Integer> currNode){
        if (currNode == null){
            return true;
        }
        if (!currNode.data.equals(currNode.next.data)){
            return false;
        }
        return allSame(currNode.next);
    }

    //Q4:
    public void appendAll(SinglyLinkedIntList a){
        Node<Integer> currHead = head;
        while(currHead.next != null){
            a.add(currHead.data);
        }

    }
}
