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
public class Item_Transfer_Report extends javax.swing.JFrame {

    /**
     * Creates new form Item_Transfer_Report
     */
    public Item_Transfer_Report() {
        initComponents();
         show_user();
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
                
    
        public ArrayList<ItemTransfer>userList(){
        ArrayList<ItemTransfer> userList = new ArrayList<>();
            
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM Item_Transfer_View_1";
            Statement st= con.createStatement();
            ResultSet rs1= st.executeQuery(query1);
            ItemTransfer itemtransfer;
            while(rs1.next()){
                itemtransfer=new ItemTransfer(rs1.getString("Job_No"),rs1.getString("Equipment_ID"),rs1.getString("Equipment_Name"),rs1.getString("Transfered_Date"),rs1.getString("Location_Name"));
                userList.add(itemtransfer);
         
            }
    
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList;
    }
    public void show_user(){
        ArrayList<ItemTransfer> list = userList();
        DefaultTableModel model = (DefaultTableModel)Item_T_Report.getModel();
        Object[] row = new Object[5];
        
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getJob_No();
            row[1]=list.get(i).getEquipment_ID();
            row[2]=list.get(i).getEquipment_Name();
            row[3]=list.get(i).getTransfered_Date();
            row[4]=list.get(i).getLocation_Name();
                  
           
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
        jLabel1 = new javax.swing.JLabel();
        jTextField1_SearchIT = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        LblPrintIT = new javax.swing.JLabel();
        jButton1ResetIT = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Item_T_Report = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        Time25 = new javax.swing.JLabel();
        Date23 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Search");

        jTextField1_SearchIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1_SearchITKeyReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oems/search (1).png"))); // NOI18N

        LblPrintIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oems/print (2).png"))); // NOI18N
        LblPrintIT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblPrintITMouseClicked(evt);
            }
        });
        LblPrintIT.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                LblPrintITComponentShown(evt);
            }
        });

        jButton1ResetIT.setText("Reset");
        jButton1ResetIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ResetITActionPerformed(evt);
            }
        });

        Item_T_Report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job_No", "Equipment_ID", "Equipment_Name", "Transfer_Date", "Location_Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Item_T_Report.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(Item_T_Report);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Item Transfer - Report");

        Time25.setText("jLabel5");

        Date23.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(253, 253, 253)
                        .addComponent(Date23, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Time25, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 827, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Time25)
                        .addComponent(Date23))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1_SearchIT, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(LblPrintIT)
                .addGap(18, 18, 18)
                .addComponent(jButton1ResetIT)
                .addGap(139, 139, 139))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1_SearchIT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblPrintIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1ResetIT, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1_SearchITKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_SearchITKeyReleased
        DefaultTableModel table = (DefaultTableModel)Item_T_Report.getModel();
        String search = jTextField1_SearchIT.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter <DefaultTableModel>(table);
        Item_T_Report.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));

       
    }//GEN-LAST:event_jTextField1_SearchITKeyReleased

    private void LblPrintITMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblPrintITMouseClicked
//        MessageFormat header = new MessageFormat("Report print");
//
//        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
//
//        try{
//            Item_T_Report.print(JTable.PrintMode.NORMAL, header,footer);
//
//        } catch (PrinterException ex) {
//            Logger.getLogger(Item_Transfer_Report.class.getName()).log(Level.SEVERE, null, ex);
//        }
         Toolkit tkp = jPanel1.getToolkit();
        PrintJob pjp = tkp.getPrintJob(this, null, null);
        Graphics g = pjp.getGraphics();
        jPanel1.print(g);
        g.dispose();
        pjp.end();

    }//GEN-LAST:event_LblPrintITMouseClicked

    private void jButton1ResetITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ResetITActionPerformed
        this.dispose();
        Item_Transfer_Report u = new Item_Transfer_Report();
        u.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ResetITActionPerformed

    private void LblPrintITComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_LblPrintITComponentShown
       
    }//GEN-LAST:event_LblPrintITComponentShown

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
            java.util.logging.Logger.getLogger(Item_Transfer_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Item_Transfer_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Item_Transfer_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Item_Transfer_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Item_Transfer_Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date23;
    private javax.swing.JTable Item_T_Report;
    private javax.swing.JLabel LblPrintIT;
    private javax.swing.JLabel Time25;
    private javax.swing.JButton jButton1ResetIT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1_SearchIT;
    // End of variables declaration//GEN-END:variables
}