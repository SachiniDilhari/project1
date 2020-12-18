
package Report;

class RepairReport {
    
    private String Job_No,Service_Date, Transection_Code,Value,Seivice_Description,Suppier_Name,Equipment_ID,Location_Name,Project_Name,Address;
    
    public RepairReport(String Job_No, String Service_Date, String Transection_Code, String Value,String Seivice_Description,String Suppier_Name,String Equipment_ID,String Location_Name,String Project_Name,String Address ){
        this.Job_No=Job_No;
        this.Service_Date=Service_Date;
        this.Transection_Code=Transection_Code;
        this.Value=Value;
        this.Seivice_Description=Seivice_Description;
        this.Suppier_Name=Suppier_Name;
        this.Equipment_ID=Equipment_ID;
        this.Location_Name=Location_Name;
        this.Project_Name=Project_Name;
        this.Address=Address;
        
    }
     public String getJob_No(){
        return Job_No;
    }    
    public String getService_Date(){
        return Service_Date;
    }
    public String getTransection_Code(){
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
     public String getEquipment_ID(){
        return Equipment_ID;
    }
     public String getLocation_Name(){
        return Location_Name;
    }
     public String getProject_Name(){
        return Project_Name;
    }
     public String getAddress(){
        return Address;
    }
}

    
