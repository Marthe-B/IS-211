package supermarket;

import eventsim.Event;

public class QueForTillEvent extends Event {
    Customer customer;

    public QueForTillEvent(Customer customer) {
        super(customer.checkoutTime);
        this.customer = customer;
    }

    @Override
    public Event happen() {
        return new EndShoppingEvent(customer);
    }
}
