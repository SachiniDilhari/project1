/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author sachini
 */
public class Project_Manager extends javax.swing.JFrame {

    /**
     * Creates new form Project_Manager
     */
    public Project_Manager() {
        initComponents();
        show_user();
       
        
    }
        
    
    //...................Get Value from Database...................//
   // Bytes = (SELECT MAX(Bytes) FROM tracks);
    public ArrayList<ProUser>userList(){
      ArrayList<ProUser> userList = new ArrayList<>();
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM Project_Reg_Table";
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(query1);
            ProUser prouser;
            while(rs.next()){
                prouser=new ProUser(rs.getString("Project_Name"),rs.getString("Project_Manager"));
                userList.add(prouser);
                
            }
      
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList;
    }
    public void show_user(){
        ArrayList<ProUser> list = userList();
        DefaultTableModel model = (DefaultTableModel)pro_Ma_Table.getModel();
        Object[] row = new Object[2];
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getProject_Name();
            row[1]=list.get(i).getProject_Manager();
            
            model.addRow(row);
        }
        
    }
            
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtSearch = new javax.swing.JTextField();
        TxtPro_Manager = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BtnCancel = new javax.swing.JButton();
        BtnSave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pro_Ma_Table = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TxtProjectName1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtProjectID1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("<-----");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Registration Project Manager");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Project Name           :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Manager Manager     :");

        BtnCancel.setText("Cancel");

        BtnSave.setText("Save");
        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        pro_Ma_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Project Name", "Project Manger"
            }
        ));
        pro_Ma_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pro_Ma_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pro_Ma_Table);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Project ID                :");

        TxtProjectName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtProjectName1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Search                               :");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("<-----");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(BtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(57, 57, 57)
                                                .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(TxtProjectID1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(TxtPro_Manager, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(TxtProjectName1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtProjectID1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtProjectName1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtPro_Manager, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed
        String name = TxtProjectName1.getText();

        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            Statement stat = con.createStatement();
            String selectQuery = "select Project_Name from Project_Reg_Table where Project_Name='" + name + "'";
            ResultSet rs = stat.executeQuery(selectQuery);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Already registered");
                return;
            }
            else
            {
    
               
               
            String query = "insert into Project_Reg_Table(Project_Name, Project_Manager)values(?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,TxtProjectName1.getText());
            pst.setString(2,TxtPro_Manager.getText());
//            pst.setString(3,TxtProjectID.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)pro_Ma_Table.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Save sucessfully");
               
               
               
            }
               
            

            
            
            
        }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
            TxtProjectName1.setText("");
            TxtPro_Manager.setText("");
            TxtProjectID1.setText("");
            txtSearch.setText("");
        
        
                                             

    
    }//GEN-LAST:event_BtnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
           /* int row = DisplayUserDetails.getSelectedRow();
            String value = (DisplayUserDetails.getModel().getValueAt(row, 0).toString());*/
            String query = "UPDATE Project_Reg_Table SET Project_Name = ?,Project_Manager = ? where ProjectID = ?";
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,TxtProjectName1.getText());
            pst.setString(2,TxtPro_Manager.getText());
            pst.setString(3,TxtProjectID1.getText());
            
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)pro_Ma_Table.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Update sucessfully");
            
            
            }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
               
            TxtProjectName1.setText("");
            TxtPro_Manager.setText("");
            TxtProjectID1.setText("");
            txtSearch.setText("");
                 
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void pro_Ma_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pro_Ma_TableMouseClicked
        int i = pro_Ma_Table.getSelectedRow();
        TableModel model = pro_Ma_Table.getModel();
        TxtProjectName1.setText(model.getValueAt(i, 0).toString());
        TxtPro_Manager.setText(model.getValueAt(i, 1).toString());
        
        boolean a = pro_Ma_Table.isEditing();
        
        if(a==false){
            JOptionPane.showMessageDialog(null, "You can not edit this table ");
            
        }
    }//GEN-LAST:event_pro_Ma_TableMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query = "DELETE FROM Project_Reg_Table where ProjectID =?";
            
            PreparedStatement pst = con.prepareStatement(query);
 
            pst.setString(1,TxtProjectID1.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)pro_Ma_Table.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Deleted sucessfully");
            
            TxtProjectName1.setText("");
            TxtPro_Manager.setText("");
            TxtProjectID1.setText("");
            txtSearch.setText("");
        }
        catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }                                         
    
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
         
    }//GEN-LAST:event_formComponentShown

    private void TxtProjectName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtProjectName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtProjectName1ActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
       try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String sql = "select * from Project_Reg_Table where Project_Name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, txtSearch.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String setProject_Name =rs.getString("Project_Name");
                TxtProjectName1.setText(setProject_Name);
                
                String setProjectID =rs.getString("ProjectID");
                TxtProjectID1.setText(setProjectID);
                
                String setProject_Manager=rs.getString("Project_Manager");
                TxtPro_Manager.setText(setProject_Manager);
                
                
            }
             
             
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }                   
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Admin field=new Admin();
                field.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Project_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Project_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Project_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Project_Manager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Project_Manager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCancel;
    private javax.swing.JButton BtnSave;
    private javax.swing.JTextField TxtPro_Manager;
    private javax.swing.JTextField TxtProjectID1;
    private javax.swing.JTextField TxtProjectName1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable pro_Ma_Table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
