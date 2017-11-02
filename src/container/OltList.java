/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package container;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.StringBinding;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author alex
 */
public class OltList extends javax.swing.JFrame {

    /**
     * Creates new form OltList
     */
    public OltList() {
        super("OLT list");

        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NewOltForm = new javax.swing.JFrame();
        addRow_but = new javax.swing.JButton();
        add_butt = new javax.swing.JButton();
        dellRow_butt = new javax.swing.JButton();
        ipAdrress = new javax.swing.JTextField();
        nameOlt = new javax.swing.JTextField();
        login = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        addOlt_butt = new javax.swing.JButton();
        delOlt_butt = new javax.swing.JButton();
        edit_bttt = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        infoArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        NewOltForm.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        NewOltForm.setTitle("New OLT");
        NewOltForm.setLocationByPlatform(true);
        NewOltForm.setMinimumSize(new java.awt.Dimension(371, 440));

        addRow_but.setText("Add row");
        addRow_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRow_butActionPerformed(evt);
            }
        });

        add_butt.setText("Add");
        add_butt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttActionPerformed(evt);
            }
        });

        dellRow_butt.setText("Delete row");
        dellRow_butt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dellRow_buttActionPerformed(evt);
            }
        });

        ipAdrress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipAdrressActionPerformed(evt);
            }
        });

        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Board", "Type", "line-profile", "SVLAN"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Ip  address");

        jLabel3.setText("Login");

        jLabel4.setText("Password");

        jLabel5.setText("Name OLT");

        jButton1.setText("Cansel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NewOltFormLayout = new javax.swing.GroupLayout(NewOltForm.getContentPane());
        NewOltForm.getContentPane().setLayout(NewOltFormLayout);
        NewOltFormLayout.setHorizontalGroup(
            NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewOltFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(NewOltFormLayout.createSequentialGroup()
                        .addGroup(NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(add_butt, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(addRow_but, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addGroup(NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dellRow_butt))
                        .addContainerGap(135, Short.MAX_VALUE))
                    .addGroup(NewOltFormLayout.createSequentialGroup()
                        .addGroup(NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(NewOltFormLayout.createSequentialGroup()
                                .addGroup(NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameOlt, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(ipAdrress, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(43, 43, 43)
                                .addGroup(NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        NewOltFormLayout.setVerticalGroup(
            NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NewOltFormLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(NewOltFormLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameOlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ipAdrress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(NewOltFormLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(NewOltFormLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(45, 45, 45)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRow_but)
                    .addComponent(dellRow_butt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NewOltFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_butt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jLabel1.setText("OLT Huawei");

        jList1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = getLIst();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        addOlt_butt.setText("Add OLT");
        addOlt_butt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOlt_buttActionPerformed(evt);
            }
        });

        delOlt_butt.setText("Delete OLT");
        delOlt_butt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delOlt_buttActionPerformed(evt);
            }
        });

        edit_bttt.setText("Edit OLT");
        edit_bttt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_btttActionPerformed(evt);
            }
        });

        infoArea.setColumns(20);
        infoArea.setRows(5);
        jScrollPane4.setViewportView(infoArea);

        jLabel6.setText("Olt info");

        jButton2.setText("Cansel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(delOlt_butt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addOlt_butt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edit_bttt, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addOlt_butt)
                            .addComponent(edit_bttt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delOlt_butt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        OltLists olst = new OltLists();

    public String[] getLIst() {
        DefaultListModel listModel = new DefaultListModel();
        jList1.setModel(listModel);
        File f = new File("oltList").getAbsoluteFile();
        if (!f.exists()) {
            f.mkdir();
        }
        File[] filename = f.listFiles();
        String[] lst = new String[f.listFiles().length];
        for (int i = 0; i < f.listFiles().length; i++) {
            lst[i] = filename[i].getName();
        }
        return lst;
    }

    private void add_buttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttActionPerformed
        StringBuilder sb = new StringBuilder();
        File fileList = new File("oltList/" + nameOlt.getText()).getAbsoluteFile();
        if (!fileList.exists()) {
            try {
                fileList.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(OltList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            FileWriter fstream1 = new FileWriter(fileList.getAbsoluteFile());// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
        } catch (IOException ex) {
            Logger.getLogger(OltList.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            RandomAccessFile raf = new RandomAccessFile(fileList, "rw");
            sb.append(nameOlt.getText() + "\n" + ipAdrress.getText() + "\n" + login.getText() + "\n" + jPasswordField1.getText() + "\n");

            for (int i = 0; i < jTable1.getRowCount(); i++) {
                for (int j = 0; j < jTable1.getColumnCount(); j++) {
                    sb.append(jTable1.getModel().getValueAt(i, j));
                    sb.append(" ");
                }
                sb.append("\n");

            }

            raf.write(sb.toString().getBytes());
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OltList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OltList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultListModel listModel = new DefaultListModel();
        jList1.setModel(listModel);
        File f = new File("oltList").getAbsoluteFile();
        File[] filename = f.listFiles();
        for (int i = 0; i < f.listFiles().length; i++) {
            listModel.addElement(filename[i].getName());

        }
        OltLists olsts = new OltLists();
        final Form few;
        try {
            few = new Form();
        
        
        few.jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>((String[]) olsts.getOltList()));

        NewOltForm.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(OltList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_buttActionPerformed

    private void dellRow_buttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dellRow_buttActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();//получили модель таблицы (с вашими колонками, в часности)

        dtm.removeRow(dtm.getRowCount() - 1);

    }//GEN-LAST:event_dellRow_buttActionPerformed

    private void addRow_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRow_butActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{"", "", "", "", ""});
    }//GEN-LAST:event_addRow_butActionPerformed

    private void addOlt_buttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOlt_buttActionPerformed
        login.setText(null);
        ipAdrress.setText(null);
        jPasswordField1.setText(null);
        nameOlt.setText(null);
        NewOltForm.setVisible(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String[]{
                    "Board", "Type", "line-profile", "SVLAN"
                }
        ));
        File folder;
        try {
            folder = new File("oltList").getCanonicalFile();
            if (!folder.exists()) {
                folder.mkdir();
            }
        } catch (IOException ex) {
            Logger.getLogger(OltList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addOlt_buttActionPerformed

    private void ipAdrressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipAdrressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipAdrressActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed
    public Object[][] getData() throws IOException {
        String r = jList1.getSelectedValue().toString();
        File folder = new File("oltList").getCanonicalFile();

        File fileList = new File(folder + "/" + r);

        int t = 0;
        int ie = 0;
        int cou = 0;
        try (BufferedReader readerr = new BufferedReader(new InputStreamReader(new FileInputStream(fileList.getAbsoluteFile()), StandardCharsets.UTF_8))) {
            String l;
            while ((l = readerr.readLine()) != null) {
                cou++;
            }
        } catch (IOException e) {
        }
        Object[][] arr = new Object[cou][4];
        String[] a = new String[ie];
        String[] b = new String[ie];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileList.getAbsoluteFile()), StandardCharsets.UTF_8))) {
            String line;

            while ((line = reader.readLine()) != null) {
                a = line.split("\n");
                b = a[0].split(" ");
                for (int i = 0; i < b.length; i++) {
                    arr[t][i] = b[i];
                }
                t++;

            }
        } catch (IOException e) {
        }
        return arr;
    }
    private void edit_btttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_btttActionPerformed
        String r = jList1.getSelectedValue().toString();
        NewOltForm.setVisible(true);
        StringBuilder sb = new StringBuilder();
        File folder;

        try {
            folder = new File("oltList").getCanonicalFile();

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(folder + "/" + r), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
            } catch (IOException e) {
                // log error
            }
        } catch (IOException ex) {
            Logger.getLogger(OltList.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] ar = sb.toString().split("\n");
        String name = ar[0];
        String log = ar[2];
        String pass = ar[3];
        String ip = ar[1];
        nameOlt.setText(name);
        login.setText(log);
        jPasswordField1.setText(pass);
        ipAdrress.setText(ip);
        int i = ar.length - 4;
        int e = 4;

        String[] tableArr = new String[i];
        for (int j = 0; j < tableArr.length; j++) {

            tableArr[j] = ar[e];
            e++;
        }
        Object[][] arr = new Object[i][4];
        String[] a = new String[3];
        for (int j = 0; j < tableArr.length; j++) {
            a = tableArr[j].split(" ");
            for (int k = 0; k < a.length; k++) {
                arr[j][k] = a[k];
            }
        }
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                arr,
                new String[]{
                    "Board", "Type", "line-profile", "SVLAN"
                }
        ));
        String na = nameOlt.getText();
        try {
        String  er = new File("oltList").getCanonicalPath() + "/"+na;
        File fr = new File(er);
        if (fr.delete()) {

        } else {
            
        }
        } catch (IOException ex) {
            Logger.getLogger(OltList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_edit_btttActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        NewOltForm.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed


    private void delOlt_buttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delOlt_buttActionPerformed
            infoArea.setText(null);
            
        String r = jList1.getSelectedValue().toString();
        try {
        String  er = new File("oltList").getCanonicalPath() + "/"+r;
        File fr = new File(er);
        if (fr.delete()) {

        } else {
            
        }
        } catch (IOException ex) {
            Logger.getLogger(OltList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DefaultListModel listModel = new DefaultListModel();
        jList1.setModel(listModel);
        File f = new File("oltList").getAbsoluteFile();
        File[] filename = f.listFiles();
        for (int i = 0; i < f.listFiles().length; i++) {
            listModel.addElement(filename[i].getName());

        }
        


    }//GEN-LAST:event_delOlt_buttActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int EXIT_ON_CLOSE1 = OltList.EXIT_ON_CLOSE;
    }//GEN-LAST:event_jButton2ActionPerformed
   
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
            java.util.logging.Logger.getLogger(OltList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OltList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OltList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OltList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OltList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame NewOltForm;
    private javax.swing.JButton addOlt_butt;
    private javax.swing.JButton addRow_but;
    private javax.swing.JButton add_butt;
    private javax.swing.JButton delOlt_butt;
    private javax.swing.JButton dellRow_butt;
    private javax.swing.JButton edit_bttt;
    private javax.swing.JTextArea infoArea;
    private javax.swing.JTextField ipAdrress;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField login;
    private javax.swing.JTextField nameOlt;
    // End of variables declaration//GEN-END:variables
}
