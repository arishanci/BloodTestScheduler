/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestschedule;

/**
 *
 * @author Arisha Mirza
 * 18/03/2025
 * PQRequestList.java Ver 1.0
 */

import java.util.Comparator; //import comparator to determine priority

@SuppressWarnings("unchecked")
public class PQRequestList<T> implements PQInterface<T> {
    private static final int FIXED_CAPACITY = 10;
    private T[] data = (T[]) new Object[FIXED_CAPACITY]; //array to store elements (10)
    private int count = 0; //0 elements in array
    private Comparator<T> comp; //comparator to determine PQ
    
    public PQRequestList(Comparator<T> comp) { //constructor
        this.comp = comp;
    }
    
    @Override
    public void add(T element) {
        if (count == FIXED_CAPACITY) {
           //exception handling for full queue
            throw new RuntimeException("Priority queue is full.");
        }
        // new elements to go end
        data[count++] = element;
    }
    
    // method to scan for best element
    private int findBestIndex() {
        if (count == 0) return -1;  // No elements in array
        int bestIndex = 0;
        // find best element
        for (int i = 1; i < count; i++) {
            if (comp.compare(data[i], data[bestIndex]) < 0) {
                bestIndex = i;
            }
        }
        return bestIndex;
    }
    
    @Override
    public T remove() {
        if (count == 0) return null;  // if theres nothing to remove then null
        int bestIndex = findBestIndex();
        T best = data[bestIndex];
        // once best element found and removed, all elements are moved up the queue
        for (int i = bestIndex; i < count - 1; i++) {
            data[i] = data[i+1];
        }
        data[--count] = null; //decrease size and return next element in PQ
        return best;
    }
    
    @Override
    public T peek() {
        int bestIndex = findBestIndex();
        return (bestIndex == -1) ? null : data[bestIndex];
    }
    
    @Override
    public boolean isEmpty() {
        return count == 0;
    }
    
    @Override
    public int size() {
        return count;
    }
}
