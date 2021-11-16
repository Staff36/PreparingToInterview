package myCollection;

public interface MyArrayList<T> extends Iterable<T>{
    T get(int index);

    void add(T t);

    T remove(int index);

    int size();

    boolean isEmpty();
}
