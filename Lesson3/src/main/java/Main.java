import linkedlists.LinkedNodes;
import linkedlists.Node;
import task1.PingPongWriter;
import task2.ThreadSafeCounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Task 1");
        Object monitor = new Object();
        PingPongWriter pingPongWriter = new PingPongWriter(5);
        Thread thread1 = new Thread(() -> {
            pingPongWriter.displayTheLetter("Ping", "Pong", monitor);
        });
        Thread thread2 = new Thread(() -> {
            pingPongWriter.displayTheLetter("Pong", "Ping", monitor);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("\nTask 2");
        Lock lock = new ReentrantLock();
        ThreadSafeCounter threadSafeCounter = new ThreadSafeCounter(lock);
        for (int i = 0; i < 1; i++) {
            new Thread(()->{
                for (int j = 0; j < 20; j++) {
                    System.out.println(threadSafeCounter.incrementAndGet());
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("\nCyclic nodes");
        LinkedNodes linkedNodes = new LinkedNodes();
        Node<Integer> node = linkedNodes.prepareNodes();
        System.out.println("List is looped(assert false): " + linkedNodes.isLoopedNodes(node));
        node = linkedNodes.prepareNodes();
        linkedNodes.loopNodes(node);
        System.out.println("List is looped(assert false): " + linkedNodes.isLoopedNodes(node));
        System.out.println("\nReverse LinkedList");
        Node justList = linkedNodes.prepareNodes();
        linkedNodes.displayList(justList);
        System.out.println("Reversing");
        justList = linkedNodes.reverseList(justList);
        linkedNodes.displayList(justList);
    }
}
