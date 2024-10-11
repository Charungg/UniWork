package main;

import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Deque<E>{

    private int head;
    private int tail;
    private int size;
    private E[] data;


    public ArrayDeque(int capacity) {
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        data = (E[]) new Object[capacity];
    }


    @Override
    public void addFirst(E element){

        if (size == data.length){
            throw new IllegalStateException("Array is full");
        }

        head--;
        if (head < 0){
            head = data.length - 1;
        }

        data[head] = element;
        size++;
    }

    @Override
    public void addLast(E element){
        if (size == data.length){
            throw new IllegalStateException("Array is full");
        }

//        else if(tail == data.length){
//            tail = (tail + 1) % data.length;
//        }
        else if (tail == data.length - 1){
            tail = 0;
        }

        data[tail] = element;
        size++;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        E removedElement;

        if (size == 0){
            throw new NoSuchElementException();
        }

        removedElement = data[head];
        head = (head + 1) & data.length;
        size--;
        return removedElement;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        E removedElement;

        if (size == 0){
            throw new NoSuchElementException();
        }

        removedElement = data[tail];
        tail = (tail + 1) & data.length;
        size--;
        return removedElement;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        return data[head];
    }

    @Override
    public E getLast() throws NoSuchElementException {
        return data[tail];
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int getSize() {
        return size;
    }
}
