package net.almundo.callcenter.test;

import net.almundo.callcenter.assest.*;
import net.almundo.callcenter.service.Dispatcher;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Test for the Dispatcher.
 */
public class DispatcherTest {

    Dispatcher dispatcher;
    Customer customer;
    int callsQuantity=0;

    private BlockingQueue<Employee> availableEmployees;

    /**
     * callsQuantity are the amount of calls for the test.
     * availableEmployees the employees that can take a call, PepeGrillo is an operator,
     * Julian is a supervisor and Pedro is a Director.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        callsQuantity=20;
        availableEmployees = new PriorityBlockingQueue<>();

        availableEmployees.put(new Operator("PepeGrillo"));
        availableEmployees.put(new Operator("PepeGrillo2"));
        availableEmployees.put(new Operator("PepeGrillo3"));
        /*availableEmployees.put(new Operator("PepeGrillo4"));
        availableEmployees.put(new Operator("PepeGrillo5"));
        availableEmployees.put(new Operator("PepeGrillo6"));
        availableEmployees.put(new Operator("PepeGrillo7"));
        availableEmployees.put(new Operator("PepeGrillo8"));
        availableEmployees.put(new Operator("PepeGrillo9"));
        availableEmployees.put(new Operator("PepeGrillo10"));*/
        availableEmployees.put(new Supervisor("Julian1"));
        availableEmployees.put(new Supervisor("Julian2"));
        availableEmployees.put(new Supervisor("Julian3"));
        /*availableEmployees.put(new Supervisor("Julian4"));
        availableEmployees.put(new Supervisor("Julian5"));
        availableEmployees.put(new Supervisor("Julian6"));
        availableEmployees.put(new Supervisor("Julian7"));
        availableEmployees.put(new Supervisor("Julian8"));
        availableEmployees.put(new Supervisor("Julian9"));
        availableEmployees.put(new Supervisor("Julian10"));*/
        availableEmployees.put(new Director("Pedro"));
        availableEmployees.put(new Director("Pedro2"));
        /*availableEmployees.put(new Director("Pedro3"));
        availableEmployees.put(new Director("Pedro4"));
        availableEmployees.put(new Director("Pedro5"));
        availableEmployees.put(new Director("Pedro6"));
        availableEmployees.put(new Director("Pedro7"));
        availableEmployees.put(new Director("Pedro8"));
        availableEmployees.put(new Director("Pedro9"));
        availableEmployees.put(new Director("Pedro10"));*/

        customer = new Customer("Alberto");

        dispatcher = new Dispatcher(availableEmployees);
    }

    /**
     * Make one call
     * @throws InterruptedException
     */
    @Test
    public void makeOneCall () throws  InterruptedException {
        dispatcher.dispatchCall(1,customer);
        dispatcher.terminateDispatch();
    }

    /**
     * Makes as many calls as callsQuantity you setup.
     * @throws InterruptedException
     */
    @Test
    public void makeManyCalls () throws  InterruptedException {
        for (int idCall = 1; idCall <= callsQuantity; idCall++) {
            dispatcher.dispatchCall(idCall, customer);
        }
        dispatcher.terminateDispatch();
    }

    @Test
    public void makeTenCalls () throws  InterruptedException {
        for (int idCall = 1; idCall <= 10; idCall++) {
            dispatcher.dispatchCall(idCall, customer);
        }
        dispatcher.terminateDispatch();
    }
}