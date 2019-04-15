/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theBankSimulation;

//import static java.rmi.Naming.list;
import java.util.ArrayList;
//import static java.util.Collections.list;
import java.util.Iterator;
import java.util.Random;
//import java.util.List;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Bank{

    static Scanner input = new Scanner(System.in);

    static void AddCustomer(int customerID, String name, String lastName, String gender, double credit) {

        int ID;
        Random rand = new Random();
        int randomNumber;

        while (true){
        randomNumber = rand.nextInt(9999) + 1000;
        if (control(randomNumber)) {
            ID = randomNumber;
            break;
        }

    }
        Customer.customers.add(new Customer(customerID, name, lastName, gender, credit));
        System.out.println("New customer with the ID : " + ID + " has been added.");

    }

    static boolean control(int ID) {
        Iterator<Customer> it = Customer.customers.iterator();
        boolean isAvailable = true;
        while (it.hasNext()) {
            Customer customers = it.next();

            if (ID == customers.getCustomerId()) {
                isAvailable = false;
            }
        }

        return isAvailable;

}

    static public void deletingCostumerById(int ID) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();
            if (t.getCustomerId() == ID) {
                it.remove();
            }
        }
    }

    static public String listAllCostumer() {

        String temp = "";
        for (Customer i : Customer.customers) {

            temp += "\nCostumer ID :" + i.getCustomerId() + "\n";
            temp += "Name :" + i.getName() + "\n";
            temp += "Last name :" + i.getLastName() + "\n";
            temp += "gender :" + i.getGender() + "\n";
            temp += "credit :" + i.getCredit() + "\n\n";

        }
        return temp;
    }

    static public String listCostumerByID(int ID) {

        String temp = "";
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();
            if (t.getCustomerId() == ID) {
                temp += "\nCostumer ID :" + t.getCustomerId() + "\n";
                temp += "Name        :" + t.getName() + "\n";
                temp += "Last name   :" + t.getLastName() + "\n";
                temp += "Gender      :" + t.getGender() + "\n";
                temp += "Credit      :" + t.getCredit() + "\n\n";

            }
        }
        return temp;
    }

    static public String listCostumersEnteredName() {
        int x = 1;
        String temp = "";
        System.out.println("Enter the name you are searching");
        String name = input.nextLine();
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();
            do {

                if (t.getName().equals(name)) {
                    temp += "\nCostumer ID :" + t.getCustomerId() + "\n";
                    temp += "Name        :" + t.getName() + "\n";
                    temp += "Last name   :" + t.getLastName() + "\n";
                    temp += "Gender      :" + t.getGender() + "\n";
                    temp += "Credit      :" + t.getCredit() + "\n\n";
                    x = 2;
                } else if (!t.getName().equals(name)) {
                    System.out.println("There is no one whith (" + name + ") name.");
                    break;
                }
            } while (x == 1);
        }

        return temp;
    }

    static public String listCostumersEnteredLastName() {
        int x = 1;
        String temp = "";
        System.out.println("Enter the last name you are searching");
        String lastName = input.nextLine();
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();
            do {

                if (t.getLastName().equals(lastName)) {
                    temp += "\nCostumer ID :" + t.getCustomerId() + "\n";
                    temp += "Name        :" + t.getName() + "\n";
                    temp += "Last name   :" + t.getLastName() + "\n";
                    temp += "Gender      :" + t.getGender() + "\n";
                    temp += "Credit      :" + t.getCredit() + "\n\n";
                    x = 2;
                } else if (!t.getName().equals(lastName)) {
                    System.out.println("There is no one whith (" + lastName + ") lastName.");
                   break;
                }
            } while (x == 1);
        }

        return temp;
    }

    static public String listCostumersByGender() {
        int a = 1;
        String gender = "";
        String temp = "";
        do {
            System.out.println("Enter the gender you are searching 'Male' or 'Female'.");
            gender = input.nextLine();
            if (gender.equals("Male") || gender.equals("Female") || gender.equals("female") || gender.equals("male")) {
                a = 2;
            }
            System.out.println("You entered non valid gender");

        } while (a == 1);

        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();

            if (t.getGender().equals(gender)) {
                temp += "\nCostumer ID :" + t.getCustomerId() + "\n";
                temp += "Name        :" + t.getName() + "\n";
                temp += "Last name   :" + t.getLastName() + "\n";
                temp += "Gender      :" + t.getGender() + "\n";
                temp += "Credit      :" + t.getCredit() + "\n\n";

            }
        }
        return temp;

    }

    public static void updateCostumerName(double ID, String name) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();
            if (ID == t.getCustomerId()) {
                t.setName(name);
            }

        }

    }

    public static void updateCostumerLastName(int ID, String lastName) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();
            if (ID == t.getCustomerId()) {
                t.setLastName(lastName);
            }

        }

    }

    public static void updateCostumerGender(int ID, String gender) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();
            if (ID == t.getCustomerId()) {
                t.setGender(gender);
            }

        }

    }

    public static void updateCostumerCredit(int ID, double credit) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();
            if (ID == t.getCustomerId()) {
                t.setCredit(credit);
            }

        }

    }

    static public void addingMoney(int ID, double amount) {
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();
            if (ID == t.getCustomerId()) {
                t.setCredit(t.getCredit() + amount);
                System.out.println("\n**Successfully\n**");

            }
        }
    }

    static public void drawingMoney(int ID) {
        int dogruluk = 1;
        double amount = 0;
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();
            if (ID == t.getCustomerId()) {

                int a = 1;
                do {
                    do {
                        try {
                            System.out.println("How much money do you want to draw from your account?");
                            amount = Double.parseDouble(input.nextLine());
                            dogruluk = 2;
                        } catch (NumberFormatException e) {
                            System.out.println("You entered non valid number\nPlease enter again.");

                        }
                    } while (dogruluk == 1);
                    if (amount < t.getCredit()) {
                        t.setCredit(t.getCredit() - amount);
                        System.out.println("\n**Successfully**\n");
                        a = 2;
                    } else {
                        System.out.println("you must entered less then " + t.getCredit() + "\ndo it again");

                    }

                } while (a == 1);

            }

        }
    }

    static public void transfereMoney(int ID, int ID1) {
        int dogruluk = 1;
        int a = 1;
        double amount = 0;
        Iterator<Customer> it = Customer.customers.iterator();
        while (it.hasNext()) {
            Customer t = it.next();
            if (ID == t.getCustomerId()) {
                do {
                    dogruluk = 1;

                    do {
                        try {
                            System.out.println("Now enter the amount You want to transfere!!!");
                            amount = Double.parseDouble(input.nextLine());

                            dogruluk = 2;
                        } catch (NumberFormatException e) {
                            System.out.println("You entered non valid number\nEnter again please");

                        }
                    } while (dogruluk == 1);
                    if (amount <= t.getCredit()) {

                        t.setCredit(t.getCredit() - amount);
                        a = 2;
                    } else {
                        System.out.println("You credit is = " + t.getCredit() + "\nYou cant transfere!!!");
                    }
                } while (a == 1);

            }
        }
        Iterator<Customer> ite = Customer.customers.iterator();
        while (ite.hasNext()) {
            Customer t = ite.next();
            if (ID1 == t.getCustomerId()) {
                t.setCredit(t.getCredit() + amount);
            }

        }
        System.out.println("\n**Successfully \n**");

    }

}
