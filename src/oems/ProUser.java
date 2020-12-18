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
class ProUser {
   
    private String Project_Name, Project_Manager;
  
    public ProUser(String Project_Name, String Project_Manager){
        this.Project_Name=Project_Name;
        this.Project_Manager=Project_Manager;
        
    } 

  
   

    public String getProject_Name(){
        return Project_Name;
    }
    public String getProject_Manager(){
        return Project_Manager;
    }
   
            
            
            
}
