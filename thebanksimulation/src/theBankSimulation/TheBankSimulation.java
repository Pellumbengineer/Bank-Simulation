/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theBankSimulation;


import java.util.Random;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author user Finish this sheet
 */
public class TheBankSimulation {

   
    public static void main(String[] args) {
       
        Scanner input = new Scanner(System.in);
        Random randomGenerator = new Random();
        
        
        String gender="";
        int secenek1 = 0;
        int secenek=0;
        double money = 0;
        int number = 0;
        int ID = 0;
        int ID1 = 0;
        int dogruluk = 1;
        
        
        double credit = 0;
        do {

            System.out.println("1 - Adding Customer.");
            System.out.println("2 - Deleting Customer By ID.");
            System.out.println("3 - Listing Customer menu.");
            System.out.println("4 - Update Customer Info menu.");
            System.out.println("5 - Adding Money.");
            System.out.println("6 - Drawing Money.");
            System.out.println("7 - Transfering money");
            System.out.println("0 - To Exit the program.");

            do {
                try {
                    System.out.print("\nEnter a number :");
                    number = Integer.parseInt(input.nextLine());
                    dogruluk = 2;
                } catch (NumberFormatException e) {
                    System.out.println("You entered non valid number\nEnter again please");

                }
            } while (dogruluk == 1);

            if (number == 1) {
                int result;
                dogruluk = 1;
                do {
                    try {
                        //System.out.println("enter the ID");
                        ID = randomGenerator.nextInt(100000);
                                //Integer.parseInt(input.nextLine());
                        dogruluk = 2;
                    } catch (NumberFormatException e) {
                        System.out.println("You entered non valid number\nEnter again please");
                    }
                } while (dogruluk == 1);
                result = control(ID);

                while (result == 1) {

                   // System.out.println("You entered the exist ID number.\nPlease enter again.\n");

                    System.out.println("Your Id customer is given for the second time becouse the first time was given the same with others ID !!!");
                    dogruluk = 1;
                    do {
                        try {
                          // System.out.println("enter the ID");
                            ID = randomGenerator.nextInt(100000);
                                    //Integer.parseInt(input.nextLine());
                            dogruluk = 2;
                        } catch (NumberFormatException e) {
                            //System.out.println("You entered non valid number\nEnter again please");
                        }
                    } while (dogruluk == 1);
                    result = control(ID);

                }
                System.out.println("Enter name");
                String name = input.nextLine();
                System.out.println("Enter lastName");
                String lastName = input.nextLine();

                dogruluk = 1;
                do {
                    System.out.println("Enter gender  'Male' or 'Female'.");
                    gender = input.nextLine();
                    if (gender.equals("male") || gender.equals("Male") || gender.equals("female") || gender.equals("Female")) {
                        dogruluk = 2;
                    } else {
                        System.out.println("Enter again you didn't enter right gender");

                    }
                } while (dogruluk == 1);

                System.out.println("Your customer ID is -> "+ID);
                
                
                System.out.println("Do you want to add money\nIf you dont add money your balance will be ( 0 ).\n1 - Adding.\n0 - Back to maint menu.\nEnter a number.");
                secenek = Integer.parseInt(input.nextLine());

                if (secenek == 1) {

                    int dogruluk1 = 1;
                    do {
                        try {
                            System.out.println("enter credit");
                            credit = Double.parseDouble(input.nextLine());
                            dogruluk1 = 2;
                            //break;
                        } catch (NumberFormatException e) {
                            System.out.println("You entered non valid number\nEnter again please");
                        }
                    } while (dogruluk1 == 1);
                }
                Bank.AddCustomer(ID, name, lastName, gender, credit); 


            } else if (number == 2) {
                dogruluk = 1;
                do {
                    try {
                        System.out.println("Enter the ID");
                        ID = Integer.parseInt(input.nextLine());
                        dogruluk = 2;
                    } catch (NumberFormatException e) {
                        System.out.println("You entered non valid number\nEnter again please");
                    }
                } while (dogruluk == 1);
                
                Bank.deletingCostumerById(ID);

            } else if (number == 3) {
                if (Customer.customers.isEmpty()) {
                    System.out.println("\n***There is no customer !!!***\n");
                } else {
                    do{
                    System.out.println("1 - List all Customers.");
                    System.out.println("2 - List Customers by ID.");
                    System.out.println("3 - List Customers by name.");
                    System.out.println("4 - List Customers by lastName.");
                    System.out.println("5 - List Customers by Gender.");
                    System.out.println("0 - Back to main menu");
                    
                    do {
                        try {
                            System.out.print("\nEnter a number :");
                            secenek1 = Integer.parseInt(input.nextLine());
                            dogruluk = 2;
                        } catch (NumberFormatException e) {
                            System.out.println("You entered non valid number\nEnter again please");

                        }
                    } while (dogruluk == 1);
                    if (secenek1 == 1) {
                        if(Customer.customers.isEmpty()){
                            System.out.println("There is no customer");
                        }else{
                         System.out.println(Bank.listAllCostumer());
                        }
                    } else if (secenek1 == 2) {
                        dogruluk = 1;
                        do {
                            try {
                                System.out.println("Enter the ID");
                                ID = Integer.parseInt(input.nextLine());
                                dogruluk = 2;
                            } catch (NumberFormatException e) {
                                System.out.println("You entered non valid number\nEnter again please");
                            }
                        } while (dogruluk == 1);
                        System.out.println(Bank.listCostumerByID(ID));
                    } else if (secenek1 == 3) {

                        System.out.println(Bank.listCostumersEnteredName());
                    }else if(secenek1 == 4){
                        System.out.println(Bank.listCostumersEnteredLastName());
                    }else if(secenek1 == 5){
                        System.out.println(Bank.listCostumersByGender());
                    }
                    }while(secenek1!=0);
                        
                    
                }
            } else if (number == 4) {

                do {
                    System.out.println("1 - Updating name");
                    System.out.println("2 - Updating last name");
                    System.out.println("3 - Updating gender");
                    System.out.println("0 - Back to main menu");

                    do {
                        try {
                            System.out.print("\nEnter a number :");
                            secenek = Integer.parseInt(input.nextLine());
                            dogruluk = 2;
                        } catch (NumberFormatException e) {
                            System.out.println("You entered non valid number\nEnter again please");

                        }
                    } while (dogruluk == 1);

                    if (secenek == 1) {
                        dogruluk = 1;
                        do {
                            try {
                                System.out.println("enter your ID to update your name");
                                ID = Integer.parseInt(input.nextLine());                                
                                dogruluk = 2;
                            } catch (NumberFormatException e) {
                                System.out.println("You entered non valid number\nEnter again please");
                            }
                        } while (dogruluk == 1);
                        System.out.println("Enter new name");
                        String newName = input.nextLine();
                        Bank.updateCostumerName(ID, newName);
                    } else if (secenek == 2) {
                        dogruluk = 1;
                        do {
                            try {
                                System.out.println("enter your ID to update your last name");
                                ID = Integer.parseInt(input.nextLine());
                                dogruluk = 2;
                            } catch (NumberFormatException e) {
                                System.out.println("You entered non valid number\nEnter again please");
                            }
                        } while (dogruluk == 1);
                        System.out.println("Enter new last name");
                        String newLastName = input.nextLine();
                        Bank.updateCostumerLastName(ID, newLastName);
                    } else if (secenek == 3) {
                        dogruluk = 1;
                        do {
                            try {
                                System.out.println("enter your ID to update your gender");
                                ID = Integer.parseInt(input.nextLine());
                                dogruluk = 2;
                            } catch (NumberFormatException e) {
                                System.out.println("You entered non valid number\nEnter again please");
                            }
                        } while (dogruluk == 1);
                        
                        System.out.println("Enter new gender");
                        String newGender = input.nextLine();
                        Bank.updateCostumerGender(ID, newGender);
                    }
                } while (secenek != 0);

            } else if (number == 5) {
                do {
                    try {
                        System.out.println("enter your ID which you want adding money");
                        ID = Integer.parseInt(input.nextLine());
                        dogruluk = 2;
                    } catch (NumberFormatException e) {
                        System.out.println("You entered non valid number\nEnter again please");
                    }
                } while (dogruluk == 1);
                do{
                try{
                    System.out.println("How much money do you want to add to your account?");
                    money = Double.parseDouble(input.nextLine());
                    dogruluk = 2;
                }catch(NumberFormatException e){
                       System.out.println("You entered non valid number\nPlease enter again.");
                               
                }
                }while(dogruluk == 1);
                Bank.addingMoney(ID, money);
            
            } else if (number == 6) {
                do {
                    try {
                        System.out.println("enter your ID which you want to draw money");
                        ID = Integer.parseInt(input.nextLine());
                        dogruluk = 2;
                    } catch (NumberFormatException e) {
                        System.out.println("You entered non valid number\nEnter again please");
                    }
                } while (dogruluk == 1);
               
                
                Bank.drawingMoney(ID); 
           
            } else if (number == 7) {
                 dogruluk = 1;
                do {
                    try {
                        System.out.println("Enter your ID");
                        ID = Integer.parseInt(input.nextLine());
                        dogruluk = 2;
                    } catch (NumberFormatException e) {
                        System.out.println("You entered non valid number\nEnter again please");
                    }
                } while (dogruluk == 1);
                 dogruluk = 1;
                do {
                    try {
                        System.out.println("Enter the ID you want to transfere money!!!");
                        ID1 = Integer.parseInt(input.nextLine());
                        dogruluk = 2;
                    } catch (NumberFormatException e) {
                        System.out.println("You entered non valid number\nEnter again please");
                    }
                } while (dogruluk == 1);
               
                Bank.transfereMoney(ID, ID1);
            }

        } while (number != 0);
        System.out.println("You are out now\nBye Bye.");
  
    }
  
    // out of main method
    
    static int control(int ID) {

        Scanner input = new Scanner(System.in);
        Iterator<Customer> it = Customer.customers.iterator();  
        int a = 0;
        while (it.hasNext()) {

            Customer c = it.next();

            if (ID == c.getCustomerId()) {
                a = 1;
            }
        }

        return a;
    }

}
