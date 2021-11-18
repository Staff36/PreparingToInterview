package iterator;

import java.util.Iterator;
import java.util.Random;

public class RandomIterator implements Iterator<Integer> {

    private int size;
    private int index;

    public RandomIterator(int size) {
        this.index = 0;
        this.size = size;
    }

    @Override
    public boolean hasNext() {
        return index >= 0 && index < size;
    }

    @Override
    public Integer next() {
        index++;
        return new Random().nextInt();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}