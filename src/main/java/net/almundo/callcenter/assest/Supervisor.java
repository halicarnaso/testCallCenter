package net.almundo.callcenter.assest;

public class Supervisor extends Employee{

    private static final int priority =2;

    public Supervisor(String name, int priority) {
        super(name, priority);
    }

    public Supervisor (String name){
        super (name,priority);
    }
}
