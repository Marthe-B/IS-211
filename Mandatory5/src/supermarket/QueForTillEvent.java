package supermarket;

import eventsim.Event;
import eventsim.EventSim;

public class QueForTillEvent extends Event {
    Customer customer;
    Checkout checkout;

    public QueForTillEvent(Customer customer) {
        super(customer.endShoppingTime);
        this.customer = customer;

        checkout = customer.shop.shortestQue();

        customer.enterQueTime = getTime();

    }

    @Override
    public Event happen() {

        checkout.enterQue(customer);

        return new StartCheckoutEvent(customer, checkout);
        //return null;
    }

    @Override
    public String toString() {
        //return "QueForTillEvent {Start Que at : " + getTime() + " ,customer = " + customer.name
        //        + " ,Queued for : " + customer.checkoutDuration + '}';
        return "Customer : " + customer.name + " Enter Que at : " + customer.enterQueTime + " Current time : " + EventSim.getClock();
    }

}
