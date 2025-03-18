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

import java.util.Comparator;

public class Scheduler {
    private ListInterface<BloodTestSchedule> requestList;
    private PQInterface<BloodTestSchedule> priorityQueue;
    
    public Scheduler() {
        requestList = new ArrayRequestList<>();
        Comparator<BloodTestSchedule> comp = new Comparator<BloodTestSchedule>() {
            @Override
            public int compare(BloodTestSchedule p1, BloodTestSchedule p2) {
                // First compare priorities
                int compVal = Integer.compare(getPriorityValue(p1.getPriority()), getPriorityValue(p2.getPriority()));
                if(compVal != 0) return compVal;
                // then older patients get priority if same priority
                int ageComp = Integer.compare(p2.getAge(), p1.getAge());
                if(ageComp != 0) return ageComp;
                // lastly compare hospital patients
                if(p1.fromHospital() && !p2.fromHospital()) return -1;
                if(!p1.fromHospital() && p2.fromHospital()) return 1;
                return 0;
            }
        };
        priorityQueue = new PQRequestList<>(comp);
    }
    
    private int getPriorityValue(String priority) {
        switch(priority.toLowerCase()){
            case "urgent": return 1;
            case "medium": return 2;
            case "low": return 3;
            default: return 4;
        }
    }
    
    //add to request list
    public void addRequest(BloodTestSchedule request) {
        requestList.add(request);
        priorityQueue.add(request);
    }
    
    //retrieve all requests in scheduler
    public BloodTestSchedule[] getAllRequests() {
        int size = requestList.size();
        BloodTestSchedule[] array = new BloodTestSchedule[size];
        for (int i = 0; i < size; i++) {
            array[i] = requestList.get(i);
        }
        return array;
    }
    
    public BloodTestSchedule getNextPerson() {
        return priorityQueue.peek();
    }
    
    // Removes and returns the next patient from both the priority queue and list.
    public BloodTestSchedule processNextPerson() {
        BloodTestSchedule next = priorityQueue.remove();
        if(next != null) {
            requestList.remove(next);
        }
        return next;
    }
}



