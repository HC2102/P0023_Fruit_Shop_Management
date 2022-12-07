/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0023;

import java.util.Scanner;

/**
 *
 * @author HE170417
 */
public class Fruit {
    private int id, quantity;
    private String name, origin;
    private double price;
    private double amount =0 ;    
    //constructor
    public Fruit() {
    }
    public Fruit(int id, int quantity, String name, String origin, double price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.origin = origin;
        this.price = price;
    }
    public Fruit( Fruit e){
        this.id = e.id;
        this.name = e.name;
        this.origin = e.origin;
        this.price = e.price;
        this.quantity = e.quantity;
    }
    
    //check lại getter setter
    
    //getter & setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }
    //update amount
    public double updateAmount(){
        return amount = price*quantity;
    }
    
    //toString
    @Override
    public String toString() {
        String line = String.format("%-15d%-20s%-15s%-15f%-10d", id, name, origin, price,quantity);
        return line;
    }
    
    public String toStringOrder(){
        return name+"   "+quantity+"    "+price+"$"+"   "+amount+"$";
    }

    //Check input value to object is valid
    
   
}
