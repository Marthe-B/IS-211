package supermarket;

import eventsim.Event;

public class PickWaresEvent extends Event {
    Customer customer;

    public PickWaresEvent(Customer customer) {
        super(customer.numProducts);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }
}
