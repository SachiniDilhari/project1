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
class PreventiveServiceUser {
    private int Job_No, Equipment_ID;
    private String Service_Date, Service_catagory,Value_Of_Service;
     
  
  public PreventiveServiceUser(int Job_No,String Service_Date,String Value_Of_Service, String Service_catagory,int Equipment_ID){
        this.Job_No=Job_No;
        this.Service_Date=Service_Date;
        this.Value_Of_Service=Value_Of_Service;
        this.Service_catagory=Service_catagory;
        this.Equipment_ID=Equipment_ID;
  
  }
    public int getJob_No(){
        return Job_No;
    }    
    public String getService_Date(){
        return Service_Date;
    }
    public String getValue_Of_Service(){
        return Value_Of_Service;
    }
   
    public String getService_catagory(){
        return Service_catagory;
    }
     public int getEquipment_ID(){
        return Equipment_ID;
    }
      
}
