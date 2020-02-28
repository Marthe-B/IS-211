/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;


/**
 * A customer enters the shop
 *
 * @author evenal
 */
public class BeginShoppingEvent extends Event {
    Customer customer;


    public BeginShoppingEvent(Customer customer) {
        super(customer.beginShoppingTime); //super(time) aka the time this event starts
        this.customer = customer;
    }


    @Override
    public Event happen() {
        return new PickWaresEvent(customer);
    }

    @Override
    public String toString() {
        //return "BeginShoppingEvent {Enter Time: " + customer.beginShoppingTime + " ,customer = " + customer.name;

        return "Customer : " + customer.name + " Enter Shop at : " + customer.beginShoppingTime + " Shopped for " + customer.shoppingDuration;
        //return null;
    }
}
