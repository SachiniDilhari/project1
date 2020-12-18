package oems;
import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.management.Query.value;
import static javax.management.Query.value;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

        
public class UserRegister extends javax.swing.JFrame {
    String gender;
    
    
            
    public UserRegister() {
        initComponents();
        show_user();
        
    }
    //...................Get Value from Database...................//
   // Bytes = (SELECT MAX(Bytes) FROM tracks);
    public ArrayList<User>userList(){
      ArrayList<User> userList = new ArrayList<>();
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM Login";
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(query1);
            User user;
            while(rs.next()){
                user=new User(rs.getInt("EPFNo"), rs.getString("Name"),rs.getString("Password"), rs.getString("UserType"));
                userList.add(user);
                
            }
            
            
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList;
    }
    public void show_user(){
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel)DisplayUserDetails.getModel();
        Object[] row = new Object[4];
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getEPFNo();
            row[1]=list.get(i).getUserName();
            row[2]=list.get(i).getPassword();
            row[3]=list.get(i).getUserType();
           // row[3]=list.get(i).getUserID();
            model.addRow(row);
        }
        
    }
            
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jMenuItem1 = new javax.swing.JMenuItem();
        jButton4 = new javax.swing.JButton();
        label1 = new java.awt.Label();
        EpfNo = new java.awt.Label();
        label3 = new java.awt.Label();
        textField2 = new java.awt.TextField();
        TxtEPFNo = new java.awt.TextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        URCancelbtn = new java.awt.Button();
        URSavebtn = new java.awt.Button();
        btnReset = new java.awt.Button();
        label4 = new java.awt.Label();
        TxtURName1 = new java.awt.TextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayUserDetails = new javax.swing.JTable();
        Search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new java.awt.Button();
        Update = new java.awt.Button();
        TxtUserID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lbl_EPFNo = new javax.swing.JLabel();
        lbl_Name = new javax.swing.JLabel();
        label5 = new java.awt.Label();
        CombUserType = new javax.swing.JComboBox<>();
        TxtUserType = new javax.swing.JTextField();
        lbl_Password = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMenuItem1.setText("jMenuItem1");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("<-----");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label1.setText("User Registration");

        EpfNo.setText("EPF NO");

        label3.setText("Password");

        textField2.setText("textField1");

        TxtEPFNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtEPFNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtEPFNoKeyReleased(evt);
            }
        });

        jPasswordField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordField1KeyReleased(evt);
            }
        });

        URCancelbtn.setLabel("Cancel");
        URCancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                URCancelbtnActionPerformed(evt);
            }
        });

        URSavebtn.setLabel("Save");
        URSavebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                URSavebtnActionPerformed(evt);
            }
        });

        btnReset.setLabel("Reset");
        btnReset.setName("Reset"); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        label4.setText("Name");

        TxtURName1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtURName1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtURName1KeyReleased(evt);
            }
        });

        DisplayUserDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "EPF No", "UserName", "Password", "UserType"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DisplayUserDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DisplayUserDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DisplayUserDetails);
        if (DisplayUserDetails.getColumnModel().getColumnCount() > 0) {
            DisplayUserDetails.getColumnModel().getColumn(0).setResizable(false);
            DisplayUserDetails.getColumnModel().getColumn(1).setResizable(false);
        }

        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });
        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchKeyReleased(evt);
            }
        });

        jLabel1.setText("Search");

        btnDelete.setLabel("Delete Account");
        btnDelete.setName("Reset"); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        Update.setLabel("Update");
        Update.setName("Reset"); // NOI18N
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        TxtUserID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUserIDActionPerformed(evt);
            }
        });
        TxtUserID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtUserIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtUserIDKeyReleased(evt);
            }
        });

        jLabel2.setText("User ID");

        lbl_EPFNo.setForeground(new java.awt.Color(255, 0, 0));

        lbl_Name.setForeground(new java.awt.Color(255, 0, 0));

        label5.setText("User Type");

        CombUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Assistant", "Manager" }));
        CombUserType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombUserTypeActionPerformed(evt);
            }
        });

        lbl_Password.setForeground(new java.awt.Color(204, 0, 0));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("<-----");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TxtURName1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                .addComponent(jPasswordField1))
                            .addComponent(CombUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtUserType, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(EpfNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_EPFNo, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TxtEPFNo, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                            .addComponent(TxtUserID)
                                            .addComponent(Search)))))
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(URSavebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(URCancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton5))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(164, 164, 164)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(862, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton5)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EpfNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtEPFNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_EPFNo)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtURName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Password, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(CombUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(URSavebtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(URCancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(144, 144, 144)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(446, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(1104, 637));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
        //...............data to Databse.............//
    private void URSavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_URSavebtnActionPerformed
     
        String name = TxtURName1.getText();
        String epfno = TxtEPFNo.getText();
        String password = jPasswordField1.getText();
                
        
        
        if(TxtURName1.getText().trim().isEmpty() && jPasswordField1.getText().trim().isEmpty() && TxtEPFNo.getText().trim().isEmpty()){
         lbl_EPFNo.setText("EPF No is Empty....");
         lbl_Name.setText("User name is Empty....");
         lbl_Password.setText("Password is Empty....");
     }
     else if (TxtURName1.getText().trim().isEmpty()){
         lbl_Name.setText("User name is Empty....");
     }
     else if (jPasswordField1.getText().trim().isEmpty()){
         lbl_Password.setText("Password is Empty....");
     }
     else if (TxtEPFNo.getText().trim().isEmpty()){
         lbl_EPFNo.setText("EPF No is Empty....");
     } 
     else
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            Statement stat = con.createStatement();
            String selectQuery = "select Name from Login where Name='" + name + "'";
            ResultSet rs = stat.executeQuery(selectQuery);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Already registered");
                return;
            }
            else
            {
    
            String query = "insert into Login(Name,Password, EPFNo, UserType)values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,TxtURName1.getText());
            pst.setString(2,jPasswordField1.getText());
            pst.setString(3,TxtEPFNo.getText());
            pst.setString(4,TxtUserType.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)DisplayUserDetails.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Save sucessfully");
            } 
        }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);  
         }
            TxtURName1.setText("");
            jPasswordField1.setText("");
            TxtEPFNo.setText("");
            TxtUserID.setText("");
            Search.setText("");   
            TxtUserType.setText("");    
    }//GEN-LAST:event_URSavebtnActionPerformed

    private void URCancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_URCancelbtnActionPerformed
        this.dispose();    
    }//GEN-LAST:event_URCancelbtnActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        
        TxtURName1.setText("");
        jPasswordField1.setText("");
        TxtEPFNo.setText("");
        TxtUserID.setText("");
        Search.setText("");
        TxtUserType.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyReleased
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String sql = "select * from Login where Name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, Search.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String setEPF =rs.getString("EPFNo");
                TxtEPFNo.setText(setEPF);
                
                String setName =rs.getString("Name");
                TxtURName1.setText(setName);
                
                String setPassword =rs.getString("Password");
                jPasswordField1.setText(setPassword);
                
                String setUserID =rs.getString("UserID");
                TxtUserID.setText(setUserID);
                
                String setUserType =rs.getString("UserType");
                TxtUserType.setText(setUserType);
            }  
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }//GEN-LAST:event_SearchKeyReleased
    }
    private void TxtURName1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtURName1KeyReleased
           lbl_Name.setText("");
    }//GEN-LAST:event_TxtURName1KeyReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query = "DELETE FROM Login where UserID =?";
            
            PreparedStatement pst = con.prepareStatement(query);
 
            pst.setString(1,TxtUserID.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)DisplayUserDetails.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Deleted sucessfully");
            
            TxtURName1.setText("");
            jPasswordField1.setText("");
            TxtEPFNo.setText("");
            TxtUserID.setText("");
            Search.setText("");
            TxtUserType.setText("");
        
        }
        catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }//GEN-LAST:event_btnDeleteActionPerformed
    }
   
    @SuppressWarnings("deprecation")
    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
          
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
           /* int row = DisplayUserDetails.getSelectedRow();
            String value = (DisplayUserDetails.getModel().getValueAt(row, 0).toString());*/
            String query = "UPDATE Login SET Name = ?,Password = ?,EPFNo = ? where UserID =?";
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,TxtURName1.getText());
            pst.setString(2,jPasswordField1.getText());
            pst.setString(3,TxtEPFNo.getText());
            pst.setString(4,TxtUserID.getText());
//            pst.setString(5,TxtUserType.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)DisplayUserDetails.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Update sucessfully");
            
            
            }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
               
            TxtURName1.setText("");
            jPasswordField1.setText("");
            TxtEPFNo.setText("");
            TxtUserID.setText("");
            Search.setText("");
            TxtUserType.setText("");
                                                    
    }//GEN-LAST:event_UpdateActionPerformed

    private void DisplayUserDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DisplayUserDetailsMouseClicked
                
        int i = DisplayUserDetails.getSelectedRow();
        TableModel model = DisplayUserDetails.getModel();
        TxtEPFNo.setText(model.getValueAt(i, 0).toString());
        TxtURName1.setText(model.getValueAt(i, 1).toString());
        jPasswordField1.setText(model.getValueAt(i, 2).toString());
        TxtUserType.setText(model.getValueAt(i, 3).toString());
        boolean a = DisplayUserDetails.isEditing();
        
        if(a==false){
            JOptionPane.showMessageDialog(null, "You can not edit this table ");
            
        }
   
    }//GEN-LAST:event_DisplayUserDetailsMouseClicked
    
    private void TxtUserIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUserIDActionPerformed
      
    }//GEN-LAST:event_TxtUserIDActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchActionPerformed

    private void TxtUserIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtUserIDKeyReleased
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String sql = "SELECT MAX(Bytes) FROM Login = ?";
            //PreparedStatement pst = con.prepareStatement(sql);
            //pst.setString(1, TxtUserID.getText());
            
                
                
                
            
                /*String setEPF =rs.getString("EPFNo");
                TxtEPFNo.setText(setEPF);
                String setName =rs.getString("Name");
                TxtURName1.setText(setName);
                String setPassword =rs.getString("Password");
                jPasswordField1.setText(setPassword);*/
                //String setUserID =rs.getString("UserID");
                //TxtUserID.setText(setUserID);
            
             
             
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }                   
    }//GEN-LAST:event_TxtUserIDKeyReleased

    private void TxtEPFNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEPFNoKeyReleased
           lbl_EPFNo.setText("");

        
    }//GEN-LAST:event_TxtEPFNoKeyReleased

    private void jPasswordField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField1KeyReleased
            lbl_Password.setText("");

//         if(jPasswordField1.getText().length()>0){
//            URSavebtn.setEnabled(true);
//        }
//        else{
//                URSavebtn.setEnabled(false);
//                }
    }//GEN-LAST:event_jPasswordField1KeyReleased

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        TxtUserID.setEditable(false);
        
    }//GEN-LAST:event_formComponentShown

    private void SearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyPressed
         int key = evt.getKeyCode();
        if(key==10) {
        TxtUserID.requestFocus();
    }                                 
    }//GEN-LAST:event_SearchKeyPressed

    private void TxtUserIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtUserIDKeyPressed
        int key = evt.getKeyCode();
        if(key==10) {
        TxtEPFNo.requestFocus();
        
    }      
    }//GEN-LAST:event_TxtUserIDKeyPressed

    private void TxtEPFNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEPFNoKeyPressed
        int key = evt.getKeyCode();
        if(key==10) {
        TxtURName1.requestFocus();
        }
    }//GEN-LAST:event_TxtEPFNoKeyPressed

    private void TxtURName1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtURName1KeyPressed
         int key = evt.getKeyCode();
        if(key==10) {
        jPasswordField1.requestFocus();
        }
    }//GEN-LAST:event_TxtURName1KeyPressed

    private void CombUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombUserTypeActionPerformed
        String selectedValue = CombUserType.getSelectedItem().toString();

        //How to set this delected value into textField

        TxtUserType.setText((selectedValue));
    }//GEN-LAST:event_CombUserTypeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Admin field=new Admin();
                field.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed
    
    
    public static void main(String args[]) throws ClassNotFoundException {
        
      
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserRegister().setVisible(true);
            }
        });
    }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CombUserType;
    private javax.swing.JTable DisplayUserDetails;
    private java.awt.Label EpfNo;
    private javax.swing.JTextField Search;
    private java.awt.TextField TxtEPFNo;
    private java.awt.TextField TxtURName1;
    private javax.swing.JTextField TxtUserID;
    private javax.swing.JTextField TxtUserType;
    private java.awt.Button URCancelbtn;
    private java.awt.Button URSavebtn;
    private java.awt.Button Update;
    private java.awt.Button btnDelete;
    private java.awt.Button btnReset;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private javax.swing.JLabel lbl_EPFNo;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_Password;
    private java.awt.TextField textField2;
    // End of variables declaration//GEN-END:variables
byte[] photo=null;
String filename=null;
}



