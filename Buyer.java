package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class Buyer implements Runnable {

    //Two AtomicIntegers for the tracking of the number of
    //Buyers and the number of purchases made
    static AtomicInteger id = new AtomicInteger(0);
    static AtomicInteger purchaseCount = new AtomicInteger(0);

    //Instance of CarShowroom
    private CarShowroom carShowroom;

    //Initialising CarShowroom object in the constructor
    public Buyer(CarShowroom carShowroom) {
        this.carShowroom = carShowroom;
    }

    //Overridden run method as class implements runnable
    @Override
    public void run() {

        //Synchronized method to prevent multiple threads
        //Accessing the block of code for the carShowRoom object
        //At the same time
        synchronized (carShowroom){

            //Print statement states when a new Buyer arrives at the showroom
            //AtomicInteger is incremented each time a new buyer arrives
            System.out.println("A new Buyer #" + id.incrementAndGet() + " just appeared.");

            //While loop to give the Buyer actions if the showroom
            //Is empty. Print statement states the seller is waiting
            //To buy a car, so the wait method is called on
            //The showroom object. The Buyer thread then waits until
            //A car is added to the showroom, then buys a car
            //To the showroom
            while (carShowroom.isEmpty()){
                System.out.println("Buyer #" + id + " wants to buy a car, but the showroom is empty.");
                try {
                    carShowroom.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //Print statement states when a Buyer buys a car from the showroom
            //A car is then removed from the showroom and the other threads
            //Have been notified to allow them to continue
            System.out.println("Buyer #" + id + " bought a " + carShowroom.getCars().get(0) + ". " +
                    "This is purchase number " + purchaseCount.incrementAndGet() + ".");
            carShowroom.takeCar();
            carShowroom.notify();
        }
    }
}

