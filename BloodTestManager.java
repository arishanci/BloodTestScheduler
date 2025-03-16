/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestschedule;

/**
 *
 * @author Arisha Mirza
 * 15/03/2025
 * BloodTestManager.java Ver 1.0
 */

public class BloodTestManager implements BloodTestSchedule { //implements serializable
    private String name;
    private String priority;
    private String gpDetails;

    public BloodTestManager(String name, String priority, String gpDetails) { //define details to store
        this.name = name;
        this.priority = priority;
        this.gpDetails = gpDetails;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPriority() {
        return priority;
    }

    @Override
    public String getGPDetails() {
        return gpDetails;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Priority: " + priority + ", GP: " + gpDetails;
    }
}

