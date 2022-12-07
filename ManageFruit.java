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
public class ManageFruit {
    private ArrayList<Fruit> FruitCollection = new ArrayList<>();
    Scanner sc1 = new Scanner(System.in);
    public ManageFruit() {
    }
     //create fruit
    public Fruit createFruit(){
        Fruit temp = new Fruit();
        while(true){
            try{
                System.out.println("\nEnter fruit id ");
                temp.setId(isIDvalid(Integer.parseInt(sc1.nextLine())));
            break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        while(true){
            try{
                if(isIdDuplicate(temp.getId())==true)break;
                System.out.println("Enter fruit name ");
                temp.setName(isNameValid(sc1.nextLine()));
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        while(true){
            try{
                System.out.println("Enter fruit price ");
                temp.setPrice(isPriceValid(Double.parseDouble(sc1.nextLine())));
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        while(true){
            try{
                System.out.println("Enter fruit quantity ");
                temp.setQuantity(isQuantityValid(Integer.parseInt(sc1.nextLine())));
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        while(true){
            try{
                if(isIdDuplicate(temp.getId())==true)break;
                System.out.println("Enter fruit origin ");
                temp.setOrigin(isOriginValid(sc1.nextLine()));
                break;
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        return temp;
    }
//    addFruit
    public void addFruitToCollection(){
        boolean isLoop = true;
        String option;
        Fruit temp;
        while(isLoop){
            temp = createFruit();
            if(isIdDuplicate(temp.getId())==true){
                System.out.println("id duplicated now record you just input will update the exits record");
                getFruitById(temp.getId()).setPrice(temp.getPrice());
                getFruitById(temp.getId()).setQuantity(temp.getQuantity());
            }else{
                FruitCollection.add(temp);
            }
            do{
                
                System.out.println("Do you want to continue? (Y/N)");
                option = sc1.nextLine();
                if(option.compareToIgnoreCase("N")==0){
                    isLoop = false;
                    display();
                    break;
                }else if(option.compareToIgnoreCase("Y")==0){
                    isLoop = true;
                    break;
                }
                else{
                    System.out.println("Invalid input");
                }
            }while(true);
        }
    }
//    getFuit
    public Fruit getFruitById(int id){
        //get fruit
        for(Fruit i : FruitCollection){
            if(i.getId() == id){
                return i;
            }
        }
        return null;
    }
//    getList
    public ArrayList<Fruit> getList(){
        return FruitCollection;
    }
//    isDupplicate
    boolean isIdDuplicate(int check){
        for(Fruit i : FruitCollection){
            if(i.getId() == check){
                return true;
            }
        }
        return false;
    }
    //display
    public void display(){
        System.out.println("\n----------------------------------Fruit List----------------------------------");
        System.out.println("| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ || ++ Quantity ++ |");
        for(Fruit i: FruitCollection){
            System.out.println(i.toString());
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
    public double getTotal(ArrayList<Fruit> fruitList){
        double total = 0;
        for(Fruit i : fruitList){
            total += i.getAmount();
        }
        return total;
    }
    
    
    //validate
    //check if id valid
    public int isIDvalid(int check) throws Exception{
        if(check <=0){
            throw new Exception("Invalid ID");
        }else{
            return check;
        }
    }
    //check if quantity valid
    public int isQuantityValid(int check) throws Exception{
        if(check <=0){
            throw new Exception("Invalid Quantity");
        }else{
            return check;
        }
    }
    //check if name valid
    public String isNameValid(String check) throws Exception{
        if(check.isEmpty()||!check.matches("^[a-zA-z\\s]*$")){
            throw new Exception("Invalid Name");
        }else{
            return check;
        }
    }
    //check if origin valid
    public String isOriginValid(String check) throws Exception{
        if(check.isEmpty()||!check.matches("^[a-zA-z\\s]*$")){
            throw new Exception("Invalid Origin");
        }else{
            return check;
        }
    }
    //check if price valid
    public Double isPriceValid(Double check) throws Exception{
        if(check.isNaN()|| check <0){
            throw new Exception("Invalid Price");
        }else{
            return check;
        }
    }
}
