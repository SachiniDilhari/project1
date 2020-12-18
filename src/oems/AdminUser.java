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
class AdminUser {
   
 
    private String Sup_Name, Contact_No,BankDetails,Address;
    
    public AdminUser(String Sup_Name, String Contact_No, String BankDetails,String Address){
        this.Sup_Name=Sup_Name;
        this.Contact_No=Contact_No;
        this.BankDetails=BankDetails;
        this.Address=Address;
    } 
   
   
     public String getSup_Name(){
        return Sup_Name;
    }    
    
    public String getContact_No(){
        return Contact_No;
    }
    public String getBankDetails(){
        return BankDetails;
    }
     public String getAddress(){
        return Address;
    }
}
