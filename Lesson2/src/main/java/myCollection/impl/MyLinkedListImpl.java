package myCollection.impl;

import myCollection.MyLinkedList;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.Consumer;

public class MyLinkedListImpl<E> implements MyLinkedList<E> {

    protected int size;
    protected Node<E> firstElement;

    @Override
    public void insertFirst(E value) {
        firstElement = new Node<>(value, firstElement);
        size++;
    }

    @Override
    public void insert(E value) {
        if (firstElement == null){
            insertFirst(value);
            return;
        }
        Node<E> current = firstElement;
        while (current.next != null){
            current = current.next;
        }
        current.next = new Node<>(value, null);
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> removedNode = firstElement;
        firstElement = firstElement.next;
        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = firstElement;
        Node<E> previous = null;
        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == firstElement) {
            firstElement = firstElement.next;
        } else {
            previous.next = current.next;
        }
        current.next = null;
        size--;
        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public E getFirst() {
        return Optional.ofNullable(firstElement)
                .map(node -> node.item)
                .orElse(null);
    }

    @Override
    public Node<E> getFirstNode() {
        return firstElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedListIterator(this);
    }

    class MyLinkedListIterator implements Iterator<E> {
        private Node<E> current;

        public MyLinkedListIterator(MyLinkedListImpl<E> list) {
            this.current = list.getFirstNode();

        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E data = current.item;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }
}

