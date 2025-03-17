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
import java.util.PriorityQueue;
import java.util.Comparator;

public class Scheduler {
    // ArrayList to store patient requests
    private List<BloodTestSchedule> requestList;
    
    // PriorityQueue to find next patient
    private PriorityQueue<BloodTestSchedule> priorityQueue;
    
    public Scheduler() {
        requestList = new ArrayList<>();
        
        priorityQueue = new PriorityQueue<>(new Comparator<BloodTestSchedule>() {
        @Override
            public int compare(BloodTestSchedule p1, BloodTestSchedule p2) {
             // compare priority between 2 patients
                int comp = Integer.compare(getPriorityValue(p1.getPriority()), getPriorityValue(p2.getPriority()));
                if (comp != 0) return comp;
        
                // if similar priorities, compare ages
                int ageComp = Integer.compare(p2.getAge(), p1.getAge());
                if (ageComp != 0) return ageComp;
        
                // if similar priorities and ages compare if they are coming from hospital or not
                if (p1.fromHospital() && !p2.fromHospital()) return -1;
                if (!p1.fromHospital() && p2.fromHospital()) return 1;
        
            return 0;
    }
});
    }
    
    // assign priority to a number for sorting
    private int getPriorityValue(String priority) {
        switch(priority.toLowerCase()){
            case "urgent": return 1;
            case "medium": return 2;
            case "low": return 3;
            default: return 4;
        }
    }
    
    //adds request to queue
    public void addRequest(BloodTestSchedule request) {
        requestList.add(request);
        priorityQueue.add(request);
    }
    
    // return request from arraylist
    public List<BloodTestSchedule> getAllRequests() {
        return new ArrayList<>(requestList);
    }
    
    // display requests
    public void displayRequests() {
        display(0);
    }
    
    private void display(int index) {
        if (index >= requestList.size()) return;
        System.out.println(requestList.get(index));
        display(index + 1);
    }
    
    // view next patient based on priority queue
    public BloodTestSchedule getNextPerson() {
        return priorityQueue.peek();
    }
    
    // Removes and returns the next patient from the priority queue and arraylist
    public BloodTestSchedule processNextPerson() {
        BloodTestSchedule next = priorityQueue.poll();
        if (next != null) {
        requestList.remove(next);
        }
    return next;
    }
}


