package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class Seller implements Runnable {

    //Two AtomicIntegers for the tracking of the number of
    //Sellers and the number of sales made
    static AtomicInteger id = new AtomicInteger(0);
    static AtomicInteger saleCount = new AtomicInteger(0);

    //Instance of Car and CarShowroom
    private Car car;
    private CarShowroom carShowroom;

    //Initialising CarShowroom and Car object in the constructor
    public Seller(CarShowroom carShowroom){
        this.carShowroom = carShowroom;
        this.car = new Car();
    }

    //Overridden run method as class implements runnable
    @Override
    public void run() {

        //Synchronized method to prevent multiple threads
        //Accessing the block of code for the carShowRoom object
        //At the same time
        synchronized (carShowroom){
            System.out.println("A new Seller #" + id.incrementAndGet() + " just appeared with a " + car + " to sell.");

            //While loop to give the Seller actions if the showroom
            //Is filled to capacity. Print statement states the seller
            //Is waiting to sell a car, so the wait method is called on
            //The showroom object. The Seller thread then waits until
            //The showroom falls below full capacity, then sells a car
            //To the showroom
            while (carShowroom.isFull()){
                System.out.println("Seller #" + id + " is trying to sell a car, but the showroom is full");
                try {
                    carShowroom.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //Print statement states when a Seller sells a car from the showroom
            //A car is then added to the showroom and the other threads
            //Have been notified to allow them to continue
            System.out.println("Seller #" + id + " sold their " + car + " to the showroom. " +
                    "This is sale number " + saleCount.incrementAndGet() + ".");
            carShowroom.addCar(car);
            carShowroom.notify();
        }
    }
}