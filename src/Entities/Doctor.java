/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author User
 */
public class Doctor {
    private int Id;
    private String firstName;
    private String lastName;
    private int phone;
    private String location;
    private String title;
    
    public Doctor(){
        
    }
    public Doctor(int Id, String firstName, String lastName, int phone, String location, String title) {
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.location = location;
        this.title = title;
    }
    public Doctor(Doctor d){
        this.Id = d.Id;
        this.firstName = d.firstName;
        this.lastName = d.lastName;
        this.phone = d.phone;
        this.location = d.location;
        this.title = d.title;
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

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }
  
}
