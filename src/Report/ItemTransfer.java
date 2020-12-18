/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 *
 * @author sachini
 */
class ItemTransfer {
    private String Job_No,Equipment_ID,Equipment_Name,Transfered_Date,Location_Name;
    
    public ItemTransfer(String Job_No,String Equipment_ID,String Equipment_Name,String Transfered_Date,String Location_Name){
        this.Job_No=Job_No;
        this.Equipment_ID=Equipment_ID;
        this.Equipment_Name=Equipment_Name;
        this.Transfered_Date=Transfered_Date;
        this.Location_Name=Location_Name;  
    } 

     public String getJob_No(){
        return Job_No;
    }    
     public String getEquipment_ID(){
        return Equipment_ID;
    }
     public String getEquipment_Name(){
        return Equipment_Name;
    }
     
    public String getTransfered_Date(){
        return Transfered_Date;
    }
   
     public String getLocation_Name(){
        return Location_Name;
    }
  
}
