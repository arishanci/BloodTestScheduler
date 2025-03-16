/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestschedule;

/**
 *
 * @author arish
 */

public class BloodTestManager implements BloodTestSchedule {
    private String name;
    private String priority;
    private String gpDetails;

    public BloodTestManager(String name, String priority, String gpDetails) {
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

