/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msaa.view.admin;

import com.msaa.view.admin.FormAdmin;
import com.mysql.jdbc.Connection;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.koneksi;

/**
 *
 * @author ABD, Qohar Agus Maulana (18650051)
 * @author Rizki Fitriani (18650053)
 * @author Annisa Rizkiana Putri (18650048)
 * @author Nisa Kholifatul Ummah (18650065)
 */
public class FormIqobAdmin extends javax.swing.JFrame {

    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private DefaultTableModel model = new DefaultTableModel();
    private List<String> list;

    /**
     * Creates new form Iqob
     */
    public FormIqobAdmin() {
        initComponents();
        lokasi();
        model();
        getdata();
        awal();

        setTitle("MSAA Application");
    }

    protected void lokasi() {
        int x = layar.width / 2 - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        setLocation(x, y);
        
    }

    public void awal() {
        try {
            cm_mahad.removeAllItems();
            cm_taklim.removeAllItems();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            ResultSet mahad = stmt.executeQuery("select nama_mab from mabna");
            ResultSet taklim = stmt1.executeQuery("select namaTakl from taklim");

            while (mahad.next()) {
                String obj = mahad.getString("nama_mab");
                cm_mahad.addItem(obj);

            }
            while (taklim.next()) {
                String obj = taklim.getString("namaTakl");
                cm_taklim.addItem(obj);

            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public String ambilidtaklim(String namataklim) {
        try {
            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "select no_Takl from taklim where namaTakl = ?");

            statement.setString(1, namataklim);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return result.getString("no_Takl");
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public String ambilkodemabna(String namamabna) {
        try {
            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "select kode_mab from mabna where nama_mab = ?");

            statement.setString(1, namamabna);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return result.getString("kode_mab");
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public String penentuan(int hadir, int alpha, int izin, int sakit) {
        int jumlahper = hadir + izin + sakit + alpha;
        double iqob = (double) hadir / (double) jumlahper;
        if (iqob <= 0.50) {
            return "berat";
        }else if (iqob <= 0.75){
        return "sedang";
        }else if(iqob <= 0.80){
            return "sedang";
        }
        return "Aman";

    }

    public void model() {

        model = new DefaultTableModel();
        tabel_iqob.setModel(model);
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Mabna");
        model.addColumn("Kamar");
        model.addColumn("Fakultas");
        model.addColumn("jurusan");
        model.addColumn("Bulan");
        model.addColumn("Taklim");
        model.addColumn("Iqob");
        
//        getdata();

    }
    
    public void getdata() {
        try {
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select M.nim_mahasantri, M.nama, M.kamar, A.bulan, T.namaTakl, A.Hadir, A.alpha, A.izin, A.sakit, U.nama_mab , F.nama_fak, J.nama_jur from mahasantri M,fakultas F, jurusan J, absen A, taklim T, tingakTaklim N, mabna U where M.nim_mahasantri = A.nim_mhs and M.kode_jur = J.kode_jur and J.kode_fak = F.kode_fak and M.kode_mab = U.kode_mab and A.no_tingkattak = N.no_tingkattak and T.no_Takl = A.no_Takl");

            while (data.next()) {
                Object[] obj = new Object[9];
                obj[0] = data.getString("M.nim_mahasantri");
                obj[1] = data.getString("M.nama");
                obj[2] = data.getString("U.nama_mab");
                obj[3] = data.getString("M.kamar");
                obj[4] = data.getString("F.nama_fak");
                obj[5] = data.getString("J.nama_jur");
                obj[6] = data.getString("A.bulan");
                obj[7] = data.getString("t.namaTakl");
                int h = data.getInt("A.Hadir");
                int a = data.getInt("A.alpha");
                int i = data.getInt("A.izin");
                int s = data.getInt("A.sakit");
                obj[8] = penentuan(h, a, i, s);

                model.addRow(obj);

            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    
    public static void saveCSV(JTable table){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
 
        JFileChooser chooser = new JFileChooser();
        int state = chooser.showSaveDialog(null);
        File file = chooser.getSelectedFile();
        if (file != null && state == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                PrintWriter fileWriter = new PrintWriter(bufferedWriter);
                bufferedWriter.write("NIM, Nama, Mabna, Kamar, Fakultas, Jurusan, Bulan, Taklim, Iqob \r\n");
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        Object o = model.getValueAt(i, j);
                        String s = String.valueOf(o);
//                        System.out.print(s);
                        bufferedWriter.write(s);
 
                        if(j < model.getColumnCount() - 1 ){
                            bufferedWriter.write(",");
                        } else {
                            bufferedWriter.write("\r\n");
                        }
                    }
                }
 
                fileWriter.close();
                JOptionPane.showMessageDialog(null, "Success");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Failure");
            }
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

        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cm_bulan = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cm_mahad = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_iqob = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cm_taklim = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 117, -1));

        jLabel11.setBackground(null);
        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel11.setText("Bulan");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton1.setText("Kembali");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, 117, -1));

        cm_bulan.setBackground(null);
        cm_bulan.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cm_bulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        cm_bulan.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cm_bulan.setOpaque(false);
        getContentPane().add(cm_bulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 119, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Rekap Iqob Mahasantri");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1170, -1));

        jLabel3.setBackground(null);
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("NIM");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, -1));

        cm_mahad.setBackground(null);
        cm_mahad.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cm_mahad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cm_mahad.setOpaque(false);
        getContentPane().add(cm_mahad, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 200, -1));

        jLabel5.setBackground(null);
        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel5.setText("Mabna");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, -1, -1));

        txt_nim.setBackground(null);
        txt_nim.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txt_nim.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txt_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nimActionPerformed(evt);
            }
        });
        getContentPane().add(txt_nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 241, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton2.setText("Cari");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, 117, -1));

        tabel_iqob.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Mabna", "Kamar", "Fakultas", "Jurusan", "Bulan/Tahun", "B. Inggris", "B. Arab", "T. Afkar", "T. Qur'an"
            }
        ));
        jScrollPane1.setViewportView(tabel_iqob);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 357, 1100, 230));

        jLabel6.setBackground(null);
        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel6.setText("Taklim");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        cm_taklim.setBackground(null);
        cm_taklim.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cm_taklim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cm_taklim.setOpaque(false);
        getContentPane().add(cm_taklim, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 150, 119, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton3.setText("Convert to CSV");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 280, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/5iqob.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        model();
        txt_nim.setText(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FormAdmin n = new FormAdmin();
        n.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nimActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            model();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select M.nim_mahasantri, M.nama, M.kamar, A.bulan, T.namaTakl, A.Hadir, A.alpha, A.izin, A.sakit, U.nama_mab , F.nama_fak, J.nama_jur from mahasantri M,fakultas F, jurusan J, absen A, taklim T, tingakTaklim N, mabna U where M.nim_mahasantri = A.nim_mhs and M.kode_jur = J.kode_jur and J.kode_fak = F.kode_fak and M.kode_mab = U.kode_mab and A.no_tingkattak = N.no_tingkattak and T.no_Takl = A.no_Takl and M.kode_mab ='" + ambilkodemabna(cm_mahad.getSelectedItem().toString()) + "' and A.bulan = '" + cm_bulan.getSelectedItem() + "' and A.nim_mhs like '%" + txt_nim.getText() + "%' and A.no_Takl = '" + ambilidtaklim(cm_taklim.getSelectedItem().toString()) + "'");

            while (data.next()) {
                Object[] obj = new Object[9];
                obj[0] = data.getString("M.nim_mahasantri");
                obj[1] = data.getString("M.nama");
                obj[2] = data.getString("U.nama_mab");
                obj[3] = data.getString("M.kamar");
                obj[4] = data.getString("F.nama_fak");
                obj[5] = data.getString("J.nama_jur");
                obj[6] = data.getString("A.bulan");
                obj[7] = data.getString("t.namaTakl");
                int h = data.getInt("A.Hadir");
                int a = data.getInt("A.alpha");
                int i = data.getInt("A.izin");
                int s = data.getInt("A.sakit");
                obj[8] = penentuan(h, a, i, s);

                model.addRow(obj);

            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        saveCSV(tabel_iqob);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FormIqobAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormIqobAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormIqobAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormIqobAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormIqobAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cm_bulan;
    private javax.swing.JComboBox<String> cm_mahad;
    private javax.swing.JComboBox<String> cm_taklim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_iqob;
    private javax.swing.JTextField txt_nim;
    // End of variables declaration//GEN-END:variables
}
