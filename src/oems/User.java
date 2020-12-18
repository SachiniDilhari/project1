/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oems;

/**
 *
 * @author sachini
 */
class User {
    private int EPFNo, UserID;
    private String UserName, Password,UserType;
    
    public User(int EPFNo, String UserName, String Password,String UserType){
        this.UserID=UserID;
        this.UserName=UserName;
        this.EPFNo=EPFNo;
        this.Password=Password;
        this.UserType=UserType;
    } 

  
     public int getUserID(){
        return UserID;
    }    
    
    public int getEPFNo(){
        return EPFNo;
    }
    public String getUserName(){
        return UserName;
    }
     public String getPassword(){
        return Password;
    }
    public String getUserType(){
        return UserType;
    }
            
            
            
            
            
       
}
