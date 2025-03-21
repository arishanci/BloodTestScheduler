/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestschedule;

/**
 *
 * @author Arisha Mirza
 * 18/03/2025
 * PQInterface.java Ver 1.0
 */

public interface PQInterface<T> {
    void add(T element);
    T remove();   // returns highest priorty element and removes from queue
    T peek();     // returns highest priority element but does not remove from queue
    boolean isEmpty();
    int size();
}

