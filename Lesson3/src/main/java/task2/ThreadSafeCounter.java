package task2;

import java.util.concurrent.locks.Lock;

public class ThreadSafeCounter {
    private int count;
    Lock lock;

    public ThreadSafeCounter(Lock lock) {
        this.lock = lock;
        this.count = 0;
    }


    public int incrementAndGet(){
        this.lock.lock();
        count = count + 1;
        int tempVariable = count;
        this.lock.unlock();
        return tempVariable;
    }
}
