/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

class PS_Report {
   
    private String Job_No, Service_Date,Service_catagory,Equipment_ID,Equipment_Name,Location,Value_Of_Service;
     
  
  public PS_Report(String Job_No,String Service_Date,String Service_catagory, String Equipment_ID,String Equipment_Name,String Location,String Value_Of_Service){
        this.Job_No=Job_No;
        this.Service_Date=Service_Date;
        this.Service_catagory=Service_catagory;
        this.Equipment_ID=Equipment_ID;
        this.Equipment_Name=Equipment_Name;
        this.Location=Location;
        this.Value_Of_Service=Value_Of_Service;

        
  }
    public String getJob_No(){
        return Job_No;
    }    
    public String getService_Date(){
        return Service_Date;
    }
    public String getService_catagory(){
        return Service_catagory;
    }
   
    public String getEquipment_ID(){
        return Equipment_ID;
    }
     public String getEquipment_Name(){
        return Equipment_Name;
    }
     public String getLocation(){
        return Location;
    }
     public String getValue_Of_Service(){
        return Value_Of_Service;
    }
 
}
