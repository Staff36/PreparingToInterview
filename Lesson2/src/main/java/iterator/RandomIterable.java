package iterator;

import java.util.Iterator;
import java.util.Random;

public class RandomIterable implements Iterable<Integer>{

     private int size;

    public RandomIterable(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RandomIterator(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
