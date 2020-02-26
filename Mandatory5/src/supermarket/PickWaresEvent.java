package supermarket;

import eventsim.Event;

public class PickWaresEvent extends Event {
    Customer customer;

    public PickWaresEvent(Customer customer) {
        super(customer.shoppingDuration);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }

    @Override
    public String toString() {
        return "PickWaresEvent {Checkout Time: " + getTime() + " ,customer = " + customer.name
                + " ,Shopping duration: " + customer.shoppingDuration
                + " ,number of products : " + customer.numProducts + '}';
    }
}
