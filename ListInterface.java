/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestschedule;

/**
 *
 * @author Arisha Mirza
 * 18/03/2025
 * ListInterface.java Ver 1.0
 */

public interface ListInterface<T> {
    void add(T element); //add element to list
    boolean remove(T element); // remove element
    T get(int index); //get size
    int size();
}

