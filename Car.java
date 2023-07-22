package com.company;

import java.util.Random;

public class Car {

    //Car Variables
    private String registration;
    private int saleValue;
    private String colour;

    //Two arrays to hold colours and licence plate counties
    //These will be randomly assigned to the variables
    //Colour and registration in the constructor
    private static final String[] colourArray = {"Blue", "Green", "Black", "Red", "White", "Silver", "Tan", "Yellow", "Orange"};
    private static final String[] licenceCounties = {"C", "CE", "CN", "CW", "D", "DL", "G", "KE", "KK", "KY", "L", "LD", "LH",
            "LK", "LM", "LS", "MH", "MN", "MO", "OY", "SO", "RN", "TN", "TS", "W", "WD", "WH", "WX", "WW"};

    //Instance of Random to allow the randomisation colours and
    //Licence plate county codes
    Random rand = new Random();

    //Overloaded Constructors
    //First assigns random values to colour and registration
    //As well as generating a random value between 1000-2000
    //And assigning random codes to the licence plates
    public Car(){
        registration = rand.nextInt(99) + "-" + licenceCounties[rand.nextInt(licenceCounties.length)] + "-" + rand.nextInt(9999);
        saleValue = rand.nextInt(1000, 20000);
        colour = colourArray[rand.nextInt(colourArray.length)];
    }

    public Car(String registration, int saleValue, String colour){
        this.registration = registration;
        this.saleValue = saleValue;
        this.colour = colour;
    }

    //toString method to display the contents of Car Object
    @Override
    public String toString() {
        return colour + " car with registration " + registration + " worth €" + saleValue;
    }
}


