import iterator.RandomIterable;
import myCollection.MyArrayList;
import myCollection.MyLinkedList;
import myCollection.impl.MyArrayListImpl;
import myCollection.impl.MyLinkedListImpl;

public class Main {
    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
        iteratorTest();
    }

    public static void testArrayList() {
        System.out.println("ArrayList:");
        MyArrayList<Integer> arrayList = new MyArrayListImpl<>(2);
        for (int i = 0; i < 8; i++) {
            arrayList.add(i);
            System.out.println("Size - " + arrayList.size() + ", digit - " + i);
        }
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
        arrayList.remove(2);
        arrayList.remove(5);
        System.out.println("Remove digit 2 and 6");
        for (Integer integer : arrayList) {
            System.out.println(integer);
        }
    }

    public static void testLinkedList() {
        System.out.println("LinkedList:");
        MyLinkedList<Integer> linkedList = new MyLinkedListImpl<>();
        for (int i = 0; i < 8; i++) {
            linkedList.insert(i);
            System.out.println("Size - " + linkedList.size() + ", digit - " + i);
        }
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
        linkedList.remove(2);
        linkedList.remove(6);
        System.out.println("Remove digit 2 and 6");
        for (Integer integer : linkedList) {
            System.out.println(integer);
        }
    }

    public static void iteratorTest() {
        System.out.println("Random iterator test.\nDisplay 8 numbers");
        RandomIterable randomIterator = new RandomIterable(8);
        for (Integer integer : randomIterator) {
            System.out.println(integer);
        }
    }


}
