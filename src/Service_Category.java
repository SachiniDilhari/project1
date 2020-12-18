
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sachini
 */
public class Service_Category extends javax.swing.JFrame {

    /**
     * Creates new form Service_Category
     */
    public Service_Category() {
        initComponents();
        show_user();
    }
        public ArrayList<CategoryUser>userList(){
      ArrayList<CategoryUser> userList = new ArrayList<>();
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM Service_Category_Table";
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(query1);
            CategoryUser categoryuser;
            
            while(rs.next()){
                categoryuser = new CategoryUser(rs.getString("Category_Definition"));
                userList.add(categoryuser);
                
            }
        
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList;
    }
    public void show_user(){
        ArrayList<CategoryUser> list = userList();
        DefaultTableModel model = (DefaultTableModel)Category_Table.getModel();
        Object[] row = new Object[1];
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getCategory_Definition();
            
            model.addRow(row);
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Btn_Delete = new javax.swing.JButton();
        Btn_Save = new javax.swing.JButton();
        Btn_Update = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        Txt_CategoryID = new javax.swing.JTextField();
        Txt_Category = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Category_Table = new javax.swing.JTable();
        Txt_Category_Search = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        lbl_Category = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Add Service Category");

        jLabel3.setText("Category ID");

        jLabel4.setText("Category ");

        Btn_Delete.setText("Delete");
        Btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_DeleteActionPerformed(evt);
            }
        });

        Btn_Save.setText("Save");
        Btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_SaveActionPerformed(evt);
            }
        });

        Btn_Update.setText("Update");
        Btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_UpdateActionPerformed(evt);
            }
        });

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        Txt_CategoryID.setEnabled(false);

        Category_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Definition"
            }
        ));
        Category_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Category_TableMouseClicked(evt);
            }
        });
        Category_Table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Category_TableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Category_Table);

        Txt_Category_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Txt_Category_SearchKeyReleased(evt);
            }
        });

        jLabel5.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Btn_Save, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Delete)
                                        .addGap(18, 18, 18)
                                        .addComponent(Btn_Update)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Txt_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Txt_CategoryID, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Txt_Category_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Txt_CategoryID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Txt_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(lbl_Category)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Txt_Category_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Save)
                            .addComponent(Btn_Delete)
                            .addComponent(Btn_Update)
                            .addComponent(jButton4)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         Txt_CategoryID.setText("");
             Txt_Category.setText("");
             Txt_Category_Search.setText("");
    }//GEN-LAST:event_jButton4ActionPerformed

    private void Btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_SaveActionPerformed
        
         String name = Txt_Category.getText();
        
                
        
        
        if(Txt_Category.getText().trim().isEmpty() ){
         lbl_Category.setText(" Category is Empty....!");
         
     }
     else if (Txt_Category.getText().trim().isEmpty()){
         lbl_Category.setText("Category is Empty....!");
     }
     else
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            Statement stat = con.createStatement();
            String selectQuery = "select Category_Definition from Service_Category_Table where Category_Definition='" + name + "'";
            ResultSet rs = stat.executeQuery(selectQuery);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Already registered");
                return;
            }
            else
{
    
               
            String query = "insert into Service_Category_Table(Category_Definition)values(?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,Txt_Category.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)Category_Table.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Save sucessfully");
               
            }
               
        }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
            Txt_CategoryID.setText("");
            Txt_Category.setText("");
            Txt_Category_Search.setText("");
           
            
    }//GEN-LAST:event_Btn_SaveActionPerformed

    private void Btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_DeleteActionPerformed
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query = "DELETE FROM Service_Category_Table where Category ID =?";
            
            PreparedStatement pst = con.prepareStatement(query);
 
            pst.setString(1,Txt_CategoryID.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)Category_Table.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Deleted sucessfully");
            
            Txt_CategoryID.setText("");
            Txt_Category.setText("");
            Txt_Category_Search.setText("");
            
           
        
        }
        catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }                                        
    }//GEN-LAST:event_Btn_DeleteActionPerformed

    private void Txt_Category_SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txt_Category_SearchKeyReleased
       try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String sql = "select * from Service_Category_Table where Category_Definition = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Txt_Category_Search.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String setCategory_Definition =rs.getString("Category_Definition");
                Txt_Category.setText(setCategory_Definition);
                
                String setCategory_ID =rs.getString("Category_ID");
                Txt_CategoryID.setText(setCategory_ID);
                
            }
             
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }    
       
    }//GEN-LAST:event_Txt_Category_SearchKeyReleased

    private void Btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_UpdateActionPerformed
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
           /* int row = DisplayUserDetails.getSelectedRow();
            String value = (DisplayUserDetails.getModel().getValueAt(row, 0).toString());*/
            String query = "UPDATE Service_Category_Table SET Category_Definition = ? where Category_ID =?";
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,Txt_Category.getText());
            
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)Category_Table.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Update sucessfully");
            
            
            }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
               
             Txt_CategoryID.setText("");
             Txt_Category.setText("");
             Txt_Category_Search.setText("");
         
                                                    
                                      
    }//GEN-LAST:event_Btn_UpdateActionPerformed

    private void Category_TableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Category_TableKeyReleased
        
    }//GEN-LAST:event_Category_TableKeyReleased

    private void Category_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Category_TableMouseClicked
        int i = Category_Table.getSelectedRow();
        TableModel model = Category_Table.getModel();
        Txt_Category.setText(model.getValueAt(i, 0).toString());
       
        boolean a = Category_Table.isEditing();
        
        if(a==false){
            JOptionPane.showMessageDialog(null, "You can not edit this table ");
            
        }
    }//GEN-LAST:event_Category_TableMouseClicked

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
            java.util.logging.Logger.getLogger(Service_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Service_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Service_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Service_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Service_Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Delete;
    private javax.swing.JButton Btn_Save;
    private javax.swing.JButton Btn_Update;
    private javax.swing.JTable Category_Table;
    private javax.swing.JTextField Txt_Category;
    private javax.swing.JTextField Txt_CategoryID;
    private javax.swing.JTextField Txt_Category_Search;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_Category;
    // End of variables declaration//GEN-END:variables
}
