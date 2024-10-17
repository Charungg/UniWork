package main;

import java.text.DecimalFormat;

/**
 * A simple profiler to perform some experiments with the two deque implementations.
 *
 * @author Christine Zarges
 * @version 1.0, 07 October 2023
 */
public class DequeProfiler {

    /**
     * The two deques.
     */
    Deque<String> arrayDeque;
    Deque<String> listDeque;

    /**
     * The capacity of the array in the array implementation.
     */
    int capacity = 100; // 100 elements

    /**
     * The number of times a given series of add and remove operations is performed.
     */
    int repetitions = 100000000; // 100 million

    public DequeProfiler(){
    }

    public void run(){
        // Formatting of output
        DecimalFormat numberFormat = new DecimalFormat("#0.000000");

        System.out.println("Array-based deque:");
        long startTime = System.nanoTime();
        arrayDeque = new ArrayDeque<>(capacity);

        // perform add and remove operations on array implementation
        for (int i = 0; i < repetitions; i++) {
            // add until array is full
            for (int j = 0; j < capacity; j++)
                arrayDeque.addFirst("e");
            // remove all elements
            for (int j = 0; j < capacity; j++)
                arrayDeque.removeFirst();
            // add until array is full
            for (int j = 0; j < capacity; j++)
                arrayDeque.addLast("e");
            // remove all elements
            for (int j = 0; j < capacity; j++)
                arrayDeque.removeLast();
        }
        long endTime = System.nanoTime();
        double elapsedTime = (double)(endTime-startTime)/1000000.0;
        System.out.println(numberFormat.format(elapsedTime)+" milliseconds ("
                +numberFormat.format(elapsedTime/1000.0)+" seconds).");

        System.out.println("List-based deque:");
        startTime = System.nanoTime();
        listDeque = new ListDeque<>();

        // perform add and remove operations on list implementation
        for (int i = 0; i < repetitions; i++) {
            // add the same number of elements as for the array implementation
            for (int j = 0; j < capacity; j++)
                listDeque.addFirst("e");
            // remove all elements
            for (int j = 0; j < capacity; j++)
                listDeque.removeFirst();

            // add the same number of elements as for the array implementation
            for (int j = 0; j < capacity; j++)
                listDeque.addLast("e");
            // remove all elements
            for (int j = 0; j < capacity; j++)
                listDeque.removeLast();
        }
        endTime = System.nanoTime();
        elapsedTime = (double)(endTime-startTime)/1000000.0;
        System.out.println(numberFormat.format(elapsedTime)+" milliseconds ("
                +numberFormat.format(elapsedTime/1000.0)+" seconds).");
    }

    public static void main(String[] args){
        DequeProfiler profiler = new DequeProfiler();
        profiler.run();
    }
}
