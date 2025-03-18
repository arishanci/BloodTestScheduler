/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestschedule;

/**
 *
 * @author arisha mirza
 * 18/03/2025
 * QueueAbsenceList.java ver 1.0
 */

public class QueueAbsenceList<T> implements QueueInterface<T> {

    private class Node {
        T data; //data stored in T
        Node next; //ref to next node
        
        //constructor
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node front; //first element in queue
    private Node rear; //last element in queue
    private int count; //size of queue
    
    //construct queue
    public QueueAbsenceList() {
        front = null;
        rear = null;
        count = 0;
    }
    
    //new elements added to end of queue
    @Override
    public void enqueue(T element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode; //new node added to end of queue
        }
        rear = newNode;
        count++; //increase size of queue
    }
    
    //returns and removes element from first position of queue
    @Override
    public T dequeue() {
        if (isEmpty()) return null;
        T element = front.data;
        front = front.next;
        count--; //queue size decreases when element is removed
        if (isEmpty()) {
            rear = null;
        }
        return element;
    }
    
    //returns element from front of queue
    @Override
    public T peek() {
        if (isEmpty()) return null;
        return front.data;
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

