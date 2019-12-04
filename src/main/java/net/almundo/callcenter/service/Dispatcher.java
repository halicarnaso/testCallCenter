package net.almundo.callcenter.service;

import net.almundo.callcenter.assest.Customer;
import net.almundo.callcenter.assest.Employee;

import java.util.concurrent.*;
import java.util.logging.Logger;

/**
 * Class that handles the calls and the size of the executor.
 * When it goes up to 10 threads the LinkedBlockingDeque handle the wait of the calls.
 * The PriorityBlockingQueue handle the priority on employees, using the java.lang.Comparable interface.
 */

public class Dispatcher {

    private static final Logger logger = Logger.getLogger(Dispatcher.class.toString());
    private static final int MAX_NUMBER_SIM_CALLS = 10;
    private ExecutorService executor;
    private BlockingQueue <Employee> availableEmployees;
    private BlockingQueue <Long> idsCall;

    public Dispatcher (BlockingQueue<Employee> availableEmployees) {
       this.availableEmployees = availableEmployees;
       this.idsCall = new  LinkedBlockingDeque<>();
       executor = Executors.newFixedThreadPool(MAX_NUMBER_SIM_CALLS);
    }

    public void dispatchCall (long idCall, Customer customer) throws InterruptedException {
        idsCall.put(idCall);
        Runnable callExecute = new Call(idsCall.take(),availableEmployees.take(),customer,this);
        executor.execute(callExecute);
    }

    public void terminateDispatch() throws InterruptedException {
        executor.shutdown();
        executor.awaitTermination(11, TimeUnit.SECONDS);
        logger.info("All threads finished.");
    }

    public void releaseEmployee (Employee employee){
        this.availableEmployees.add(employee);
    }
}
