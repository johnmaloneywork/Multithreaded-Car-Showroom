package com.company;

import java.util.ArrayList;

public class CarShowroom {

    //Arraylist to hold objects of type cars
    //Holds the cars within the showroom for sale
    private ArrayList<Car> cars = new ArrayList<Car>();

    //isFull and isEmpty methods
    //Checking if the showroom is full or empty
    //So that cars may be bought or sold from the
    //Showroom
    public boolean isEmpty(){
        return cars.size() == 0;
    }

    public boolean isFull(){
        int capacity = 10;
        return cars.size() == capacity;
    }

    //addCar method
    //To sell cars to the showroom from the seller perspective
    //Method must check if the showroom is full before any
    //More cars may be added
    public void addCar(Car car){
        if(!isFull()){
            cars.add(car);
        }
    }

    //takeCar method
    //To purchase cars from the showroom from the buyer perspective
    //Method must check if the showroom is empty before any car
    //May be taken
    public void takeCar() {
        if(!cars.isEmpty()){
            cars.remove(0);
        }
    }

    //Getter for ArrayList cars
    public ArrayList<Car> getCars() {
        return cars;
    }
}
