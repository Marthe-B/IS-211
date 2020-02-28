package supermarket;

import eventsim.Event;
import eventsim.EventSim;

public class StartCheckoutEvent extends Event {
    Customer customer;
    Checkout checkout;

    public StartCheckoutEvent(Customer customer, Checkout checkout) {
        super(EventSim.getClock() + customer.checkoutDuration);
        //super(customer.endShoppingTime);// + customer.checkoutDuration);
        //super(EventSim.getClock());
        this.customer = customer;

        //customer.exitQueTime = getTime();

        this.checkout = checkout;

        //customer.nextInLineTime = getTime();

    }

    @Override
    public Event happen() {
        //checkout.exitQue(customer);
        //return new EndShoppingEvent(customer);
        //checkout.checkOutCustomer();


        return checkout.checkOutCustomer();
    }

    @Override
    public String toString() {
        //return "QueForTillEvent {Start Que at : " + getTime() + " ,customer = " + customer.name
        //        + " ,Queued for : " + customer.checkoutDuration + '}';
        return "Customer : " + customer.name + " Exits que at : " + getTime() + " Current time : " + EventSim.getClock();
    }

}