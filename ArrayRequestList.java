/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestschedule;

/**
 *
 * @author Arisha Mirza
 * 18/03/2025
 * ArrayRequestList.java Ver 1.0
 */

@SuppressWarnings("unchecked")
public class ArrayRequestList<T> implements ListInterface<T> {
    private T[] data;
    private int count;
    private static final int INITIAL_CAPACITY = 10; //initial array stores 10

    public ArrayRequestList() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void add(T element) { 
        if(count == data.length) {
            resize();
        }
        data[count++] = element; //when element is added count is increased by 1
    }

    private void resize() {
        T[] newData = (T[]) new Object[data.length * 2]; //new array created at double the size if limit is hit
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData; //new array replaced old array
    }

    @Override
    public boolean remove(T element) { //remove from array
        for (int i = 0; i < count; i++) {
            if(data[i].equals(element)) {
                for (int j = i; j < count - 1; j++) {
                    data[j] = data[j+1];
                }
                data[--count] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= count) throw new IndexOutOfBoundsException();
        return data[index];
    }

    @Override
    public int size() {
        return count;
    }
}

