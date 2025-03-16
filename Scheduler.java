/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestschedule;

/**
 *
 * @author Arisha Mirza
 * 15/03/2025
 * Scheduler.java Ver 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    
    //create arraylist
    private List<BloodTestSchedule> requestList;

    public Scheduler() {
        requestList = new ArrayList<>();
    }
    
    //add person to list
    public void addRequest(BloodTestSchedule person) {
        requestList.add(person);
    }

    // display list
    public void displayRequests() {
        display(requestList, 0);
    }
    
    private void display(List<BloodTestSchedule> list, int index) {
        if (index >= list.size()) {
            return;
        }
        System.out.println(list.get(index));
        display(list, index + 1);
    }
    
    // Getter for the list
    public List<BloodTestSchedule> getRequestList() {
        return requestList;
    }
}

