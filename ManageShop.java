/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0023;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author HE170417
 */
public class ManageShop {
    //variable section
    ManageFruit mf;
    ArrayList<Order> orderList = new ArrayList<>();
    Scanner sc2 = new Scanner(System.in);
    
    //constructor
    public ManageShop(ManageFruit mf) {
        this.mf = mf;
    }
    
    //shopping
   public void Shopping(){
       Order SingleOrder = new Order();
       boolean stillShopping = true;
       int tempID, tempQuantity;
       String choice;
       //if user still want to shopping
       if(mf.getList().isEmpty()){
           System.out.println("Fruit list in the shop is empty!");
           return;
       }
       while(stillShopping){
           //display the fruit collection
           mf.display();
           System.out.println("ID of fruit you want to buy");
           while(true){
                try{
                    tempID = Integer.parseInt(sc2.nextLine());
                    if(mf.getFruitById(tempID)!=null){
                        break;
                    }
                    System.out.println("Fruit you want is not available in the shop");
                }catch(Exception e){
                    System.out.println(e);
                }
            }
           //Create fruit for order
           Fruit SingleFruit = new Fruit(mf.getFruitById(tempID));
           System.out.println("Please input quantity");
           while(true){
                try{
                    tempQuantity = Integer.parseInt(sc2.nextLine());
                    if(tempQuantity == 0){
                        System.out.println("Order reject because quantity you input is 0");
                        break;
                    }
                    if(tempQuantity <=mf.getFruitById(tempID).getQuantity()){
                        //update quantity for ordered Fruit
                        SingleFruit.setQuantity(tempQuantity);
                        //update quantity for Fruit in FruitCollection
                        mf.getFruitById(tempID).setQuantity(mf.getFruitById(tempID).getQuantity()-tempQuantity);
                        //add single fruit to single order
                        SingleOrder.addFruit(SingleFruit);
                        break;
                    }
                    System.out.println("we don't have enough for you");
                }catch(Exception e){
                    System.out.println(e);
                }
            }
           //accept user input
            while(true){
                    System.out.println("Do you want to continue? (Y/N)");
                    choice = sc2.nextLine();
                    if(choice.compareToIgnoreCase("N")==0){
                        stillShopping = false;
                        displaySingleOrder(SingleOrder.getOrderFruit());
                        //input customer name
                        while(true){
                            System.out.println("\nInput your name: ");
                            SingleOrder.setCustomerName(sc2.nextLine());
                            if(!SingleOrder.getCustomerName().isEmpty()){
                                break;
                            }
                            System.out.println("name must not be empty");

                        }
//                      add single order to bigger one
                        orderList.add(SingleOrder);
                        break;
                    }
                    else if(choice.compareToIgnoreCase("Y")==0){
                        break;
                    }
                    else{
                        System.out.println("Invalid input");
                    }
                } 
        }
   }

    //show order
    public void displaySingleOrder(ArrayList<Fruit>OrderList){
        System.out.println("---------Order---------");
        System.out.println("Name| Quantity| Price| Amount");
        for(Fruit i : OrderList){
            System.out.println(i.toStringOrder());
        }
        System.out.println("Total amount: "+mf.getTotal(OrderList)+"$");
    }
    public void displayOrder(){
        for(Order o : orderList){
            System.out.println("\nCustommer: "+o.getCustomerName());
            displaySingleOrder(o.getOrderFruit());
        }
    }
    public void updateExitsOrder(){
        
    }
}
