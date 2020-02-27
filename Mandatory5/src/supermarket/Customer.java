/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;
import eventsim.EventSim;


/**
 *
 * @author evenal
 */
public class Customer {
    // customer will pick a random number of products between these two values
    public static final int MAX_PRODUCTS = 50;
    public static final int MIN_PRODUCTS = 1;

    // customer will spend random amount of time between these values before
    // going to check out
    public static final int MAX_SHOP_TIME = 50;
    public static final int MIN_SHOP_TIME = 1;

    // customer will arrive at random intervals
    public static final int MAX_DELAY_ENTER = 10;
    public static final int MIN_DELAY_ENTER = 1;

    SuperMarket shop;
    String name;

    int beginShoppingTime;
    int shoppingDuration;
    int numProducts;
    int endShoppingTime;
    int queueWaitDuration;
    int checkoutTime;
    int checkoutDuration;
    int leaveTime;

    int enterQueTime;
    int nextInLineTime;
    int exitQueTime;


    public Customer(SuperMarket shop, int i) {
        this.shop = shop;
        name = "Cust" + i;
        // random start time, initialized at beginning of sim, so customers may not enter in numbered order
        beginShoppingTime = EventSim.getClock() + EventSim.nextInt(MIN_DELAY_ENTER, MAX_DELAY_ENTER);
        //beginShoppingTime = i;
        numProducts = EventSim.nextInt(MIN_PRODUCTS, MAX_PRODUCTS);
        shoppingDuration = EventSim.nextInt(MIN_SHOP_TIME, MAX_SHOP_TIME);
        endShoppingTime = beginShoppingTime + shoppingDuration;
    }

    public void setBeginShoppingTime(int prevCustomer) {
        beginShoppingTime = prevCustomer + EventSim.nextInt(MIN_DELAY_ENTER, MAX_DELAY_ENTER);
    }

    public int getBeginShoppingTime() {
        return beginShoppingTime;
    }

    public String getName() {
        return name;
    }

    public void setCheckoutDuration() {
    }

    public int getShoppingDuration() {
        return shoppingDuration;
    }

}
