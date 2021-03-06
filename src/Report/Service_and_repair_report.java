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
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author sachini
 */
public class Service_and_repair_report extends javax.swing.JFrame {


    public Service_and_repair_report() {
        initComponents();
        show_user();
         tsum.setText(Double.toString(getsum()));
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
        public ArrayList<RepairReport>userList(){
        ArrayList<RepairReport> userList = new ArrayList<>();
            
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM View_1_Repair";
            Statement st= con.createStatement();
            ResultSet rs1= st.executeQuery(query1);
            RepairReport repairreport;
            while(rs1.next()){
                repairreport=new RepairReport(rs1.getString("Job_No"),rs1.getString("Service_Date"),rs1.getString("Transection_Code"),rs1.getString("Value"),rs1.getString("Seivice_Description"),rs1.getString("Suppier_Name"),rs1.getString("Equipment_ID"),rs1.getString("Location_Name"),rs1.getString("Project_Name"),rs1.getString("Address"));
                userList.add(repairreport);
                
            }
    
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList;
    }
    public void show_user(){
        ArrayList<RepairReport> list = userList();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        Object[] row = new Object[10];
        
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getJob_No();
            row[1]=list.get(i).getService_Date();
            row[2]=list.get(i).getTransection_Code();
            row[3]=list.get(i).getValue();
            row[4]=list.get(i).getSeivice_Description();
            row[5]=list.get(i).getSuppier_Name();
            row[6]=list.get(i).getEquipment_ID();
            row[7]=list.get(i).getLocation_Name();
            row[8]=list.get(i).getProject_Name();
            row[9]=list.get(i).getAddress();
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

        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        LblPrint = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tsum = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Date23 = new javax.swing.JLabel();
        Time25 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel1.setText("Search");

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        LblPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oems/print (2).png"))); // NOI18N
        LblPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblPrintMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oems/search (1).png"))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Service Date", "Transsaction code", "Value ", "Service Description", "Supplier Name", "Equipment ID", "Location Name", "Project Name", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Breakedown repair - Report");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Total Value");

        tsum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        Date23.setText("jLabel5");

        Time25.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1479, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(809, 809, 809)
                                .addComponent(Date23)
                                .addGap(88, 88, 88)
                                .addComponent(Time25)
                                .addGap(119, 119, 119))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator2)
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addComponent(tsum, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(336, 336, 336))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Date23)
                        .addComponent(Time25))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2))
                    .addComponent(tsum, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(31, 31, 31)
                .addComponent(LblPrint)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1495, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
          DefaultTableModel table = (DefaultTableModel)jTable1.getModel();
          String search = jTextField1.getText();
          TableRowSorter<DefaultTableModel> tr = new TableRowSorter <DefaultTableModel>(table);
          jTable1.setRowSorter(tr);
          tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));
        

tsum.setText(Double.toString(getsum()));
 
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            this.dispose();
           Service_and_repair_report u = new Service_and_repair_report();
           u.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void LblPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblPrintMouseClicked
//      MessageFormat header = new MessageFormat("Report print");
//      
//      MessageFormat footer = new MessageFormat("Page{0,number,integer}");
//        
//        try{
//            jTable1.print(JTable.PrintMode.NORMAL, header,footer);
//          
//        } catch (PrinterException ex) {
//            Logger.getLogger(Service_and_repair_report.class.getName()).log(Level.SEVERE, null, ex);
//        }
        PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("print Data");
            
            job.setPrintable(new Printable() {
            public int print(Graphics pg,PageFormat pf, int pageName){
                pf.setOrientation(PageFormat.LANDSCAPE);
              if(pageName>0){
                  return Printable.NO_SUCH_PAGE;
              }
              
              java.awt.Graphics2D g2 = (java.awt.Graphics2D)pg;
              g2.translate(pf.getImageableX(), pf.getImageableY());
              g2.scale(0.52,0.75);
              
              jPanel1.paint(g2);
              
              return Printable.PAGE_EXISTS;
            
            }
            });
            
            boolean ok = job.printDialog();
            if(ok){
                try{
                    
                   job.print();
                }
                catch (PrinterException ex){}
                }
            
    }//GEN-LAST:event_LblPrintMouseClicked

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
            java.util.logging.Logger.getLogger(Service_and_repair_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Service_and_repair_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Service_and_repair_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Service_and_repair_report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Service_and_repair_report().setVisible(true);
            }
        });
    }
    //total value
    public double getsum(){
    int rowsCount = jTable1.getRowCount();
    int sum = 0;
    for (int i = 0;i<rowsCount;i++){
        sum=sum+Integer.parseInt(jTable1.getValueAt(i,3).toString());
           // NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
    //String currency = format.format(sum);
    }

    return sum;
    
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date23;
    private javax.swing.JLabel LblPrint;
    private javax.swing.JLabel Time25;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel tsum;
    // End of variables declaration//GEN-END:variables
}
