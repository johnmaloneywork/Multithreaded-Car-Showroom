package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //Instances of the CarShowroom Object and
        //Random Object
        CarShowroom carShowroom = new CarShowroom();
        Random rand = new Random();

        //Starts the day count at 1
        int day = 1;

        //While loop to go through each business day for 30 days
        //The same operations take place each day
        while (day <= 30){

            //Print statement states the day and number of cars in the showroom at the start of the day
            System.out.println("Day " + day + " beginning. There are " + carShowroom.getCars().size()  + " cars in the showroom today.");

            //Random int between 0-3 to create threads for seller and buyer
            int randomSeller = rand.nextInt(3);
            int randomBuyer = rand.nextInt(3);

            //For loop creating between 0-3 threads for Buyer and Seller each business day
            for (int j = 0; j <= randomSeller; j++){
                Seller seller = new Seller(carShowroom);
                Thread mySellerThread = new Thread(seller);
                mySellerThread.start();
            }

            for (int i = 0; i <= randomBuyer; i++){
                Buyer buyer = new Buyer(carShowroom);
                Thread myBuyerThread = new Thread(buyer);
                myBuyerThread.start();
            }

            //The sleep method was added so that Threads would be created in a timely manner each day
            //Previously threads were not acting until day 20+ and this solved that issue
            Thread.sleep(1000);
            day++;
        }
    }
}
