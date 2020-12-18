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
class LocationUser {
      private String Location_Name, Project_Name,Coordinator_Name;
  
    public LocationUser(String Location_Name, String Project_Name,String Coordinator_Name){
        this.Location_Name=Location_Name;
        this.Project_Name = Project_Name;
        this.Coordinator_Name = Coordinator_Name;
        
    } 

   public String getLocation_Name(){
        return Location_Name;
    }

    public String getProject_Name(){
        return Project_Name;
    }
    public String getCoordinator_Name(){
        return Coordinator_Name;
    }
   
            
            
         
}

  