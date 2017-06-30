package com.example.jms.jmsdemo;

import java.io.Serializable;

/**
 * Created by gkaur on 30/06/2017.
 */
public class UserDetails implements Serializable{

    public UserDetails(String firstName, String lastName, String cellPhoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cellPhoneNumber = cellPhoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cellPhoneNumber='" + cellPhoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    String firstName;
    String lastName;
    String cellPhoneNumber;
    String address;


}
