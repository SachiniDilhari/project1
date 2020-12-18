/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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

public class preventive_Service_Report extends javax.swing.JFrame {

    public preventive_Service_Report() {
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
  public ArrayList<PS_Report>userList(){
        ArrayList<PS_Report> userList = new ArrayList<>();
            
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=EMS;user=sa;password=4470";
            Connection con = DriverManager.getConnection(url);
            String query1="SELECT * FROM View_1_Preventive_Service";
            Statement st= con.createStatement();
            ResultSet rs1= st.executeQuery(query1);
            PS_Report ps_report;
            while(rs1.next()){
                ps_report=new PS_Report(rs1.getString("Job_No"),rs1.getString("Service_Date"),rs1.getString("Service_catagory"),rs1.getString("Equipment_ID"),rs1.getString("Equipment_Name"),rs1.getString("Location"),rs1.getString("Value_Of_Service"));
                userList.add(ps_report);
               
            }
    
         }
      catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
    }
      return userList;
    }
    public void show_user(){
        ArrayList<PS_Report> list = userList();
        DefaultTableModel model = (DefaultTableModel)Tbl_PS_Report.getModel();
        Object[] row = new Object[10];
        
        for(int i = 0; i<list.size();i++){
            row[0]=list.get(i).getJob_No();
            row[1]=list.get(i).getService_Date();
            row[2]=list.get(i).getService_catagory();
            row[3]=list.get(i).getEquipment_ID();
            row[4]=list.get(i).getEquipment_Name();
            row[5]=list.get(i).getLocation();
            row[6]=list.get(i).getValue_Of_Service();
           
            model.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtSearch_PS = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        LblPrint_PS = new javax.swing.JLabel();
        Btn_Reset_PS = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tbl_PS_Report = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tsum = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Date23 = new javax.swing.JLabel();
        Time25 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Search");

        TxtSearch_PS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtSearch_PSKeyReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oems/search (1).png"))); // NOI18N

        LblPrint_PS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oems/print (2).png"))); // NOI18N
        LblPrint_PS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LblPrint_PSMouseClicked(evt);
            }
        });

        Btn_Reset_PS.setText("Reset");
        Btn_Reset_PS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_Reset_PSActionPerformed(evt);
            }
        });

        Tbl_PS_Report.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job No", "Service Date", "Transsaction code", "Equipment ID", "Equipment_Name", "Location", "Value"
            }
        ));
        Tbl_PS_Report.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(Tbl_PS_Report);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Total Value");

        tsum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        Date23.setText("jLabel5");

        Time25.setText("jLabel6");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("Preventive Service - Report");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                .addGap(62, 62, 62))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 952, Short.MAX_VALUE)
                .addComponent(Date23)
                .addGap(88, 88, 88)
                .addComponent(Time25)
                .addGap(113, 113, 113))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Date23)
                    .addComponent(Time25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(TxtSearch_PS, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(577, 577, 577)
                        .addComponent(jLabel4)
                        .addGap(31, 31, 31)
                        .addComponent(LblPrint_PS)
                        .addGap(18, 18, 18)
                        .addComponent(Btn_Reset_PS))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TxtSearch_PS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblPrint_PS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Btn_Reset_PS, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtSearch_PSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtSearch_PSKeyReleased
        DefaultTableModel table = (DefaultTableModel)Tbl_PS_Report.getModel();
        String search = TxtSearch_PS.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter <DefaultTableModel>(table);
        Tbl_PS_Report.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter("(?i)" + search));

        tsum.setText(Double.toString(getsum()));

    }//GEN-LAST:event_TxtSearch_PSKeyReleased

    private void LblPrint_PSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LblPrint_PSMouseClicked
//        MessageFormat header = new MessageFormat("Report print");
//
//        MessageFormat footer = new MessageFormat("Page{0,number,integer}");
//
//        try{
//            Tbl_PS_Report.print(JTable.PrintMode.NORMAL, header,footer);
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
              g2.scale(0.60,0.75);
              
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

    }//GEN-LAST:event_LblPrint_PSMouseClicked

    private void Btn_Reset_PSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_Reset_PSActionPerformed
        this.dispose();
        preventive_Service_Report u = new preventive_Service_Report();
        u.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_Btn_Reset_PSActionPerformed

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
            java.util.logging.Logger.getLogger(preventive_Service_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(preventive_Service_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(preventive_Service_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(preventive_Service_Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new preventive_Service_Report().setVisible(true);
            }
        });
    }
    //total value
    public double getsum(){
    int rowsCount = Tbl_PS_Report.getRowCount();
    int sum = 0;
    for (int i = 0;i<rowsCount;i++){
        sum=sum+Integer.parseInt(Tbl_PS_Report.getValueAt(i,6).toString());
           // NumberFormat format = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
    //String currency = format.format(sum);
    }

    return sum;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Reset_PS;
    private javax.swing.JLabel Date23;
    private javax.swing.JLabel LblPrint_PS;
    private javax.swing.JTable Tbl_PS_Report;
    private javax.swing.JLabel Time25;
    private javax.swing.JTextField TxtSearch_PS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel tsum;
    // End of variables declaration//GEN-END:variables

   
}
