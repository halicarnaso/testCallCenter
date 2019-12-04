package net.almundo.callcenter.assest;

import net.almundo.callcenter.service.Call;

public abstract class Employee implements Comparable<Employee> {

    private String name;
    private int priority;
    private Call currentCall;

    public Employee (String name, int priority) {

        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Employee employee) {
        return (this.getPriority() - employee.getPriority());
    }


}
