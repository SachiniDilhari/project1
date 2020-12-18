/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oems;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author sachini
 */
public class User1 extends javax.swing.JFrame {

  
    public User1() {
        initComponents();
        show_user();
        show_user1();
    }
        
    public ArrayList<ServiceAndRepairUser>userList1(){
      ArrayList<ServiceAndRepairUser> userList1 = new ArrayList<>();
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM Sevice_And_Repair_Table";
            Statement st= con.createStatement();
            ResultSet rs= st.executeQuery(query1);
            ServiceAndRepairUser serviceandrepairuser;
            while(rs.next()){
                serviceandrepairuser=new ServiceAndRepairUser(rs.getInt("Job_No"), rs.getString("Service_Date"),rs.getString("Transection_Code"),rs.getString("Value"),rs.getString("Seivice_Description"),rs.getString("Suppier_Name"),rs.getInt("Equipment_ID"),rs.getString("Location_Name"));
                userList1.add(serviceandrepairuser);
              
            }
            
            
      }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList1;
    }
    public void show_user(){
        ArrayList<ServiceAndRepairUser> list = userList1();
        DefaultTableModel model = (DefaultTableModel)tblServiceandRepair.getModel();
        Object[] row = new Object[8];
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getJob_No();
            row[1]=list.get(i).getService_Date();
            row[2]=list.get(i).getService_Category();
            row[3]=list.get(i).getValue();
            row[4]=list.get(i).getSeivice_Description();
            row[5]=list.get(i).getSuppier_Name();
            row[6]=list.get(i).getEquipment_ID();
            row[7]=list.get(i).getLocation_Name();
            model.addRow(row);
        }
    }
        
     public ArrayList<PreventiveServiceUser>userList2(){
      ArrayList<PreventiveServiceUser> userList2 = new ArrayList<>();
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM Preventive_Service_Table1";
            Statement st1= con.createStatement();
            ResultSet rs2= st1.executeQuery(query1);
            PreventiveServiceUser preventiveserviceuser;
            while(rs2.next()){
            preventiveserviceuser=new PreventiveServiceUser(rs2.getInt("Job_No"),rs2.getString("Service_Date"),rs2.getString("Value_Of_Service"),rs2.getString("Service_catagory"),rs2.getInt("Equipment_ID"));
                userList2.add(preventiveserviceuser);
              
            }
          
      }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList2;
    }

    public void show_user1(){
        
        ArrayList<PreventiveServiceUser> list = userList2();
        DefaultTableModel model = (DefaultTableModel)TblPreventiveService.getModel();
        Object[] row = new Object[5];
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getJob_No();
            row[1]=list.get(i).getService_Date();
            row[2]=list.get(i).getValue_Of_Service();
            row[3]=list.get(i).getService_catagory();
            row[4]=list.get(i).getEquipment_ID();
        
            model.addRow(row);
        }
    
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            
            Statement pst = con.createStatement(); 
            String query = "select Sup_Name from Sup_Reg_Table";
             ResultSet rs = pst.executeQuery(query);
             while(rs.next())
                
            {
                jComboBox4SupID.addItem(rs.getString("Sup_Name"));
            }
            
            Statement pst2 = con.createStatement();
            String query2 = "select Location_Name from Location_Reg_Table";
            ResultSet rs2 = pst2.executeQuery(query2);
            while (rs2.next())
           {
               jComboBox6LocID.addItem(rs2.getString("Location_Name"));
           }
            
            Statement pst3 = con.createStatement();
            String query3 = "select EquipmentID from Equipment_Reg_Table";
            ResultSet rs3 = pst3.executeQuery(query3);
            while (rs3.next())
           {
               jComboBox5EquipID.addItem(rs3.getString("EquipmentID"));
           }
            
            Statement pst4 = con.createStatement();
            String query4 = "select Transection_Code from Transection_Codes_Table";
            ResultSet rs4 = pst4.executeQuery(query4);
            while (rs4.next())
           {
               Com_Trnsection_code.addItem(rs4.getString("Transection_Code"));
           }
            Statement pst6 = con.createStatement();
            String query6 = "select Category_Definition from Service_Category_Table";
            ResultSet rs6 = pst6.executeQuery(query6);
            while (rs6.next())
           {
               Com_Trnsection_codePS.addItem(rs6.getString("Category_Definition"));
           }
            Statement pst7 = con.createStatement();
            String query7 = "select EquipmentID from Equipment_Reg_Table";
            ResultSet rs7 = pst7.executeQuery(query7);
            while (rs7.next())
           {
               jComboBox4EquipmentIDPS.addItem(rs7.getString("EquipmentID"));
           }
            
}       catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserPermissionTable.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        label3 = new java.awt.Label();
        label2 = new java.awt.Label();
        jTextField6 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField8 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        button4 = new java.awt.Button();
        button3 = new java.awt.Button();
        button2 = new java.awt.Button();
        button1 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblServiceandRepairUser1 = new javax.swing.JLabel();
        lblPreventiveServiceUser2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        PreventiveService = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        BtnSaveP = new javax.swing.JButton();
        btnUpdateP = new javax.swing.JButton();
        btnDeleteP = new javax.swing.JButton();
        BtnResetP = new javax.swing.JButton();
        BtnViewReportP = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        TxtSearchPS = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jDateChooser3ServiceDateP = new com.toedter.calendar.JDateChooser();
        jComboBox4EquipmentIDPS = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblPreventiveService = new javax.swing.JTable();
        TxtJobNoP1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Com_Trnsection_codePS = new javax.swing.JComboBox<>();
        TxtTransection_CodePS = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TxtAmountPS = new javax.swing.JTextField();
        TxtServicePDate = new javax.swing.JTextField();
        TxtEquipmentIDPS = new javax.swing.JTextField();
        ServiceAndRepair = new javax.swing.JPanel();
        panel1 = new java.awt.Panel();
        label4 = new java.awt.Label();
        BtnReset = new java.awt.Button();
        BtnViewRep = new javax.swing.JButton();
        btnDeleteServiceNRepair = new java.awt.Button();
        btnSave_Service_and_repair = new java.awt.Button();
        btnUpdate = new java.awt.Button();
        jLabel9 = new javax.swing.JLabel();
        TxtSearchSnR = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtTransection_Code = new javax.swing.JTextField();
        Txt_Service_Date = new com.toedter.calendar.JDateChooser();
        TxtJobNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtValue = new javax.swing.JTextField();
        TxtDesc = new javax.swing.JTextField();
        lable = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        TxtSupId = new javax.swing.JTextField();
        jComboBox4SupID = new javax.swing.JComboBox<>();
        jComboBox5EquipID = new javax.swing.JComboBox<>();
        TxtEqID = new javax.swing.JTextField();
        jComboBox6LocID = new javax.swing.JComboBox<>();
        TxtLocID = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblServiceandRepair = new javax.swing.JTable();
        Com_Trnsection_code = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Job No");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Service Date");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Service Category");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("ServiceDescription ");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Value");

        label1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label1.setText("Supplier ID");

        label3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label3.setText("Equipment ID");

        label2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label2.setName(""); // NOI18N
        label2.setText("Location ID");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("View Report");

        button4.setLabel("Reset");

        button3.setLabel("Delete");

        button2.setLabel("Update");

        button1.setLabel("Add");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JobNo", "Service Date", "Service Category", "Value", "Service Description", "Supplier ID", "Equipment ID", "Location ID"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblServiceandRepairUser1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblServiceandRepairUser1.setText("Service And Repairs");
        lblServiceandRepairUser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblServiceandRepairUser1MouseClicked(evt);
            }
        });

        lblPreventiveServiceUser2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblPreventiveServiceUser2.setText("Preventive Service");
        lblPreventiveServiceUser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPreventiveServiceUser2MouseClicked(evt);
            }
        });

        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel11.setText("Preventive Service");

        BtnSaveP.setText("Save");
        BtnSaveP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSavePActionPerformed(evt);
            }
        });

        btnUpdateP.setText("Update");
        btnUpdateP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePActionPerformed(evt);
            }
        });

        btnDeleteP.setText("Dalete");
        btnDeleteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePActionPerformed(evt);
            }
        });

        BtnResetP.setText("Reset");
        BtnResetP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetPActionPerformed(evt);
            }
        });

        BtnViewReportP.setText("View Report");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Search");

        TxtSearchPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSearchPSActionPerformed(evt);
            }
        });
        TxtSearchPS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtSearchPSKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtSearchPS, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(232, 232, 232)
                .addComponent(BtnSaveP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdateP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnResetP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnViewReportP, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(BtnSaveP)
                    .addComponent(btnUpdateP)
                    .addComponent(btnDeleteP)
                    .addComponent(BtnResetP)
                    .addComponent(BtnViewReportP)
                    .addComponent(jLabel19)
                    .addComponent(TxtSearchPS, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Job No");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Service Date");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Equipment ID");

        jComboBox4EquipmentIDPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4EquipmentIDPSActionPerformed(evt);
            }
        });

        TblPreventiveService.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Service Date", "Amount", "Transection Code", "Equipment ID"
            }
        ));
        TblPreventiveService.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblPreventiveServiceMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TblPreventiveService);

        TxtJobNoP1.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Service category");

        Com_Trnsection_codePS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Com_Trnsection_codePSActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Amount");

        javax.swing.GroupLayout PreventiveServiceLayout = new javax.swing.GroupLayout(PreventiveService);
        PreventiveService.setLayout(PreventiveServiceLayout);
        PreventiveServiceLayout.setHorizontalGroup(
            PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PreventiveServiceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PreventiveServiceLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91)
                        .addComponent(jLabel13)
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PreventiveServiceLayout.createSequentialGroup()
                        .addComponent(TxtJobNoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtServicePDate, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser3ServiceDateP, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 73, 73)
                .addGroup(PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(TxtAmountPS, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Com_Trnsection_codePS, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(TxtTransection_CodePS, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17)
                    .addComponent(jComboBox4EquipmentIDPS, 0, 247, Short.MAX_VALUE)
                    .addComponent(TxtEquipmentIDPS))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        PreventiveServiceLayout.setVerticalGroup(
            PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PreventiveServiceLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PreventiveServiceLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15))
                        .addGap(35, 35, 35)
                        .addGroup(PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser3ServiceDateP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtJobNoP1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtAmountPS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TxtServicePDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PreventiveServiceLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Com_Trnsection_codePS, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4EquipmentIDPS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(PreventiveServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PreventiveServiceLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(TxtTransection_CodePS, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PreventiveServiceLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(TxtEquipmentIDPS, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(PreventiveService, "card3");

        panel1.setBackground(new java.awt.Color(204, 204, 204));

        label4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        label4.setText("Breakedown - Service And Repair");

        BtnReset.setLabel("Reset");
        BtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnResetActionPerformed(evt);
            }
        });

        BtnViewRep.setText("View Report");
        BtnViewRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnViewRepActionPerformed(evt);
            }
        });

        btnDeleteServiceNRepair.setLabel("Delete");
        btnDeleteServiceNRepair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteServiceNRepairActionPerformed(evt);
            }
        });

        btnSave_Service_and_repair.setLabel("Save");
        btnSave_Service_and_repair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave_Service_and_repairActionPerformed(evt);
            }
        });

        btnUpdate.setLabel("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel9.setText("Search");

        TxtSearchSnR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSearchSnRActionPerformed(evt);
            }
        });
        TxtSearchSnR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtSearchSnRKeyReleased(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("<-----");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel9))
                    .addComponent(jButton2))
                .addGap(41, 41, 41)
                .addComponent(TxtSearchSnR, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163)
                .addComponent(btnSave_Service_and_repair, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteServiceNRepair, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(BtnViewRep, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave_Service_and_repair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnViewRep)
                    .addComponent(btnDeleteServiceNRepair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(TxtSearchSnR)
                .addContainerGap())
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Job No");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Service Date");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Transection Code");

        Txt_Service_Date.setDebugGraphicsOptions(javax.swing.DebugGraphics.LOG_OPTION);
        Txt_Service_Date.setFocusTraversalPolicyProvider(true);

        TxtJobNo.setEnabled(false);
        TxtJobNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtJobNoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Value");

        TxtValue.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtValueKeyPressed(evt);
            }
        });

        lable.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lable.setText("Supplier ");

        label6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label6.setText("Equipment ");

        label7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label7.setName(""); // NOI18N
        label7.setText("Location ");

        jComboBox4SupID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4SupIDActionPerformed(evt);
            }
        });

        jComboBox5EquipID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5EquipIDActionPerformed(evt);
            }
        });

        jComboBox6LocID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6LocIDActionPerformed(evt);
            }
        });

        tblServiceandRepair.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "JobNo", "Service Date", "Service Category", "Value", "Service Description", "Supplier Name", "Equipment ID", "Location Name"
            }
        ));
        tblServiceandRepair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServiceandRepairMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblServiceandRepair);

        Com_Trnsection_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Com_Trnsection_codeActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setText("ServiceDescription ");

        javax.swing.GroupLayout ServiceAndRepairLayout = new javax.swing.GroupLayout(ServiceAndRepair);
        ServiceAndRepair.setLayout(ServiceAndRepairLayout);
        ServiceAndRepairLayout.setHorizontalGroup(
            ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ServiceAndRepairLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Txt_Service_Date, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(TxtTransection_Code)
                    .addComponent(Com_Trnsection_code, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(40, 40, 40))
                            .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(57, 57, 57)))
                        .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtValue)
                            .addComponent(TxtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lable, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70))
                    .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox4SupID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtSupId)
                    .addComponent(jComboBox5EquipID, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtEqID)
                    .addComponent(TxtLocID)
                    .addComponent(jComboBox6LocID, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119))
            .addComponent(jScrollPane2)
            .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                    .addGap(125, 125, 125)
                    .addComponent(jLabel6)
                    .addGap(26, 26, 26)
                    .addComponent(TxtJobNo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1476, Short.MAX_VALUE)))
        );
        ServiceAndRepairLayout.setVerticalGroup(
            ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                                .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox4SupID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addComponent(TxtSupId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                                        .addComponent(jComboBox5EquipID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtEqID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox6LocID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtLocID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                                .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(TxtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)))))
                    .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Txt_Service_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Com_Trnsection_code, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(TxtTransection_Code, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ServiceAndRepairLayout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addGroup(ServiceAndRepairLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtJobNo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addContainerGap(635, Short.MAX_VALUE)))
        );

        Txt_Service_Date.getAccessibleContext().setAccessibleDescription("");

        jPanel3.add(ServiceAndRepair, "card3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblServiceandRepairUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPreventiveServiceUser2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServiceandRepairUser1)
                    .addComponent(lblPreventiveServiceUser2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblServiceandRepairUser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblServiceandRepairUser1MouseClicked
        // TODO add your handling code here:
        ServiceAndRepair.setVisible(true);
        PreventiveService.setVisible(false);
    }//GEN-LAST:event_lblServiceandRepairUser1MouseClicked

    private void lblPreventiveServiceUser2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPreventiveServiceUser2MouseClicked
        // TODO add your handling code here:
        ServiceAndRepair.setVisible(false);
        PreventiveService.setVisible(true);
    }//GEN-LAST:event_lblPreventiveServiceUser2MouseClicked


    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    /*............................Service And Repairs......................*/
    
    private void Com_Trnsection_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Com_Trnsection_codeActionPerformed
        // TODO add your handling code here:
        String selectedValue = Com_Trnsection_code.getSelectedItem().toString();

        //How to set this delected value into textField

        TxtTransection_Code.setText((selectedValue));
    }//GEN-LAST:event_Com_Trnsection_codeActionPerformed

    private void tblServiceandRepairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServiceandRepairMouseClicked
        int i = tblServiceandRepair.getSelectedRow();
        TableModel model = tblServiceandRepair.getModel();
        TxtJobNo.setText(model.getValueAt(i, 0).toString());
        Txt_Service_Date.setDateFormatString(model.getValueAt(i, 1).toString());
        TxtTransection_Code.setText(model.getValueAt(i, 2).toString());
        TxtValue.setText(model.getValueAt(i, 3).toString());
        TxtDesc.setText(model.getValueAt(i, 4).toString());
        TxtSupId.setText(model.getValueAt(i, 5).toString());
        TxtEqID.setText(model.getValueAt(i, 6).toString());
        TxtLocID.setText(model.getValueAt(i, 7).toString());
        
        boolean a = tblServiceandRepair.isEditing();
        
        if(a==false){
            JOptionPane.showMessageDialog(null, "You can not edit this table ");
            
        }
    }//GEN-LAST:event_tblServiceandRepairMouseClicked

    private void btnSave_Service_and_repairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave_Service_and_repairActionPerformed
           
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query = "insert into Sevice_And_Repair_Table(Service_Date, Transection_Code, Value,Seivice_Description,Suppier_Name,Equipment_ID,Location_Name)values(?,?,?,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(query);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(Txt_Service_Date.getDate());
            pst.setString(1, date);
            pst.setString(2,TxtTransection_Code.getText());
            pst.setString(3,TxtValue.getText());
            pst.setString(4,TxtDesc.getText());
            pst.setString(5,TxtSupId.getText());
            pst.setString(6,TxtEqID.getText());
            pst.setString(7,TxtLocID.getText());
            
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)tblServiceandRepair.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Save sucessfully");
      
        }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
            TxtJobNo.setText("");
            Txt_Service_Date.setDateFormatString("");
            TxtTransection_Code.setText("");
            TxtValue.setText("");
            TxtDesc.setText("");
            TxtSupId.setText("");
            TxtEqID.setText("");
            TxtLocID.setText("");
            TxtSearchSnR.setText("");
                
    }//GEN-LAST:event_btnSave_Service_and_repairActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
           /* int row = DisplayUserDetails.getSelectedRow();
            String value = (DisplayUserDetails.getModel().getValueAt(row, 0).toString());*/
            String query = "UPDATE Sevice_And_Repair_Table SET Service_Date = ?,Transection_Code = ?,Value = ?,Seivice_Description = ?,Suppier_Name = ?,Equipment_ID = ?,Location_Name = ? where Job_No =?";
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,TxtJobNo.getText());
            pst.setString(2,Txt_Service_Date.getDateFormatString());
            pst.setString(3,TxtTransection_Code.getText());
            pst.setString(4,TxtValue.getText());
            pst.setString(5,TxtDesc.getText());
            pst.setString(6,TxtSupId.getText());
            pst.setString(7,TxtEqID.getText());
            pst.setString(8,TxtLocID.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)tblServiceandRepair.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Update sucessfully");
            
            
            }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
               
            TxtJobNo.setText("");
            Txt_Service_Date.setDateFormatString("");
            TxtTransection_Code.setText("");
            TxtValue.setText("");
            TxtDesc.setText("");
            TxtSupId.setText("");
            TxtEqID.setText("");
            TxtLocID.setText("");
            TxtSearchSnR.setText("");
            
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteServiceNRepairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteServiceNRepairActionPerformed
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query = "DELETE FROM Sevice_And_Repair_Table where Job_No =?";
            
            PreparedStatement pst = con.prepareStatement(query);
 
            pst.setString(1,TxtJobNo.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)tblServiceandRepair.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Deleted sucessfully");
            
           
            TxtJobNo.setText("");
            Txt_Service_Date.setDateFormatString("");
            TxtTransection_Code.setText("");
            TxtValue.setText("");
            TxtDesc.setText("");
            TxtSupId.setText("");
            TxtEqID.setText("");
            TxtLocID.setText("");
            TxtSearchSnR.setText("");
        }
        catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnDeleteServiceNRepairActionPerformed

    private void BtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetActionPerformed
           
//            TxtJobNo.setText("");
//            Txt_Service_Date.setDateFormatString("");
//            TxtTransection_Code.setText("");
//            TxtValue.setText("");
//            TxtDesc.setText("");
//            TxtSupId.setText("");
//            TxtEqID.setText("");
//            TxtLocID.setText("");
//            TxtSearchSnR.setText("");
            
           
           ServiceAndRepair.add(ServiceAndRepair);
           ServiceAndRepair.repaint();
           ServiceAndRepair.revalidate();
           
           
          
           
         
           
 
    }//GEN-LAST:event_BtnResetActionPerformed

    private void jComboBox6LocIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6LocIDActionPerformed
        String selectedValue = jComboBox6LocID.getSelectedItem().toString();

        TxtLocID.setText((selectedValue));
    }//GEN-LAST:event_jComboBox6LocIDActionPerformed

    private void jComboBox5EquipIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5EquipIDActionPerformed
        String selectedValue = jComboBox5EquipID.getSelectedItem().toString();

        TxtEqID.setText((selectedValue));
    }//GEN-LAST:event_jComboBox5EquipIDActionPerformed

    private void jComboBox4SupIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4SupIDActionPerformed
        String selectedValue = jComboBox4SupID.getSelectedItem().toString();

        TxtSupId.setText((selectedValue));
    }//GEN-LAST:event_jComboBox4SupIDActionPerformed

    private void TxtJobNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtJobNoActionPerformed
       
    }//GEN-LAST:event_TxtJobNoActionPerformed

    
      /*..........................Preventive Service............................*/
    
    
        
    private void BtnViewRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnViewRepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnViewRepActionPerformed

    private void TxtSearchSnRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSearchSnRKeyReleased
       try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String sql = "select * from Sevice_And_Repair_Table where Job_No = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, TxtSearchSnR.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String setJob_No =rs.getString("Job_No");
                TxtJobNo.setText(setJob_No);
                
                String setService_Date =rs.getString("Service_Date");
                Txt_Service_Date.setDateFormatString(setService_Date);
                
                String setTransection_Code =rs.getString("Transection_Code");
                TxtTransection_Code.setText(setTransection_Code);
                
                String setValue =rs.getString("Value");
                TxtValue.setText(setValue);
                
                String setSeivice_Description =rs.getString("Seivice_Description");
                TxtDesc.setText(setSeivice_Description);
                
                String setSuppier_Name =rs.getString("Suppier_Name");
                TxtSupId.setText(setSuppier_Name);
                
                String setEquipment_ID =rs.getString("Equipment_ID");
                TxtEqID.setText(setEquipment_ID);
                
                String setLocation_Name =rs.getString("Location_Name");
                TxtLocID.setText(setLocation_Name);
                
               
                
            }
             
             
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }                                 
    }//GEN-LAST:event_TxtSearchSnRKeyReleased

    private void TxtSearchSnRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSearchSnRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSearchSnRActionPerformed

    private void TblPreventiveServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblPreventiveServiceMouseClicked
        int i = TblPreventiveService.getSelectedRow();
        TableModel model = TblPreventiveService.getModel();
        TxtJobNoP1.setText(model.getValueAt(i, 0).toString());
        jDateChooser3ServiceDateP.setDateFormatString(model.getValueAt(i, 1).toString());
        TxtAmountPS.setText(model.getValueAt(i, 2).toString());
        TxtTransection_CodePS.setText(model.getValueAt(i, 3).toString());
        TxtEquipmentIDPS.setText(model.getValueAt(i, 4).toString());
        
        boolean a = TblPreventiveService.isEditing();
       
        if(a==false){
            JOptionPane.showMessageDialog(null, "You can not edit this table ");
    }//GEN-LAST:event_TblPreventiveServiceMouseClicked
    }
    private void jComboBox4EquipmentIDPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox4EquipmentIDPSActionPerformed
         String selectedValue = jComboBox4EquipmentIDPS.getSelectedItem().toString();

        //How to set this delected value into textField

        TxtEquipmentIDPS.setText((selectedValue));
    }//GEN-LAST:event_jComboBox4EquipmentIDPSActionPerformed

/**....Preventive Service.......*/
    private void BtnResetPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnResetPActionPerformed

           

        TxtSearchPS.setText("");
        TxtJobNoP1.setText("");
        jDateChooser3ServiceDateP.setDateFormatString("");
        TxtAmountPS.setText("");
        TxtTransection_CodePS.setText("");
        TxtEquipmentIDPS.setText("");
        TxtServicePDate.setText("");

           this.dispose();
           User1 u = new User1();
           u.setVisible(true);

    }//GEN-LAST:event_BtnResetPActionPerformed

    private void btnDeletePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePActionPerformed
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query = "DELETE FROM Preventive_Service_Table1 where Job_No =?";
            
            PreparedStatement pst = con.prepareStatement(query);
 
            pst.setString(1,TxtJobNoP1.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblPreventiveService.getModel();
            model.setRowCount(0);
            show_user1();
            JOptionPane.showMessageDialog(null, "Deleted sucessfully");
            
             TxtSearchPS.setText("");
             TxtJobNoP1.setText("");
             jDateChooser3ServiceDateP.setDateFormatString("");
             TxtAmountPS.setText("");
             TxtTransection_CodePS.setText("");
             TxtEquipmentIDPS.setText("");
             
             this.dispose();
             User1 u = new User1();
           u.setVisible(true);
        }
        catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }//GEN-LAST:event_btnDeletePActionPerformed
    }
    private void btnUpdatePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePActionPerformed
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
           /* int row = DisplayUserDetails.getSelectedRow();
            String value = (DisplayUserDetails.getModel().getValueAt(row, 0).toString());*/
            String query = "UPDATE Preventive_Service_Table1 SET Service_Date = ?,Service_catagory = ?,Equipment_ID = ?,Value_Of_Service= ? where Job_No =?";
            
            PreparedStatement pst = con.prepareStatement(query);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(jDateChooser3ServiceDateP.getDate());
            pst.setString(1, date);
            pst.setString(2,TxtAmountPS.getText());
            pst.setString(3,TxtTransection_CodePS.getText());
            pst.setString(4,TxtEquipmentIDPS.getText());
            pst.setString(5,TxtJobNoP1.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblPreventiveService.getModel();
            model.setRowCount(0);
            show_user1();
            JOptionPane.showMessageDialog(null, "Update sucessfully");
            
            
            
            }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
               
        TxtSearchPS.setText("");
        TxtJobNoP1.setText("");
        jDateChooser3ServiceDateP.setDateFormatString("");
        TxtAmountPS.setText("");
        TxtTransection_CodePS.setText("");
        TxtEquipmentIDPS.setText("");
        
           this.dispose();
           User1 u = new User1();
           u.setVisible(true);
    }//GEN-LAST:event_btnUpdatePActionPerformed

    private void BtnSavePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSavePActionPerformed
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query = "insert into Preventive_Service_Table1(Service_Date,Value_Of_Service,Service_catagory,Equipment_ID)values(?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(jDateChooser3ServiceDateP.getDate());
            pst.setString(1, date);
            pst.setString(2,TxtAmountPS.getText());
            pst.setString(3,TxtTransection_CodePS.getText());
            pst.setString(4,TxtEquipmentIDPS.getText());
         
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblPreventiveService.getModel();
            model.setRowCount(0);
            show_user1();
            JOptionPane.showMessageDialog(null, "Save sucessfully");

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
        TxtSearchPS.setText("");
        TxtJobNoP1.setText("");
        jDateChooser3ServiceDateP.setDateFormatString("");
        TxtAmountPS.setText("");
        TxtTransection_CodePS.setText("");
        TxtEquipmentIDPS.setText("");
        
           this.dispose();
           User1 u = new User1();
           u.setVisible(true);

    }//GEN-LAST:event_BtnSavePActionPerformed

    private void Com_Trnsection_codePSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Com_Trnsection_codePSActionPerformed
       String selectedValue = Com_Trnsection_codePS.getSelectedItem().toString();

        //How to set this delected value into textField

        TxtTransection_CodePS.setText((selectedValue));
                                             
    }//GEN-LAST:event_Com_Trnsection_codePSActionPerformed

    private void TxtSearchPSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSearchPSKeyReleased
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String sql = "select * from Preventive_Service_Table1 where Job_No = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, TxtSearchPS.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String setJob_No =rs.getString("Job_No");
                TxtJobNoP1.setText(setJob_No);
                
                java.sql.Date setPurchasDate =rs.getDate("Service_Date");
                jDateChooser3ServiceDateP.setDate(setPurchasDate);
                
                String setValue_Of_Service =rs.getString("Value_Of_Service");
                TxtAmountPS.setText(setValue_Of_Service);
                
                String setTransection_Code =rs.getString("Service_catagory");
                TxtTransection_CodePS.setText(setTransection_Code);
                
                String setEquipment_ID =rs.getString("Equipment_ID");
                TxtEquipmentIDPS.setText(setEquipment_ID);
                
                
         
            
            }
             
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }//GEN-LAST:event_TxtSearchPSKeyReleased
    }

    private void TxtValueKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtValueKeyPressed
        int key = evt.getKeyCode();
        if(key==10) {
        TxtDesc.requestFocus();
    }
    }//GEN-LAST:event_TxtValueKeyPressed

    private void TxtSearchPSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSearchPSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSearchPSActionPerformed

     
     
        

     
        
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User1().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button BtnReset;
    private javax.swing.JButton BtnResetP;
    private javax.swing.JButton BtnSaveP;
    private javax.swing.JButton BtnViewRep;
    private javax.swing.JButton BtnViewReportP;
    private javax.swing.JComboBox<String> Com_Trnsection_code;
    private javax.swing.JComboBox<String> Com_Trnsection_codePS;
    private javax.swing.JPanel PreventiveService;
    private javax.swing.JPanel ServiceAndRepair;
    private javax.swing.JTable TblPreventiveService;
    private javax.swing.JTextField TxtAmountPS;
    private javax.swing.JTextField TxtDesc;
    private javax.swing.JTextField TxtEqID;
    private javax.swing.JTextField TxtEquipmentIDPS;
    private javax.swing.JTextField TxtJobNo;
    private javax.swing.JTextField TxtJobNoP1;
    private javax.swing.JTextField TxtLocID;
    private javax.swing.JTextField TxtSearchPS;
    private javax.swing.JTextField TxtSearchSnR;
    private javax.swing.JTextField TxtServicePDate;
    private javax.swing.JTextField TxtSupId;
    private javax.swing.JTextField TxtTransection_Code;
    private javax.swing.JTextField TxtTransection_CodePS;
    private javax.swing.JTextField TxtValue;
    private com.toedter.calendar.JDateChooser Txt_Service_Date;
    private javax.swing.JButton btnDeleteP;
    private java.awt.Button btnDeleteServiceNRepair;
    private java.awt.Button btnSave_Service_and_repair;
    private java.awt.Button btnUpdate;
    private javax.swing.JButton btnUpdateP;
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4EquipmentIDPS;
    private javax.swing.JComboBox<String> jComboBox4SupID;
    private javax.swing.JComboBox<String> jComboBox5EquipID;
    private javax.swing.JComboBox<String> jComboBox6LocID;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser3ServiceDateP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label lable;
    private javax.swing.JLabel lblPreventiveServiceUser2;
    private javax.swing.JLabel lblServiceandRepairUser1;
    private java.awt.Panel panel1;
    private javax.swing.JTable tblServiceandRepair;
    // End of variables declaration//GEN-END:variables
}
