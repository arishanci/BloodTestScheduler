/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestschedule;

/**
 *
 * @author Arisha Mirza
 * 17/03/2025
 * AbsenceTracker.java Ver 1.0
 */

public class AbsenceTracker {
    private QueueInterface<BloodTestSchedule> absenceQueue;
    
    public AbsenceTracker() {
        absenceQueue = new QueueAbsenceList<>();
    }
    
    public void addAbsence(BloodTestSchedule request) {
        absenceQueue.enqueue(request);
        
        while (absenceQueue.size() > 5) { //saves last 5 entries removes oldest
            absenceQueue.dequeue();
        }
    }
    
    public BloodTestSchedule[] getAbsences() { //returns array of absences
        int size = absenceQueue.size();
        BloodTestSchedule[] array = new BloodTestSchedule[size];
        
        //loop dequeues and enqueues each element to keep order
        for (int i = 0; i < size; i++) {
            BloodTestSchedule element = absenceQueue.dequeue();
            array[i] = element;
            absenceQueue.enqueue(element); // new elements added to end of queue
        }
        return array;
    }

}
