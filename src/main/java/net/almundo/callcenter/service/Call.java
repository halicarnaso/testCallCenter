package net.almundo.callcenter.service;

import net.almundo.callcenter.assest.Customer;
import net.almundo.callcenter.assest.Employee;
import net.almundo.callcenter.util.Callhelper;

import java.time.LocalDateTime;
import java.util.logging.Logger;

/**
 * @author DSSR
 * This class simulate a call and his random duration.
 * When the call finishes, the employee is added back to the queue.
 */

public class Call implements Runnable{

    private static final Logger logger = Logger.getLogger(Call.class.toString());
    private Long idCall;
    private Integer duration;
    private Customer customer;
    private Employee employee;
    private Dispatcher dispatcher;
    private Callhelper callhelper;

    public Call (Long idCall, Employee employee, Customer customer, Dispatcher dispatcher){
        this.idCall = idCall;
        this.employee = employee;
        this.customer = customer;
        this.dispatcher = dispatcher;
    }

    public void setDuration (int minDuration, int maxDuration){
        callhelper = Callhelper.getInstance();
        this.duration = callhelper.getDuration(minDuration,maxDuration);

    }

    @Override
    public void run() {
        this.setDuration(5,10);
        int callDuration = this.duration*1000;
        logger.info("# StartTime" + LocalDateTime.now() + "#Call Number " + idCall + " #Call duration = " + callDuration
                + " #Customer = " + customer.getName() + " #Employee = " + employee.getName());
        try {
            Thread.sleep(callDuration);
            logger.info("#EndTime= " + LocalDateTime.now() + "#Call number " + idCall);
            logger.info("Now the employee " + employee.getName() + " with priority ## " + employee.getPriority() + " ## has become available." );
            dispatcher.releaseEmployee(employee);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
