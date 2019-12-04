package net.almundo.callcenter.assest;

public class Operator extends Employee{

    private static final int priority =1;

    public Operator(String name, int priority) {
        super(name, priority);
    }

    public Operator ( String name){
        super (name,priority);
    }

}
