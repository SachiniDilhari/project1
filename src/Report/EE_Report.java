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
class EE_Report {
    private String EquipmentID,Equipment_Name,Location,Supplier,Value,PurchasDate;
    
    public EE_Report(String EquipmentID,String Equipment_Name,String Value,String PurchasDate, String Location,String Supplier){
        this.EquipmentID = EquipmentID;
        this.Equipment_Name = Equipment_Name;
        this.Value = Value;
        this.PurchasDate = PurchasDate;
        this.Location = Location;
        this.Supplier = Supplier;
       
    } 

   public String getEquipmentID(){
        return EquipmentID;
    }    
    
     public String getEquipment_Name(){
        return Equipment_Name;
    }    
     public String getValue(){
        return Value;
    }
     public String getPurchasDate(){
        return PurchasDate;
    }
    public String getLocation(){
        return Location;
    }
    public String getSupplier(){
        return Supplier;
    }
     
    
}
