/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author sachini
 */
public class Equipment_Buying_Expenses_Report extends javax.swing.JFrame {

    
    public Equipment_Buying_Expenses_Report() {
        initComponents();
        show_user();
        tsum1.setText(Double.toString(getsum()));
        showDate ();
        showTime ();
    }
  
     void showDate (){
      Date d = new Date ();  
      SimpleDateFormat s = new SimpleDateFormat ("yyyy-MM-dd");
      Date23.setText(s.format(d));
    }
    
    void showTime(){
        new Timer (0, new ActionListener()    {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                Time25.setText(s.format(d));
            }

            private SimpleDateFormat SimpleDateFormat(String hhmmss_s) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        }).start();  
            
            
    }
  public ArrayList<EE_Report>userList(){
        ArrayList<EE_Report> userList = new ArrayList<>();
            
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM View_1_Equipment_Reg_Table";
            Statement st= con.createStatement();
            ResultSet rs1= st.executeQuery(query1);
            EE_Report ee_report;
            while(rs1.next()){
                ee_report=new EE_Report(rs1.getString("EquipmentID"),rs1.getString("Equipment_Name"),rs1.getString("Value"),rs1.getString("PurchasDate"),rs1.getString("Location"),rs1.getString("Supplier"));
                userList.add(ee_report);
               
            }
    
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList;
    }
    public void show_user(){
        ArrayList<EE_Report> list = userList();
        DefaultTableModel model = (DefaultTableModel)EE_Table.getModel();
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        LblPrint = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EE_Table = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        tsum1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        Date23 = new javax.swing.JLabel();
        Time25 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Total Value");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel1.setText("Search");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oems/search (1).png"))); // NOI18N

        LblPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oems/print (2).png"))); // NOI18N
        LblPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblPrintMouseClicked(evt);
            }
        });

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        EE_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment ID", "Equipment_Name", "Value", "Purchas_Date", "Location", "Supplier"
            }
        ));
        EE_Table.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(EE_Table);
        if (EE_Table.getColumnModel().getColumnCount() > 0) {
            EE_Table.getColumnModel().getColumn(0).setHeaderValue("Equipment ID");
            EE_Table.getColumnModel().getColumn(1).setHeaderValue("Equipment_Name");
            EE_Table.getColumnModel().getColumn(2).setHeaderValue("Value");
            EE_Table.getColumnModel().getColumn(3).setHeaderValue("Purchas_Date");
            EE_Table.getColumnModel().getColumn(4).setHeaderValue("Location");
            EE_Table.getColumnModel().getColumn(5).setHeaderValue("Supplier");
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("New Equipment Expenses - Report");

        tsum1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Total Value");

        Date23.setText("jLabel3");

        Time25.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel6)
                .addGap(71, 71, 71)
                .addComponent(tsum1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addGap(172, 172, 172)
                        .addComponent(Date23)
                        .addGap(53, 53, 53)
                        .addComponent(Time25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Date23)
                    .addComponent(Time25))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(tsum1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addComponent(LblPrint)
                .addGap(35, 35, 35)
                .addComponent(jButton1)
                .addGap(149, 149, 149))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(LblPrint)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        DefaultTableModel table = (DefaultTableModel)EE_Table.getModel();
        String search = jTextField1.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter <DefaultTableModel>(table);
        EE_Table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));

        tsum1.setText(Double.toString(getsum()));

    }//GEN-LAST:event_jTextField1KeyReleased

    private void LblPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblPrintMouseClicked
//        MessageFormat header = new MessageFormat("Report print");
//
//        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
//
//        try{
//            EE_Table.print(JTable.PrintMode.NORMAL, header,footer);
//
//        } catch (PrinterException ex) {
//            Logger.getLogger(Service_and_repair_report.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Toolkit tkp = jPanel1.getToolkit();
        PrintJob pjp = tkp.getPrintJob(this, null, null);
        Graphics g = pjp.getGraphics();
        jPanel1.print(g);
        g.dispose();
        pjp.end();

    }//GEN-LAST:event_LblPrintMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        Equipment_Buying_Expenses_Report u = new Equipment_Buying_Expenses_Report();
        u.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Equipment_Buying_Expenses_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Equipment_Buying_Expenses_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Equipment_Buying_Expenses_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Equipment_Buying_Expenses_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Equipment_Buying_Expenses_Report().setVisible(true);
            }
        });
    }
     //total value
    public double getsum(){
    int rowsCount = EE_Table.getRowCount();
    int sum = 0;
    for (int i = 0;i<rowsCount;i++){
        sum=sum+Integer.parseInt(EE_Table.getValueAt(i,2).toString());
           // NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
    //String currency = format.format(sum);
    }
         return sum;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date23;
    private javax.swing.JTable EE_Table;
    private javax.swing.JLabel LblPrint;
    private javax.swing.JLabel Time25;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel tsum1;
    // End of variables declaration//GEN-END:variables
}
