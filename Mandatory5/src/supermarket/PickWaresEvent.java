package supermarket;

import eventsim.Event;

public class PickWaresEvent extends Event {
    Customer customer;

    public PickWaresEvent(Customer customer) {
        super(customer.beginShoppingTime); //super(time) aka the time this event starts
        this.customer = customer;
        customer.checkoutDuration = (Checkout.PROD_DURATION * customer.numProducts) + Checkout.PAY_DURATION;
    }

    @Override
    public Event happen() {
        return new QueForTillEvent(customer);
    }

    @Override
    public String toString() {
        //return "PickWaresEvent {Start shopping at: " + getTime() + " ,customer = " + customer.name
        //        + " ,Shopping duration : " + customer.shoppingDuration
        //        + " ,End shopping at : " + (getTime() + customer.shoppingDuration)
        //        + " ,number of products : " + customer.numProducts + '}';

        //return "Customer : " + customer.name + " Products : " + customer.numProducts;
        return null;
    }
}
