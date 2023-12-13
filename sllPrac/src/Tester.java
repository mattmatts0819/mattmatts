public class Tester {
    public static void main(String[] args) {
        SinglyLinkedIntList a = SinglyLinkedIntList . of (10 , 10);
        System . out . println ( a.allSame()); // true
        a = SinglyLinkedIntList . of (10 , 20 , 10);
        System . out . println ( a.allSame()); // false
        a = SinglyLinkedIntList . of (10 , 10 , 10 , 10);
        System . out . println ( a.allSame()); // true
        a = SinglyLinkedIntList . of ();
        System . out . println ( a.allSame()); // true
        a = SinglyLinkedIntList . of (54);
        System . out . println ( a.allSame()); // true
        a = SinglyLinkedIntList . of (10 , 10 , 20);
        System . out . println ( a.allSame()); // false
        a = SinglyLinkedIntList . of (20 , 5 , 5 , 5);
        System . out . println ( a.allSame()); // false
        a = SinglyLinkedIntList . of (5 , 5 , 2 , 5 , 5);
        System . out . println ( a.allSame()); // false
    }
}
