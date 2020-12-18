/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oems;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;


class ServiceAndRepairUser {
     private int Job_No,Equipment_ID;
    private String Service_Date,Transection_Code,Value,Seivice_Description,Suppier_Name,Location_Name;

  
    
    public ServiceAndRepairUser(int Job_No, String Service_Date, String Service_Category,String Value,String Seivice_Description,String Suppier_Name,int Equipment_ID,String Location_Name){
        this.Job_No=Job_No;
        this.Service_Date=Service_Date;
        this.Transection_Code=Service_Category;
        this.Value=Value;
        this.Seivice_Description=Seivice_Description;
        this.Suppier_Name=Suppier_Name;
        this.Equipment_ID=Equipment_ID;
        this.Location_Name=Location_Name;
    } 

    public int getJob_No(){
        return Job_No;
    }
    public String getService_Date(){
        return Service_Date;
    }
    public String getService_Category(){
        return Transection_Code;
    }
    public String getValue(){
        return Value;
    }
    public String getSeivice_Description(){
        return Seivice_Description;
    }
    public String getSuppier_Name(){
        return Suppier_Name;
    }
    public int getEquipment_ID(){
        return Equipment_ID;
    }    
   
    public String getLocation_Name(){
        return Location_Name;
   
}
}