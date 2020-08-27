/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author User
 */
public class Client {
    
    private int Id;
    private String firstName;
    private String lastName;
    private int phone;
    private String location;
    private List<Order> listOrders = new ArrayList();
    
    public Client(int Id, String firstName, String lastName, int phone, String location) {
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.location = location;
    }
    public Client(){
        
    }
    public Client(Client c){
        this.Id = c.Id;
        this.firstName = c.firstName;
        this.lastName = c.lastName;
        this.phone = c.phone;
        this.location = c.location;
    }

    public int getId() {
        return Id;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public Order getOrderById(int Id){
        //todo
        return null;
    }
    
    public List getAllOrders(){
        //todo
        return null;
    }
    
    
    
}
