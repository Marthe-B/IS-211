/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;
import eventsim.EventSim;


/**
 * A customer finishes shopping and heads for the checkout with the shortest
 * queue
 *
 * @author evenal
 */
public class EndShoppingEvent extends Event {
    Customer customer;


    public EndShoppingEvent(Customer customer) {
        super(EventSim.getClock() + customer.checkoutDuration); //super(time) aka the time this event starts
        //super(customer.beginShoppingTime + customer.shoppingDuration);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        //customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        return null;
    }


    @Override
    public String toString() {
        //return "EndShoppingEvent {End shopping at : " + getTime() + " ,customer = " + customer.name + '}';

        //return "Customer : " + customer.name + " Leave shop at : " + getTime();
        return "Customer : " + customer.name + " Queued for : " + ((getTime() - customer.enterQueTime) + customer.checkoutTime) + " Current time : " + EventSim.getClock();
    }



}
