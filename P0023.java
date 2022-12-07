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
public class P0023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //variable section
       int option;
       Scanner sc = new Scanner(System.in);
       ManageFruit mf = new ManageFruit();
       ManageShop ms = new ManageShop(mf);

       //main
       while(true){
           try{
                printMenu();
                option = Integer.parseInt(sc.nextLine());
                switch(option){
                    case 1:
                        mf.addFruitToCollection();
                        break;
                    case 2:
                        ms.displayOrder();
                        break;
                    case 3:
                        ms.Shopping();
                        break;
                    case 4:
                        System.out.println("Program exits");
                        return;
                    default:
                        System.out.println("Invalid input");
                }
           }catch(NumberFormatException e){
               System.out.println(e);
           }
           
       }
       
    }
    
    //static method to print main menu
    public static void printMenu(){
        System.out.println("\nFruit shop system"
                + "\n1. Create Fruit"
                + "\n2. View orders"
                + "\n3. Shopping (for buyer)"
                + "\n4. Exit"
                + "\n(Please choose 1 to create product, 2 to view, 3 for shopping and 4 to exit)\n");
        System.out.print("Your option: ");
    }
}
