package main;

import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Deque<E> {

    private int head;
    private int tail;
    private int size;
    private E[] data;

    public ArrayDeque(int capacity){
        head = 0;
        tail = 0;
        size = 0;
        data = (E[]) new Object[capacity];
    }

    @Override
    public void addFirst(E element) throws IllegalStateException {
        if (size == data.length){
            throw new IllegalStateException("Array is full");
        }

        else if(getSize() == 0){
            data[head] = element;
            size++;
            tail = (tail + 1) % data.length;
        }

        else{
            head = (head - 1 + data.length) % data.length;
            data[head] = element;
            size++;
        }
    }

    @Override
    public void addLast(E element) throws IllegalStateException {
        if (size == data.length){
            throw new IllegalStateException("Array is full");
        }

        data[tail] = element;
        size++;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        E removedNode;

        if (isEmpty()){
            throw new NoSuchElementException("Array is empty");
        }

        removedNode = data[head];
        size--;
        head = (head + 1) % data.length;
        tail = (head + size) % data.length;

        return removedNode;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException("Array is empty");
        }

        tail = (tail - 1 + data.length) % data.length;
        size--;
        return data[tail];
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException("Array is empty");
        }

        return data[head];
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if (isEmpty()){
            throw new NoSuchElementException("Array is empty");
        }

        return data[(tail - 1 + data.length) % data.length];
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int getSize() {
        return (size);
    }
}
