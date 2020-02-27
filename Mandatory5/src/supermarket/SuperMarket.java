/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;
import eventsim.EventSim;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author evenal
 */
public class SuperMarket {

    public static void main(String[] arts) {
        SuperMarket supern = new SuperMarket();
        supern.startSim();
    }

    public static final int NUM_CHECKOUTS = 1;
    public static final int NUM_CUSTOMERS = 2;

    Checkout[] checkouts;
    List<Customer> customers;
    List<Event> init;


    public SuperMarket() {
        checkouts = new Checkout[NUM_CHECKOUTS]; //Array list of number of checkouts

        for (int i = 0; i < NUM_CHECKOUTS; i++)
            checkouts[i] = new Checkout(this, i); //Add number of checkout objects, with shop and number as param

        customers = new ArrayList<>(); //new ArrayList of Customers
        init = new ArrayList<Event>(); //new ArrayList of Events

        for (int i = 0; i < NUM_CUSTOMERS; i++) {
            Customer c = new Customer(this, i); //Create new customer with this shop and a number as param
            init.add(new BeginShoppingEvent(c)); //Add a shopping event with the newly created customer as param
            customers.add(c); // Add the customer to the customer list
        }
    }

    public Checkout shortestQue() {
        return checkouts[0];

    }


    public void startSim() {
        EventSim sim = EventSim.getInstance();
        sim.setup(init);
        sim.run();
    }
}
