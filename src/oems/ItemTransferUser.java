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
class ItemTransferUser {
     private int  Equipment_ID;
    private String Transfered_Date, Location_Name;
    
    public ItemTransferUser( String Transfered_Date, int Equipment_ID,String Location_Name){
        
        this.Equipment_ID=Equipment_ID;
        this.Transfered_Date=Transfered_Date;
        this.Location_Name=Location_Name;
        
    } 

    
     
    public String getTransfered_Date(){
        return Transfered_Date;
    }
    public int getEquipment_ID(){
        return Equipment_ID;
    }
    
     public String getLocation_Name(){
        return Location_Name;
    }
   
}
