package supermarket;

import eventsim.Event;
import eventsim.EventSim;

public class StartCheckoutEvent extends Event {
    Customer customer;
    Checkout checkout;

    public StartCheckoutEvent(Customer customer) {
        super(EventSim.getClock()+ customer.checkoutDuration);
        this.customer = customer;

        checkout = customer.shop.shortestQue();

        customer.nextInLineTime = getTime();

    }

    @Override
    public Event happen() {
        checkout.exitQue(customer);
        return new EndShoppingEvent(customer);
    }

    @Override
    public String toString() {
        //return "QueForTillEvent {Start Que at : " + getTime() + " ,customer = " + customer.name
        //        + " ,Queued for : " + customer.checkoutDuration + '}';
        return "Customer : " + customer.name + " Exits que at : " + customer.nextInLineTime + " Current time : " + EventSim.getClock();
    }

}