/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theBankSimulation;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Customer {

	
	public static ArrayList<Customer> customers = new ArrayList<>();
	
    private int customerID;
    private String name;
    private String lastName;
    private String gender;
    private double credit;

    public Customer(int customerID, String name, String lastName, String gender, double credit) {
        this.customerID = customerID;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.credit = credit;
    }

    public int getCustomerId() {
        return this.customerID;
    }

    public void setCustomerId(int newCustomerId) {
        this.customerID = newCustomerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String newGender) {
        this.gender = newGender;
    }

    public double getCredit() {
        return this.credit;
    }

    public void setCredit(double newCredit) {
        this.credit = newCredit;
    }

}
