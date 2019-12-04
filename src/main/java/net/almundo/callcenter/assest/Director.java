package net.almundo.callcenter.assest;

public class Director extends Employee{

    private static final int priority =3;

    public Director(String name, int priority) {
        super(name, priority);
    }

    public Director (String name){
        super (name,priority);
    }
}
