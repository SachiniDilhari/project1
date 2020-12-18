package oems;


;
import Report.Equipment_Buying_Expenses_Report;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



public class Admin extends javax.swing.JFrame {


    public Admin() {

        initComponents();
        show_user();
        show_user1();
        show_user2();
        
    

        
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            Statement pst = con.createStatement(); 
            String query = "select Project_Name from Project_Reg_Table";
            
            ResultSet rs = pst.executeQuery(query);
            
            
            while(rs.next())
            {
                CombProjectName_Loc.addItem(rs.getString("Project_Name"));
            }
           

            String query2 = "select Location_Name from Location_Reg_Table";
            
            ResultSet rs2 = pst.executeQuery(query2);
            
            
            while(rs2.next())
            {
                jComboBoxLocationIDEQ.addItem(rs2.getString("Location_Name"));
            }
            String query3 = "select Sup_Name from Sup_Reg_Table";
            
            ResultSet rs3 = pst.executeQuery(query3);
            
            
            while(rs3.next())
            {
                jComboBoxSupIDEq.addItem(rs3.getString("Sup_Name"));
            }
            
            String query4 = "select Coordinator_Name from Coordinator_Table";
            
            ResultSet rs4 = pst.executeQuery(query4);
            
            
            while(rs4.next())
            {
                Com_Coordinator.addItem(rs4.getString("Coordinator_Name"));
            }
            
}       catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserPermissionTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        
    }   
    
    
public ArrayList<AdminUser>userList(){
      ArrayList<AdminUser> userList = new ArrayList<>();
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM Sup_Reg_Table";
            Statement st= con.createStatement();
            ResultSet rs1= st.executeQuery(query1);
            AdminUser adminuser;
            while(rs1.next()){
                adminuser=new AdminUser(rs1.getString("Sup_Name"),rs1.getString("Contact_No"),rs1.getString("BankDetails"),rs1.getString("Address"));
                userList.add(adminuser);
                
            }
      
            
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList;
    }
    public void show_user(){
        ArrayList<AdminUser> list = userList();
        DefaultTableModel model = (DefaultTableModel)TblSupplier.getModel();
        Object[] row = new Object[4];
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getSup_Name();
            row[1]=list.get(i).getContact_No();
            row[2]=list.get(i).getBankDetails();
            row[3]=list.get(i).getAddress();
            model.addRow(row);
        }
        
    }
    //.........Location...........//
    
        public ArrayList<LocationUser>userList1(){
      ArrayList<LocationUser> userList1 = new ArrayList<>();
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM Location_Reg_Table";
            Statement st= con.createStatement();
            ResultSet rs1= st.executeQuery(query1);
            LocationUser locationuser;
            while(rs1.next()){
                locationuser=new LocationUser(rs1.getString("Location_Name"),rs1.getString("Project_Name"),rs1.getString("Coordinator_Name"));
                userList1.add(locationuser);
                
            }
      
     
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList1;
    }
      public void show_user1(){
        ArrayList<LocationUser> list = userList1();
        DefaultTableModel model = (DefaultTableModel)TblLocation.getModel();
        Object[] row = new Object[3];
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getLocation_Name();
            row[1]=list.get(i).getProject_Name();
            row[2]=list.get(i).getCoordinator_Name();
           
            model.addRow(row);
        }
        
    }
//*****************Equipment*********************//
   
 
     public ArrayList<EquipmentUser>userList2(){
      ArrayList<EquipmentUser> userList2 = new ArrayList<>();
      try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM Equipment_Reg_Table";
            Statement st= con.createStatement();
            ResultSet rs1= st.executeQuery(query1);
            EquipmentUser equipmentuser;
            while(rs1.next()){
                equipmentuser=new EquipmentUser(rs1.getString("EquipmentID"),rs1.getString("Equipment_Name"),rs1.getString("Value"),rs1.getString("PurchasDate"),rs1.getString("Location"),rs1.getString("Supplier"));
                userList2.add(equipmentuser);
                
            }
      
     
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList2;
    }
      public void show_user2(){
        ArrayList<EquipmentUser> list = userList2();
        DefaultTableModel model = (DefaultTableModel)TblEq.getModel();
        Object[] row = new Object[6];
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getEquipmentID();
            row[1]=list.get(i).getEquipment_Name();
            row[2]=list.get(i).getValue();
            row[3]=list.get(i).getPurchasDate();
            row[4]=list.get(i).getLocation();
            row[5]=list.get(i).getSupplier();
            model.addRow(row);
        }
        
    }
      
     
            @SuppressWarnings("unchecked")
            
          
                    
            // <editor-fold defaultstate="collapsed" desc="Generated Code">
            

            
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnResetLocation1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Headingp = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        Backadmin = new javax.swing.JButton();
        Midp = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LSupplier = new javax.swing.JLabel();
        LLocation = new javax.swing.JLabel();
        LEquipment = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblUserRegister = new javax.swing.JLabel();
        lbl_Project_Manager_Reg = new javax.swing.JLabel();
        DisplayInf = new javax.swing.JPanel();
        Equipment = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        TxtEQID = new javax.swing.JTextField();
        TxtEQName = new javax.swing.JTextField();
        TxtValueEq = new javax.swing.JTextField();
        jComboBoxSupIDEq = new javax.swing.JComboBox<>();
        jComboBoxLocationIDEQ = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblEq = new javax.swing.JTable();
        TxtLocIDEQ = new javax.swing.JTextField();
        TxtSupIDEq = new javax.swing.JTextField();
        TxtSearchEq = new javax.swing.JTextField();
        label8 = new java.awt.Label();
        jTextField4 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        LblUpdateEq = new javax.swing.JButton();
        lblDeleteEq = new javax.swing.JButton();
        BtnSaveEq = new javax.swing.JButton();
        lblResetEq = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnViewReport = new javax.swing.JButton();
        PurchasDate = new com.toedter.calendar.JDateChooser();
        txtpurchdate = new javax.swing.JTextField();
        Supplier = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TxtSupID = new javax.swing.JTextField();
        TxtContactNo = new javax.swing.JTextField();
        TxtSupName = new javax.swing.JTextField();
        TxtAddressSup = new javax.swing.JTextField();
        TxtBankAcc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblSupplier = new javax.swing.JTable();
        BtnUpdateSup = new javax.swing.JButton();
        BtnDeleteSup = new javax.swing.JButton();
        btnResetSupplier = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        SupSearch = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        lbl_SupName = new javax.swing.JLabel();
        lbl_SupContact = new javax.swing.JLabel();
        lbl_SupBankAcc = new javax.swing.JLabel();
        lbl_SupAddress = new javax.swing.JLabel();
        Location = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnResetLoc = new javax.swing.JButton();
        btnUpdateLoction = new javax.swing.JButton();
        btnSaveLocation = new javax.swing.JButton();
        btnDeleteLocation = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtLoID = new javax.swing.JTextField();
        txtLocName = new javax.swing.JTextField();
        txtCoodinatorName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtLoSearch = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        CombProjectName_Loc = new javax.swing.JComboBox<>();
        TxtProjectName_Loc = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TblLocation = new javax.swing.JTable();
        Com_Coordinator = new javax.swing.JComboBox<>();
        lbl_LName = new javax.swing.JLabel();
        lbl_ProjectName = new javax.swing.JLabel();
        lbl_Coordinator = new javax.swing.JLabel();

        btnResetLocation1.setText("Reset");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("<-----");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        Headingp.setBackground(new java.awt.Color(204, 204, 204));
        Headingp.setName("mmm"); // NOI18N

        label1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label1.setText("OEMS");

        Backadmin.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Backadmin.setText("<-----");
        Backadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackadminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeadingpLayout = new javax.swing.GroupLayout(Headingp);
        Headingp.setLayout(HeadingpLayout);
        HeadingpLayout.setHorizontalGroup(
            HeadingpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadingpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(HeadingpLayout.createSequentialGroup()
                .addComponent(Backadmin)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        HeadingpLayout.setVerticalGroup(
            HeadingpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadingpLayout.createSequentialGroup()
                .addComponent(Backadmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Registration");

        LSupplier.setText("Supplier");
        LSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LSupplierMouseClicked(evt);
            }
        });

        LLocation.setText("Location");
        LLocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LLocationMouseClicked(evt);
            }
        });

        LEquipment.setText("Equiment");
        LEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LEquipmentMouseClicked(evt);
            }
        });

        lblUserRegister.setText("User register");
        lblUserRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblUserRegisterMouseClicked(evt);
            }
        });

        lbl_Project_Manager_Reg.setText("Project Manager");
        lbl_Project_Manager_Reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_Project_Manager_RegMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MidpLayout = new javax.swing.GroupLayout(Midp);
        Midp.setLayout(MidpLayout);
        MidpLayout.setHorizontalGroup(
            MidpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MidpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MidpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(MidpLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(lblUserRegister)
                        .addGap(53, 53, 53)
                        .addComponent(lbl_Project_Manager_Reg)
                        .addGap(36, 36, 36)
                        .addComponent(LSupplier)
                        .addGap(46, 46, 46)
                        .addComponent(LLocation)
                        .addGap(46, 46, 46)
                        .addComponent(LEquipment)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MidpLayout.setVerticalGroup(
            MidpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MidpLayout.createSequentialGroup()
                .addGroup(MidpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MidpLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MidpLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(MidpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUserRegister)
                            .addComponent(lbl_Project_Manager_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LSupplier)
                            .addComponent(LLocation)
                            .addComponent(LEquipment))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DisplayInf.setLayout(new java.awt.CardLayout());

        label2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label2.setText("Search");

        label3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label3.setText("EquipmentName");

        label4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label4.setText("PurchasDate");

        label5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label5.setText("Lacation");

        label6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label6.setText("Value");

        label7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label7.setText("SupplierID");

        TxtEQID.setEnabled(false);

        TxtEQName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtEQNameActionPerformed(evt);
            }
        });
        TxtEQName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtEQNameKeyPressed(evt);
            }
        });

        TxtValueEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtValueEqActionPerformed(evt);
            }
        });
        TxtValueEq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtValueEqKeyPressed(evt);
            }
        });

        jComboBoxSupIDEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSupIDEqActionPerformed(evt);
            }
        });

        jComboBoxLocationIDEQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLocationIDEQActionPerformed(evt);
            }
        });

        TblEq.setBackground(new java.awt.Color(204, 204, 204));
        TblEq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment ID", "EquipmentName", "Value", "PurchasDate", "Location", "Supplier"
            }
        ));
        TblEq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblEqMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TblEqMouseEntered(evt);
            }
        });
        jScrollPane3.setViewportView(TblEq);

        TxtSupIDEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSupIDEqActionPerformed(evt);
            }
        });

        TxtSearchEq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtSearchEqKeyReleased(evt);
            }
        });

        label8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label8.setText("EquipmentID");

        jTextField4.setBackground(new java.awt.Color(102, 102, 102));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel11.setText("Equipment");

        LblUpdateEq.setText("Update");
        LblUpdateEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LblUpdateEqActionPerformed(evt);
            }
        });

        lblDeleteEq.setText("Delete");
        lblDeleteEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblDeleteEqActionPerformed(evt);
            }
        });

        BtnSaveEq.setText("Save");
        BtnSaveEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveEqActionPerformed(evt);
            }
        });

        lblResetEq.setText("Reset");
        lblResetEq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblResetEqActionPerformed(evt);
            }
        });

        jButton3.setText("Print Sticker");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnViewReport.setText("View Reports");
        btnViewReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblDeleteEq, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(LblUpdateEq, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(BtnSaveEq, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblResetEq, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(btnViewReport)
                .addGap(169, 169, 169))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(LblUpdateEq)
                    .addComponent(lblDeleteEq)
                    .addComponent(BtnSaveEq)
                    .addComponent(lblResetEq)
                    .addComponent(jButton3)
                    .addComponent(btnViewReport))
                .addGap(27, 27, 27))
        );

        PurchasDate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout EquipmentLayout = new javax.swing.GroupLayout(Equipment);
        Equipment.setLayout(EquipmentLayout);
        EquipmentLayout.setHorizontalGroup(
            EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EquipmentLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EquipmentLayout.createSequentialGroup()
                        .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtEQID, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TxtSearchEq, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtEQName, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtValueEq, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PurchasDate, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                    .addComponent(txtpurchdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EquipmentLayout.createSequentialGroup()
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(261, 261, 261)
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EquipmentLayout.createSequentialGroup()
                        .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TxtLocIDEQ)
                            .addComponent(jComboBoxLocationIDEQ, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxSupIDEq, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtSupIDEq, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(126, 126, 126))
            .addGroup(EquipmentLayout.createSequentialGroup()
                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EquipmentLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        EquipmentLayout.setVerticalGroup(
            EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EquipmentLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EquipmentLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtEQID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtSearchEq, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(EquipmentLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtEQName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EquipmentLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(EquipmentLayout.createSequentialGroup()
                                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxLocationIDEQ)
                                    .addComponent(jComboBoxSupIDEq))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtLocIDEQ)
                                    .addComponent(TxtSupIDEq, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(EquipmentLayout.createSequentialGroup()
                                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(EquipmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PurchasDate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtValueEq, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpurchdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        DisplayInf.add(Equipment, "card4");

        Supplier.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                SupplierComponentShown(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Supplier");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1682, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jLabel16)
                .addGap(188, 188, 188))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("SupID");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setText("Contact No");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel6.setText("SupName");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setText("Address");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setText("BankAcc");

        TxtSupID.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TxtSupID.setEnabled(false);
        TxtSupID.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TxtSupIDComponentShown(evt);
            }
        });
        TxtSupID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSupIDActionPerformed(evt);
            }
        });
        TxtSupID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtSupIDKeyReleased(evt);
            }
        });

        TxtContactNo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TxtContactNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtContactNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtContactNoKeyReleased(evt);
            }
        });

        TxtSupName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TxtSupName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtSupNameActionPerformed(evt);
            }
        });
        TxtSupName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtSupNameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtSupNameKeyReleased(evt);
            }
        });

        TxtAddressSup.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TxtAddressSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtAddressSupActionPerformed(evt);
            }
        });
        TxtAddressSup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtAddressSupKeyReleased(evt);
            }
        });

        TxtBankAcc.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        TxtBankAcc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtBankAccKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtBankAccKeyReleased(evt);
            }
        });

        TblSupplier.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        TblSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SupName ", "ContactNo", "BankAcc", "Address"
            }
        ));
        TblSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblSupplier);

        BtnUpdateSup.setText("Update");
        BtnUpdateSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateSupActionPerformed(evt);
            }
        });

        BtnDeleteSup.setText("Delete");
        BtnDeleteSup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteSupActionPerformed(evt);
            }
        });

        btnResetSupplier.setText("Reset");
        btnResetSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetSupplierActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel17.setText("Search");

        SupSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SupSearchKeyReleased(evt);
            }
        });

        jTextField1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout SupplierLayout = new javax.swing.GroupLayout(Supplier);
        Supplier.setLayout(SupplierLayout);
        SupplierLayout.setHorizontalGroup(
            SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SupplierLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SupplierLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1697, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 466, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SupplierLayout.createSequentialGroup()
                .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SupplierLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SupplierLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(43, 43, 43)
                                .addComponent(TxtSupID, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SupplierLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(40, 40, 40)
                                .addComponent(SupSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(TxtSupName, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                            .addComponent(lbl_SupName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SupplierLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(TxtContactNo, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                                .addGap(53, 53, 53)
                                .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtBankAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addGroup(SupplierLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(lbl_SupContact, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(lbl_SupBankAcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(SupplierLayout.createSequentialGroup()
                        .addComponent(btnResetSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnUpdateSup, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(BtnDeleteSup, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SupplierLayout.createSequentialGroup()
                        .addComponent(lbl_SupAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(SupplierLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(TxtAddressSup, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        SupplierLayout.setVerticalGroup(
            SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SupplierLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SupplierLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtAddressSup, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_SupAddress))
                    .addGroup(SupplierLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SupplierLayout.createSequentialGroup()
                                .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(SupplierLayout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(TxtSupID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(SupSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17))))
                                .addGap(18, 18, 18)
                                .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnResetSupplier)
                                    .addComponent(BtnUpdateSup)
                                    .addComponent(BtnDeleteSup)
                                    .addComponent(btnSave)))
                            .addGroup(SupplierLayout.createSequentialGroup()
                                .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TxtSupName, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_SupName)
                                    .addComponent(lbl_SupContact)
                                    .addComponent(lbl_SupBankAcc)))
                            .addGroup(SupplierLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(TxtBankAcc, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        DisplayInf.add(Supplier, "card2");

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Location");

        btnResetLoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnResetLoc.setText("Reset");
        btnResetLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetLocActionPerformed(evt);
            }
        });

        btnUpdateLoction.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdateLoction.setText("Update");
        btnUpdateLoction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateLoctionActionPerformed(evt);
            }
        });

        btnSaveLocation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSaveLocation.setText("Save");
        btnSaveLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveLocationActionPerformed(evt);
            }
        });

        btnDeleteLocation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDeleteLocation.setText("Delete");
        btnDeleteLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel9)
                .addGap(868, 868, 868)
                .addComponent(btnResetLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(btnUpdateLoction, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnSaveLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(btnDeleteLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnResetLoc)
                            .addComponent(btnUpdateLoction)
                            .addComponent(btnSaveLocation)
                            .addComponent(btnDeleteLocation))
                        .addContainerGap())))
        );

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Location ID");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Location Name");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Project Name");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Coordinator");

        txtLoID.setEnabled(false);

        txtLocName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocNameActionPerformed(evt);
            }
        });
        txtLocName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocNameKeyReleased(evt);
            }
        });

        txtCoodinatorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCoodinatorNameActionPerformed(evt);
            }
        });
        txtCoodinatorName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCoodinatorNameKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Search");

        txtLoSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoSearchActionPerformed(evt);
            }
        });
        txtLoSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoSearchKeyReleased(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(102, 102, 102));

        CombProjectName_Loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CombProjectName_LocActionPerformed(evt);
            }
        });

        TxtProjectName_Loc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtProjectName_LocKeyReleased(evt);
            }
        });

        TblLocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "LocationName", "Project", "Coodinator"
            }
        ));
        TblLocation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblLocationMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TblLocation);

        Com_Coordinator.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Com_CoordinatorActionPerformed(evt);
            }
        });

        lbl_Coordinator.setText("jLabel21");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1876, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10)
                            .addComponent(txtLoID, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(txtLoSearch))
                        .addGap(92, 92, 92)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtLocName, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_LName, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(136, 136, 136)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtProjectName_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_ProjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(129, 129, 129)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCoodinatorName, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_Coordinator, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(505, 505, 505))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(CombProjectName_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(129, 129, 129)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Com_Coordinator, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(txtLoID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel13)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtLocName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CombProjectName_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Com_Coordinator, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtLoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(TxtProjectName_Loc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_LName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_ProjectName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txtCoodinatorName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13)
                                        .addComponent(lbl_Coordinator)))
                                .addGap(18, 18, 18))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout LocationLayout = new javax.swing.GroupLayout(Location);
        Location.setLayout(LocationLayout);
        LocationLayout.setHorizontalGroup(
            LocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LocationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1892, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        LocationLayout.setVerticalGroup(
            LocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LocationLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DisplayInf.add(Location, "card3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DisplayInf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Headingp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Midp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Headingp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(Midp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(DisplayInf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//To change panel using lable
    private void LSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LSupplierMouseClicked
        Supplier.setVisible(true);
        Location.setVisible(false);
        Equipment.setVisible(false);
    }//GEN-LAST:event_LSupplierMouseClicked

    private void LLocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LLocationMouseClicked
        Supplier.setVisible(false);
        Location.setVisible(true);
        Equipment.setVisible(false);
    }//GEN-LAST:event_LLocationMouseClicked

    private void LEquipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LEquipmentMouseClicked
        Supplier.setVisible(false);
        Location.setVisible(false);
        Equipment.setVisible(true);
    }//GEN-LAST:event_LEquipmentMouseClicked

    private void btnViewReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewReportActionPerformed
       Equipment_Buying_Expenses_Report field=new Equipment_Buying_Expenses_Report();
                field.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_btnViewReportActionPerformed


    //.......................Location Reg...........................//

    private void TblLocationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblLocationMouseClicked
        int i = TblLocation.getSelectedRow();
        TableModel model = TblLocation.getModel();
        txtLocName.setText(model.getValueAt(i, 0).toString());
        TxtProjectName_Loc.setText(model.getValueAt(i, 1).toString());
        txtCoodinatorName.setText(model.getValueAt(i, 2).toString());
        
        boolean a = TblLocation.isEditing();
        
        if(a==false){
            JOptionPane.showMessageDialog(null, "You can not edit this table ");
            
        }
        
    }//GEN-LAST:event_TblLocationMouseClicked

    private void btnUpdateLoctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLoctionActionPerformed
       try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
           /* int row = DisplayUserDetails.getSelectedRow();
            String value = (DisplayUserDetails.getModel().getValueAt(row, 0).toString());*/
            String query = "UPDATE Location_Reg_Table SET Location_Name = ?,Project_Name = ?,Coordinator_Name = ? where Location_ID =?";
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,txtLocName.getText());
            pst.setString(2,TxtProjectName_Loc.getText());
            pst.setString(3,txtCoodinatorName.getText());
            pst.setString(4,txtLoID.getText());
            
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblLocation.getModel();
            model.setRowCount(0);
            show_user1(); 
            JOptionPane.showMessageDialog(null, "Update sucessfully");
            
            
            }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
               
            txtLoSearch.setText("");
            txtLocName.setText("");
            TxtProjectName_Loc.setText("");
            txtCoodinatorName.setText("");
            txtLoID.setText("");
            
    }//GEN-LAST:event_btnUpdateLoctionActionPerformed

    private void btnDeleteLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteLocationActionPerformed
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query = "DELETE FROM Location_Reg_Table where Location_ID =?";
            
            PreparedStatement pst = con.prepareStatement(query);
 
            pst.setString(1,txtLoID.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblLocation.getModel();
            model.setRowCount(0);
            show_user1();
            JOptionPane.showMessageDialog(null, "Deleted sucessfully");
            
           txtLoID.setText("");
           txtLocName.setText("");
           TxtProjectName_Loc.setText("");
           txtCoodinatorName.setText("");
           txtLoSearch.setText("");
        
        }
        catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }                       

        
    }//GEN-LAST:event_btnDeleteLocationActionPerformed
    
    private void btnResetLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetLocActionPerformed
        // TODO add your handling code here:
        txtLoID.setText("");
        txtLocName.setText("");
        TxtProjectName_Loc.setText("");
        txtCoodinatorName.setText("");
        

    }//GEN-LAST:event_btnResetLocActionPerformed

    private void btnSaveLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveLocationActionPerformed
        
                String Name = txtLocName.getText();
                String ContactNo = TxtProjectName_Loc.getText();
                String BankAcc = txtCoodinatorName.getText();
        
                if(txtLocName.getText().trim().isEmpty() && TxtProjectName_Loc.getText().trim().isEmpty() && txtCoodinatorName.getText().trim().isEmpty()){
                     lbl_LName.setText("Please enter Location Name....");
                     lbl_ProjectName.setText("Please enter Project Name....");
                     lbl_Coordinator.setText("Please enter Coordinator name....");
                   
                     
                 }
             else if (txtLocName.getText().trim().isEmpty()){
                     lbl_LName.setText("Please enter Location Name....") ;
                 }
             else if (TxtProjectName_Loc.getText().trim().isEmpty()){
                     lbl_ProjectName.setText("Please enter Project Name....");
                 }
             else if (txtCoodinatorName.getText().trim().isEmpty()){
                     lbl_Coordinator.setText("Please enter Coordinator name....");
                 }
            
        else

           try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            Statement stat1 = con.createStatement();
            String selectQuery1 = "select Location_Name from Location_Reg_Table where Location_Name='" + Name + "'";
            ResultSet rs = stat1.executeQuery(selectQuery1);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Already registered");
                return;
            }
             
            {
            String query = "insert into Location_Reg_Table(Location_Name, Project_Name, Coordinator_Name )values(?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,txtLocName.getText());
            pst.setString(2,TxtProjectName_Loc.getText());
            pst.setString(3,txtCoodinatorName.getText());
            
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblLocation.getModel();
            model.setRowCount(0);
            show_user1();
            JOptionPane.showMessageDialog(null, "Save sucessfully");
            }

            }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
        txtLoID.setText("");
        txtLocName.setText("");
        TxtProjectName_Loc.setText("");
        txtCoodinatorName.setText("");

    }//GEN-LAST:event_btnSaveLocationActionPerformed
     
    
    
    private void lblUserRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblUserRegisterMouseClicked
                 UserRegister field=new UserRegister();
                field.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_lblUserRegisterMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
                String Name = TxtSupName.getText();
                String ContactNo = TxtContactNo.getText();
                String BankAcc = TxtBankAcc.getText();
                 String Address = TxtAddressSup.getText();
        
        
                if(TxtSupName.getText().trim().isEmpty() && TxtContactNo.getText().trim().isEmpty() && TxtBankAcc.getText().trim().isEmpty()&& TxtAddressSup.getText().trim().isEmpty()){
                     lbl_SupName.setText("Please enter Supplier name....");
                     lbl_SupContact.setText("Please enter Contact number....");
                     lbl_SupBankAcc.setText("Please enter Bank details....");
                     lbl_SupAddress.setText("Please enter Address....");
                     
                 }
             else if (TxtSupName.getText().trim().isEmpty()){
                     lbl_SupName.setText("Please enter Supplier name....") ;
                 }
             else if (TxtContactNo.getText().trim().isEmpty()){
                     lbl_SupContact.setText("Please enter Contact number....");
                 }
             else if (TxtBankAcc.getText().trim().isEmpty()){
                     lbl_SupBankAcc.setText("Please enter Bank details....");
                 }
             else if (TxtAddressSup.getText().trim().isEmpty()){ 
                     lbl_SupAddress.setText("Please enter Address....");
                 }
             else

           try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            Statement stat1 = con.createStatement();
            String selectQuery1 = "select Sup_Name from Sup_Reg_Table where Sup_Name='" + Name + "'";
            ResultSet rs = stat1.executeQuery(selectQuery1);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(null,"Already registered");
                return;
            }
            else
            {
            String query = "insert into Sup_Reg_Table(Sup_Name, Contact_No, BankDetails,Address )values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,TxtSupName.getText());
            pst.setString(2,TxtContactNo.getText());
            pst.setString(3,TxtBankAcc.getText());
            pst.setString(4,TxtAddressSup.getText());
//            pst.setString(5,Time_Sup.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblSupplier.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Save sucessfully");
            }

            }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
       TxtSupID.setText("");
        TxtContactNo.setText("");
        TxtSupName.setText("");
        TxtBankAcc.setText("");
        TxtAddressSup.setText("");
    }//GEN-LAST:event_btnSaveActionPerformed
    
    private void btnResetSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetSupplierActionPerformed
        TxtSupID.setText("");
        TxtContactNo.setText("");
        TxtSupName.setText("");
        TxtBankAcc.setText("");
        TxtAddressSup.setText("");

    }//GEN-LAST:event_btnResetSupplierActionPerformed

    private void BtnDeleteSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteSupActionPerformed
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query = "DELETE FROM Sup_Reg_Table where Sup_ID =?";
            
            PreparedStatement pst = con.prepareStatement(query);
 
            pst.setString(1,TxtSupID.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblSupplier.getModel();
            model.setRowCount(0);
            show_user();
            JOptionPane.showMessageDialog(null, "Deleted sucessfully");
            
            TxtSupID.setText("");
            TxtContactNo.setText("");
            TxtSupName.setText("");
            TxtBankAcc.setText("");
            TxtAddressSup.setText("");
            SupSearch.setText("");
        
        }
        catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }                                         
    
    }//GEN-LAST:event_BtnDeleteSupActionPerformed

    private void BtnUpdateSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateSupActionPerformed
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
           /* int row = DisplayUserDetails.getSelectedRow();
            String value = (DisplayUserDetails.getModel().getValueAt(row, 0).toString());*/
            String query = "UPDATE Sup_Reg_Table SET Sup_Name = ?,Contact_No = ?,BankDetails = ?,Address = ? where Sup_ID =?";
            
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,TxtSupName.getText());
            pst.setString(2,TxtContactNo.getText());
            pst.setString(3,TxtBankAcc.getText());
            pst.setString(4,TxtAddressSup.getText());
            pst.setString(5,TxtSupID.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblSupplier.getModel();
            model.setRowCount(0);
            show_user(); 
            JOptionPane.showMessageDialog(null, "Update sucessfully");
            
            
            }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
               
            TxtSupID.setText("");
            TxtContactNo.setText("");
            TxtSupName.setText("");
            TxtBankAcc.setText("");
            TxtAddressSup.setText("");
            SupSearch.setText("");
                                                    
                                          

    }//GEN-LAST:event_BtnUpdateSupActionPerformed

    private void TblSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblSupplierMouseClicked
 int i = TblSupplier.getSelectedRow();
        TableModel model = TblSupplier.getModel();
        TxtSupName.setText(model.getValueAt(i, 0).toString());
        TxtContactNo.setText(model.getValueAt(i, 1).toString());
        TxtBankAcc.setText(model.getValueAt(i, 2).toString());
        TxtAddressSup.setText(model.getValueAt(i, 3).toString());
        
        boolean a = TblSupplier.isEditing();
        
        if(a==false){
            JOptionPane.showMessageDialog(null, "You can not edit this table ");
            
        }
    }//GEN-LAST:event_TblSupplierMouseClicked

    private void TxtAddressSupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtAddressSupActionPerformed
       
    }//GEN-LAST:event_TxtAddressSupActionPerformed

    private void TxtSupIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSupIDActionPerformed

    }//GEN-LAST:event_TxtSupIDActionPerformed

    private void TxtSupIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSupIDKeyReleased
                          

    }//GEN-LAST:event_TxtSupIDKeyReleased

    private void TxtSupIDComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TxtSupIDComponentShown
          
    }//GEN-LAST:event_TxtSupIDComponentShown
 
    private void SupplierComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_SupplierComponentShown
       
    }//GEN-LAST:event_SupplierComponentShown

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        
    }//GEN-LAST:event_jPanel1ComponentShown

    private void TxtSupNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSupNameKeyReleased
       lbl_SupName.setText("");
    }//GEN-LAST:event_TxtSupNameKeyReleased

    private void TxtContactNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtContactNoKeyReleased
       lbl_SupContact.setText("");
    }//GEN-LAST:event_TxtContactNoKeyReleased

    private void TxtBankAccKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBankAccKeyReleased
        lbl_SupBankAcc.setText("");
    }//GEN-LAST:event_TxtBankAccKeyReleased

    private void TxtAddressSupKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAddressSupKeyReleased
         lbl_SupAddress.setText("");
    }//GEN-LAST:event_TxtAddressSupKeyReleased

    private void SupSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SupSearchKeyReleased
       try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String sql = "select * from Sup_Reg_Table where Sup_Name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, SupSearch.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String setSup_Name =rs.getString("Sup_Name");
                TxtSupName.setText(setSup_Name);
                
                String setContact_No =rs.getString("Contact_No");
                TxtContactNo.setText(setContact_No);
                
                String setBankDetails =rs.getString("BankDetails");
                TxtBankAcc.setText(setBankDetails);
                
                String setAddress =rs.getString("Address");
                TxtAddressSup.setText(setAddress);
                
                 String setSup_ID =rs.getString("Sup_ID");
                TxtSupID.setText(setSup_ID);
                
             
            }
             
             
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    } 
    }//GEN-LAST:event_SupSearchKeyReleased

    private void CombProjectName_LocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CombProjectName_LocActionPerformed
        String selectedValue = CombProjectName_Loc.getSelectedItem().toString();

        //How to set this delected value into textField

        TxtProjectName_Loc.setText((selectedValue));
            lbl_ProjectName.setText("");                                             

    }//GEN-LAST:event_CombProjectName_LocActionPerformed

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
                                     
       
        
      
    }//GEN-LAST:event_jPanel2ComponentShown

    private void txtCoodinatorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCoodinatorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoodinatorNameActionPerformed

    private void txtLocNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocNameActionPerformed

    private void TxtSupNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSupNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSupNameActionPerformed

    private void txtLocNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocNameKeyReleased
        lbl_LName.setText("");
    }//GEN-LAST:event_txtLocNameKeyReleased

    private void TxtProjectName_LocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtProjectName_LocKeyReleased
       lbl_ProjectName.setText("");
    }//GEN-LAST:event_TxtProjectName_LocKeyReleased

    private void txtCoodinatorNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoodinatorNameKeyReleased
        lbl_Coordinator.setText("");
    }//GEN-LAST:event_txtCoodinatorNameKeyReleased

    private void txtLoSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoSearchActionPerformed

    private void txtLoSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoSearchKeyReleased
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String sql = "select * from Location_Reg_Table where Location_Name = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, txtLoSearch.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String setLocation_Name=rs.getString("Location_Name");
                txtLocName.setText(setLocation_Name);
                
                String setProject_Name =rs.getString("Project_Name");
                TxtProjectName_Loc.setText(setProject_Name);
                
                String setCoordinator_Name =rs.getString("Coordinator_Name");
                txtCoodinatorName.setText(setCoordinator_Name);
                
                String setLocation_ID =rs.getString("Location_ID");
                txtLoID.setText(setLocation_ID);
        
            }
             
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    } 
    }//GEN-LAST:event_txtLoSearchKeyReleased

    private void lblResetEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblResetEqActionPerformed
        // TODO add your handling code here:

        TxtEQID.setText("");
        TxtEQName.setText("");
        PurchasDate.setDateFormatString("");
        TxtValueEq.setText("");
        //        TxtTimeEq.setText("");
        //        TxtDateEq.setText("");
        TxtLocIDEQ.setText("");
        TxtSupIDEq.setText("");
    }//GEN-LAST:event_lblResetEqActionPerformed
/*...................EQUIPMENT REGISTRATION....................................*/
    
    private void LblUpdateEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LblUpdateEqActionPerformed
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
           /* int row = DisplayUserDetails.getSelectedRow();
            String value = (DisplayUserDetails.getModel().getValueAt(row, 0).toString());*/
            String query = "UPDATE Equipment_Reg_Table SET Equipment_Name = ?,Value = ?,PurchasDate = ?,Location = ?,Supplier = ? where EquipmentID =?";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(PurchasDate.getDate());
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,TxtEQName.getText());
            pst.setString(2,TxtValueEq.getText());
            pst.setString(3, date);
            pst.setString(4,TxtLocIDEQ.getText());
            pst.setString(5,TxtSupIDEq.getText());
            pst.setString(6,TxtEQID.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblEq.getModel();
            model.setRowCount(0);
            show_user2(); 
            JOptionPane.showMessageDialog(null, "Update sucessfully");
            
            TxtEQID.setText("");
            TxtEQName.setText("");
            PurchasDate.setDateFormatString("");
            TxtValueEq.setText("");
            TxtLocIDEQ.setText("");
            TxtSupIDEq.setText("");
            
            
            }
         catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
             
         }
    }//GEN-LAST:event_LblUpdateEqActionPerformed

    private void lblDeleteEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblDeleteEqActionPerformed
            try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query = "DELETE FROM Equipment_Reg_Table where EquipmentID =?";
            
            PreparedStatement pst = con.prepareStatement(query);
 
            pst.setString(1,TxtEQID.getText());
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblEq.getModel();
            model.setRowCount(0);
            show_user2();
            JOptionPane.showMessageDialog(null, "Deleted sucessfully");
            
            TxtEQID.setText("");
            TxtEQName.setText("");
            PurchasDate.setDateFormatString("");
            TxtValueEq.setText("");
            TxtLocIDEQ.setText("");
            TxtSupIDEq.setText("");
            
        
        }
        catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }                                         
    
    }//GEN-LAST:event_lblDeleteEqActionPerformed

    private void BtnSaveEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveEqActionPerformed
        

           try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            {
            String query = "insert into Equipment_Reg_Table(Equipment_Name,Value,PurchasDate,Location,Supplier)values(?,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(query);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(PurchasDate.getDate());
            pst.setString(1,TxtEQName.getText());
            pst.setString(2,TxtValueEq.getText());
            pst.setString(3, date);
            pst.setString(4,TxtLocIDEQ.getText());
            pst.setString(5,TxtSupIDEq.getText());
            
            pst.executeUpdate();
            DefaultTableModel model = (DefaultTableModel)TblEq.getModel();
            
            model.setRowCount(0);
            show_user2();
            JOptionPane.showMessageDialog(null, "Save sucessfully");
            }

            }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
           
        TxtEQID.setText("");
        TxtEQName.setText("");
        PurchasDate.setDateFormatString("");
        TxtValueEq.setText("");
        TxtLocIDEQ.setText("");
        TxtSupIDEq.setText("");
            
    }//GEN-LAST:event_BtnSaveEqActionPerformed

    
    private void TblEqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblEqMouseClicked
        int i = TblEq.getSelectedRow();
        TableModel model = TblEq.getModel();
//        TxtEQID.setText(model.getValueAt(i, 0).toString());
        TxtEQName.setText(model.getValueAt(i, 0).toString());
        TxtValueEq.setText(model.getValueAt(i, 1).toString());
        txtpurchdate.setText(model.getValueAt(i, 2).toString());
        TxtLocIDEQ.setText(model.getValueAt(i, 3).toString());
        TxtSupIDEq.setText(model.getValueAt(i, 4).toString());
        
        
        boolean a = TblEq.isEditing();
        
        if(a==false){
            JOptionPane.showMessageDialog(null, "You can not edit this table ");
            
        }
    }//GEN-LAST:event_TblEqMouseClicked

    private void jComboBoxLocationIDEQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLocationIDEQActionPerformed
              String selectedValue = jComboBoxLocationIDEQ.getSelectedItem().toString();

        //How to set this delected value into textField

        TxtLocIDEQ.setText((selectedValue));
            
        lbl_ProjectName.setText(""); 
    }//GEN-LAST:event_jComboBoxLocationIDEQActionPerformed

    private void jComboBoxSupIDEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSupIDEqActionPerformed
        // TODO add your handling code here:
        String selectedValue = jComboBoxSupIDEq.getSelectedItem().toString();

        //How to set this delected value into textField

        TxtSupIDEq.setText((selectedValue));

    }//GEN-LAST:event_jComboBoxSupIDEqActionPerformed

    private void TxtValueEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtValueEqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtValueEqActionPerformed

    private void TblEqMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblEqMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_TblEqMouseEntered

    private void TxtSupIDEqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtSupIDEqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtSupIDEqActionPerformed

    private void TxtEQNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtEQNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtEQNameActionPerformed

    private void TxtSearchEqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSearchEqKeyReleased
       try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String sql = "select * from Equipment_Reg_Table where EquipmentID = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, TxtSearchEq.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                String setEquipment_Name =rs.getString("Equipment_Name");
                TxtEQName.setText(setEquipment_Name);
                
                Date setPurchasDate =rs.getDate("PurchasDate");
                PurchasDate.setDate(setPurchasDate);
                
                String setValue =rs.getString("Value");
                TxtValueEq.setText(setValue);
                
                String setLocation =rs.getString("Location");
                TxtLocIDEQ.setText(setLocation);
                
                String setSupplier =rs.getString("Supplier");
                TxtSupIDEq.setText(setSupplier);
                
                 String setEquipmentID =rs.getString("EquipmentID");
                TxtEQID.setText(setEquipmentID);
             
            }
              
             
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    } 
                          
    }//GEN-LAST:event_TxtSearchEqKeyReleased

    private void lbl_Project_Manager_RegMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_Project_Manager_RegMouseClicked
        Project_Manager field = null;
        field = new Project_Manager();
                field.setVisible(true);
                setVisible(false);
     
    }//GEN-LAST:event_lbl_Project_Manager_RegMouseClicked

    private void Com_CoordinatorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Com_CoordinatorActionPerformed
         String selectedValue = Com_Coordinator.getSelectedItem().toString();

        //How to set this delected value into textField

        txtCoodinatorName.setText((selectedValue));
            lbl_Coordinator.setText("");  
    }//GEN-LAST:event_Com_CoordinatorActionPerformed

    private void TxtEQNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtEQNameKeyPressed
        int key = evt.getKeyCode();
        if(key==10) {
        TxtValueEq.requestFocus();
    }//GEN-LAST:event_TxtEQNameKeyPressed
    }
    private void TxtValueEqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtValueEqKeyPressed
        int key = evt.getKeyCode();
        if(key==10) {
        PurchasDate.requestFocus();
    }      
    }//GEN-LAST:event_TxtValueEqKeyPressed

    private void TxtSupNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSupNameKeyPressed
       int key = evt.getKeyCode();
        if(key==10) {
        TxtContactNo.requestFocus();
    }//GEN-LAST:event_TxtSupNameKeyPressed
    }
    private void TxtBankAccKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBankAccKeyPressed
       int key = evt.getKeyCode();
        if(key==10) {
        TxtAddressSup.requestFocus();
        }
    }//GEN-LAST:event_TxtBankAccKeyPressed

    private void TxtContactNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtContactNoKeyPressed
        int key = evt.getKeyCode();
        if(key==10) {
        TxtBankAcc.requestFocus();
    }//GEN-LAST:event_TxtContactNoKeyPressed
    }
    private void BackadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackadminActionPerformed
       Administrator field=new Administrator();
                field.setVisible(true);
                setVisible(false);
    }//GEN-LAST:event_BackadminActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String msg = TxtEQID.getText();
        new Sticker2(msg).setVisible(true);
        
        
        
//         Sticker2 field=new Sticker2();
//                field.setVisible(true);
//                setVisible(false);
//                
    }//GEN-LAST:event_jButton3ActionPerformed
    
    public static void main(String args[]) {
        try {

    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
      if ("Nimbus".equals(info.getName())) {
        javax.swing.UIManager.setLookAndFeel(info.getClassName());
        break;
      }
    }
  } catch (ClassNotFoundException ex) {
    java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (InstantiationException ex) {
    java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (IllegalAccessException ex) {
    java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
  }

        java.awt.EventQueue.invokeLater(() -> {
            new Admin().setVisible(true);
            
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton Backadmin;
    javax.swing.JButton BtnDeleteSup;
    javax.swing.JButton BtnSaveEq;
    javax.swing.JButton BtnUpdateSup;
    javax.swing.JComboBox<String> Com_Coordinator;
    javax.swing.JComboBox<String> CombProjectName_Loc;
    javax.swing.JPanel DisplayInf;
    javax.swing.JPanel Equipment;
    javax.swing.JPanel Headingp;
    javax.swing.JLabel LEquipment;
    javax.swing.JLabel LLocation;
    javax.swing.JLabel LSupplier;
    javax.swing.JButton LblUpdateEq;
    javax.swing.JPanel Location;
    javax.swing.JPanel Midp;
    com.toedter.calendar.JDateChooser PurchasDate;
    javax.swing.JTextField SupSearch;
    javax.swing.JPanel Supplier;
    javax.swing.JTable TblEq;
    javax.swing.JTable TblLocation;
    javax.swing.JTable TblSupplier;
    javax.swing.JTextField TxtAddressSup;
    javax.swing.JTextField TxtBankAcc;
    javax.swing.JTextField TxtContactNo;
    javax.swing.JTextField TxtEQID;
    javax.swing.JTextField TxtEQName;
    javax.swing.JTextField TxtLocIDEQ;
    javax.swing.JTextField TxtProjectName_Loc;
    javax.swing.JTextField TxtSearchEq;
    javax.swing.JTextField TxtSupID;
    javax.swing.JTextField TxtSupIDEq;
    javax.swing.JTextField TxtSupName;
    javax.swing.JTextField TxtValueEq;
    javax.swing.JButton btnDeleteLocation;
    javax.swing.JButton btnResetLoc;
    javax.swing.JButton btnResetLocation1;
    javax.swing.JButton btnResetSupplier;
    javax.swing.JButton btnSave;
    javax.swing.JButton btnSaveLocation;
    javax.swing.JButton btnUpdateLoction;
    javax.swing.JButton btnViewReport;
    javax.swing.JButton jButton2;
    javax.swing.JButton jButton3;
    javax.swing.JComboBox<String> jComboBoxLocationIDEQ;
    javax.swing.JComboBox<String> jComboBoxSupIDEq;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel11;
    javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel13;
    javax.swing.JLabel jLabel14;
    javax.swing.JLabel jLabel15;
    javax.swing.JLabel jLabel16;
    javax.swing.JLabel jLabel17;
    javax.swing.JLabel jLabel18;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel5;
    javax.swing.JPanel jPanel6;
    javax.swing.JPanel jPanel7;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JScrollPane jScrollPane3;
    javax.swing.JSeparator jSeparator1;
    javax.swing.JSeparator jSeparator2;
    javax.swing.JSeparator jSeparator3;
    javax.swing.JTextField jTextField1;
    javax.swing.JTextField jTextField2;
    javax.swing.JTextField jTextField4;
    java.awt.Label label1;
    java.awt.Label label2;
    java.awt.Label label3;
    java.awt.Label label4;
    java.awt.Label label5;
    java.awt.Label label6;
    java.awt.Label label7;
    java.awt.Label label8;
    javax.swing.JButton lblDeleteEq;
    javax.swing.JButton lblResetEq;
    javax.swing.JLabel lblUserRegister;
    javax.swing.JLabel lbl_Coordinator;
    javax.swing.JLabel lbl_LName;
    javax.swing.JLabel lbl_ProjectName;
    javax.swing.JLabel lbl_Project_Manager_Reg;
    javax.swing.JLabel lbl_SupAddress;
    javax.swing.JLabel lbl_SupBankAcc;
    javax.swing.JLabel lbl_SupContact;
    javax.swing.JLabel lbl_SupName;
    javax.swing.JTextField txtCoodinatorName;
    javax.swing.JTextField txtLoID;
    javax.swing.JTextField txtLoSearch;
    javax.swing.JTextField txtLocName;
    javax.swing.JTextField txtpurchdate;
    // End of variables declaration//GEN-END:variables

}
