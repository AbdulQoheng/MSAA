/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msaa.view.admin;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.koneksi;

/**
 *
 * @author qoheng
 */
public class FormTaklim extends javax.swing.JFrame {
    private DefaultTableModel model;
    /**
     * Creates new form FormTaklim
     */
    public FormTaklim() {
        initComponents();
        awal();
        setIcon();
        setTitle("MSAA Application");
    }
      private void setIcon() {
   
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("rsz_picture1.png"))); }
    public void awal(){
        modelTaklim();
        modeltingkat();
        txt_idtaklim.setText(null);
        txt_taklim.setText(null);
        txt_idtingkatan.setText(null);
        txt_tingkatan.setText(null);
    }
    
    public void modelTaklim() {

        model = new DefaultTableModel();
        tabel_taklim.setModel(model);
        model.addColumn("ID Taklim");
        model.addColumn("Taklim");

        getdatataklim();
    }

    public void getdatataklim() {
        try {
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select* from taklim");

            while (data.next()) {
                Object[] obj = new Object[2];
                obj[0] = data.getString("no_takl");
                obj[1] = data.getString("namaTakl");

                model.addRow(obj);

            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void modeltingkat() {

        model = new DefaultTableModel();
        tabel_tingkatan.setModel(model);
        model.addColumn("ID Tingkatan");
        model.addColumn("Tingkatan");

        getdatatingkat();
    }

    public void getdatatingkat() {
        try {
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select* from tingakTaklim");

            while (data.next()) {
                Object[] obj = new Object[2];
                obj[0] = data.getString("no_tingkattak");
                obj[1] = data.getString("namatingkat");

                model.addRow(obj);

            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_idtaklim = new javax.swing.JLabel();
        txt_taklim = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_tingkatan = new javax.swing.JTextField();
        txt_idtingkatan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_taklim = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_tingkatan = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Data Taklim");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("Id Taklim");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel4.setText("Taklim");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        txt_idtaklim.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txt_idtaklim.setText("jLabel5");
        getContentPane().add(txt_idtaklim, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        txt_taklim.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        getContentPane().add(txt_taklim, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 133, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel6.setText("Id Tingkatan");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel7.setText("Tingkatan");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 210, -1, -1));

        txt_tingkatan.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        getContentPane().add(txt_tingkatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 210, 101, -1));

        txt_idtingkatan.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txt_idtingkatan.setText("jLabel8");
        getContentPane().add(txt_idtingkatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 180, -1, -1));

        tabel_taklim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_taklim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_taklimMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_taklim);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 236, 216));

        tabel_tingkatan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_tingkatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_tingkatanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_tingkatan);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 270, 224, 216));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton1.setText("Simpan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 240, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton2.setText("Hapus");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton3.setText("Simpan");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 240, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 240, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Kembali");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 12, -1, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/11taklim.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {

            if (txt_taklim.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, Taklim belum diisi !");
                txt_taklim.requestFocus();
            } else {
                PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                        "insert into taklim values (null,?)");

                statement.setString(1, txt_taklim.getText());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Baru telah di tambahkan");
                awal();
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "gagal menambah Data");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {

            if (txt_tingkatan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Maaf, Tingkatan belum diisi !");
                txt_tingkatan.requestFocus();
            } else {
                PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                        "insert into tingakTaklim values (null,?)");

                statement.setString(1, txt_tingkatan.getText());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Baru telah di tambahkan");
                awal();
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "gagal menambah Data");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus dataini ?", "Warning", 2) == JOptionPane.YES_OPTION) {
            try {

                PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                        "delete from taklim where no_Takl = ?");

                statement.setString(1, txt_idtaklim.getText());
                statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data Telah Di Hapus");
                awal();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan menghapus dataini ?", "Warning", 2) == JOptionPane.YES_OPTION) {
            try {

                PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                        "delete from tingakTaklim where no_tingkattak = ?");

                statement.setString(1, txt_idtingkatan.getText());
                statement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data Telah Di Hapus");
                awal();

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Data Gagal Di Hapus");
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tabel_taklimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_taklimMouseClicked
        // TODO add your handling code here:
        try {
            int row = tabel_taklim.rowAtPoint(evt.getPoint());

            String kode = tabel_taklim.getValueAt(row, 0).toString();
            String nama = tabel_taklim.getValueAt(row, 1).toString();

            txt_idtaklim.setText(String.valueOf(kode));
            txt_taklim.setText(String.valueOf(nama));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabel_taklimMouseClicked

    private void tabel_tingkatanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_tingkatanMouseClicked
        // TODO add your handling code here:
        try {
            int row = tabel_tingkatan.rowAtPoint(evt.getPoint());

            String kode = tabel_tingkatan.getValueAt(row, 0).toString();
            String nama = tabel_tingkatan.getValueAt(row, 1).toString();

            txt_idtingkatan.setText(String.valueOf(kode));
            txt_tingkatan.setText(String.valueOf(nama));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabel_tingkatanMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        FormAdmin n = new FormAdmin();
        n.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(FormTaklim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTaklim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTaklim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTaklim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTaklim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_taklim;
    private javax.swing.JTable tabel_tingkatan;
    private javax.swing.JLabel txt_idtaklim;
    private javax.swing.JLabel txt_idtingkatan;
    private javax.swing.JTextField txt_taklim;
    private javax.swing.JTextField txt_tingkatan;
    // End of variables declaration//GEN-END:variables
}
