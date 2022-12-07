/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0023;

import java.util.ArrayList;

/**
 *
 * @author HE170417
 */
public class Order {
    private String CustomerName;
    private ArrayList<Fruit>orderFruit = new ArrayList<>();
//    constructor
    public Order() {
    }

    public Order(String CustomerName) {
        this.CustomerName = CustomerName;
    }
//getter setter
    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public ArrayList<Fruit> getOrderFruit() {
        return orderFruit;
    }

    public void setOrderFruit(ArrayList<Fruit> orderFruit) {
        this.orderFruit = orderFruit;
    }
//    add Fruit
    //check lại gộp 1 id thành 1 đơn
    public void addFruit(Fruit addFruit){
        if(getFruitById(addFruit.getId())==null){
            orderFruit.add(addFruit);
        }else{
            getFruitById(addFruit.getId()).setQuantity(addFruit.getQuantity()+getFruitById(addFruit.getId()).getQuantity());
        }
        getFruitById(addFruit.getId()).updateAmount();
    }

//    get fruit by id
    public Fruit getFruitById(int id){
        //get fruit
        for(Fruit i : orderFruit){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }

    
    
}
