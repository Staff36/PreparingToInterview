package myCollection.impl;

import myCollection.MyArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayListImpl<T> implements MyArrayList<T> {

    protected T[] data;
    protected int size;
    protected static final int DEFAULT_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public MyArrayListImpl(int capacity) {
        data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public MyArrayListImpl(){
        this(DEFAULT_CAPACITY);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public void add(T t) {
        if (data.length >= size) {
            data = Arrays.copyOf(data, calculateNewLength());
        }
        data[size++] = t;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedValue = data[index];
        if (size - index - 1 >= 0) {
            System.arraycopy(data, index + 1, data, index, size - index - 1);
        }
        data[--size] = null;
        return removedValue;
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            String errMsg = String.format("Incorrect index:%d max value is %d", index, size - 1);
            throw new IndexOutOfBoundsException(errMsg);
        }
    }

    private int calculateNewLength() {
        return size == 0 ? 1 : size * 2;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator<>(this);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static int getDefaultCapacity() {
        return DEFAULT_CAPACITY;
    }

    class MyArrayListIterator<E> implements Iterator<E> {
        protected E[] data;

        protected int index;

        public MyArrayListIterator(MyArrayListImpl<E> list) {
            this.data = list.data;
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < size && index >= 0;
        }

        @Override
        public E next() {
            return data[index++];
        }
        @Override
        public void remove() {
            MyArrayListImpl.this.remove(index);
        }

    }
}
