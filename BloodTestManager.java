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
    private int age;
    private boolean fromHospital;

    public BloodTestManager(String name, String priority, String gpDetails, int age, boolean fromHospital) { //define details to store
        this.name = name;
        this.priority = priority;
        this.gpDetails = gpDetails;
        this.age = age;
        this.fromHospital = fromHospital;
    }

    @Override
    public String getName() { //getters
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
    public int getAge() {
        return age;
    }
    
    @Override
    public boolean fromHospital() {
        return fromHospital;
    }

     @Override
    public String toString() {
        return "Name: " + name + ", Priority: " + priority + ", GP: " + gpDetails + ", Age: " + age + ", From Hospital: " + fromHospital;
    }
}

