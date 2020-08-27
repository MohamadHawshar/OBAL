/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author User
 */
public class Bill {
    private int Id;
    private Date date;
    
    public Bill(){
        
    }
    
    public Bill(Bill b){
        this.Id = b.Id;
        this.date = b.date;
    }
    public Bill(int Id, Date date) {
        this.Id = Id;
        this.date = date;
    }

    public int getId() {
        return Id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
