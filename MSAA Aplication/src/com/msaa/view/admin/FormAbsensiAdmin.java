/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msaa.view.admin;

import com.mysql.jdbc.Connection;
import java.awt.Dimension;
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
 * @author ABD, Qohar Agus Maulana (18650051)
 * @author Rizki Fitriani (18650053)
 * @author Annisa Rizkiana Putri (18650048)
 * @author Nisa Kholifatul Ummah (18650065)
 */
public class FormAbsensiAdmin extends javax.swing.JFrame {
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private DefaultTableModel model = new DefaultTableModel();
    /**
     * Creates new form Absensi
     */
    public FormAbsensiAdmin() {
        initComponents();
        lokasi();
    }
    
    protected void lokasi(){
        int x = layar.width / 2  -this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        setLocation(x, y);
        awal();
        model();
        getdata();
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
    
    public void model() {

        model = new DefaultTableModel();
        tabel_absen.setModel(model);
        model.addColumn("id absen");
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Taklim");
        model.addColumn("Tingkat");
        model.addColumn("Kelas");
        model.addColumn("Bulan");
        model.addColumn("Mahad");
        model.addColumn("Hadir");
        model.addColumn("Alpha");
        model.addColumn("Izin");
        model.addColumn("Sakit");

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

    public void getdata() {
        try {
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select M.nim_mahasantri, M.nama, A.no_absen, A.bulan, T.namaTakl, N.namatingkat , A.kelastakl, A.Hadir, A.alpha, A.izin, A.sakit  from mahasantri M, absen A, taklim T, tingakTaklim N where M.nim_mahasantri = A.nim_mhs and A.no_tingkattak = N.no_tingkattak and T.no_Takl = A.no_Takl");

            while (data.next()) {
                Object[] obj = new Object[11];
                obj[0] = data.getString("A.no_absen");
                obj[1] = data.getString("M.nim_mahasantri");
                obj[2] = data.getString("M.nama");
                obj[3] = data.getString("T.namaTakl");
                obj[4] = data.getString("N.namatingkat");
                obj[5] = data.getString("A.kelastakl");
                obj[6] = data.getString("A.bulan");
                obj[7] = data.getString("A.Hadir");
                obj[8] = data.getString("A.alpha");
                obj[9] = data.getString("A.izin");
                obj[10] = data.getString("A.sakit");

                model.addRow(obj);

            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void awal(){
        try {
            cm_mahad.removeAllItems();
            cm_tingkat.removeAllItems();
            cm_taklim.removeAllItems();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            ResultSet mahad = stmt.executeQuery("select nama_mab from mabna");
            ResultSet tingkat = stmt1.executeQuery("select namatingkat from tingakTaklim");
            ResultSet taklim = stmt2.executeQuery("select namaTakl from taklim");

            while (mahad.next()) {
                String obj = mahad.getString("nama_mab");
                cm_mahad.addItem(obj);

            }
            while (tingkat.next()) {
                String obj = tingkat.getString("namatingkat");
                cm_tingkat.addItem(obj);

            }
            while (taklim.next()) {
                String obj = taklim.getString("namaTakl");
                cm_taklim.addItem(obj);

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cm_taklim = new javax.swing.JComboBox<>();
        cm_bulan = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_absen = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cm_tingkat = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cm_mahad = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txt_kelas = new javax.swing.JTextField();
        txt_no = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Absensi");

        jLabel2.setText("Taklim");

        jLabel3.setText("Bulan");

        cm_taklim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cm_bulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Kembali");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tabel_absen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Taklim", "Kelas", "Tanggal", "Bulan", "Presensi"
            }
        ));
        tabel_absen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_absenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_absen);

        jLabel5.setText("Tingkat");

        cm_tingkat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("NIM");

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setText("Mahad");

        cm_mahad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("kelas");

        jButton3.setText("Refres");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_nim)
                                    .addComponent(cm_taklim, 0, 183, Short.MAX_VALUE)
                                    .addComponent(cm_tingkat, 0, 183, Short.MAX_VALUE)
                                    .addComponent(txt_kelas))
                                .addGap(252, 252, 252)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cm_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cm_mahad, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(txt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(362, 362, 362)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_no))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cm_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cm_taklim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(cm_mahad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cm_tingkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FormAdmin n = new FormAdmin();
        n.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tabel_absenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_absenMouseClicked
        // TODO add your handling code here:
        try {

            int row = tabel_absen.rowAtPoint(evt.getPoint());
            if (row > -1) {
                txt_no.setText(tabel_absen.getValueAt(row, 0).toString());
                txt_nim.setText(tabel_absen.getValueAt(row, 1).toString());
                cm_taklim.setSelectedItem(tabel_absen.getValueAt(row, 3).toString());
                cm_tingkat.setSelectedItem(tabel_absen.getValueAt(row, 4).toString());
                txt_kelas.setText(tabel_absen.getValueAt(row, 5).toString());
                cm_bulan.setSelectedItem(tabel_absen.getValueAt(row, 6).toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabel_absenMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            model();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select M.nim_mahasantri, M.nama, A.no_absen, A.bulan, T.namaTakl, N.namatingkat , A.kelastakl, A.Hadir, A.alpha, A.izin, A.sakit  from mahasantri M natural join absen A natural join taklim T natural join tingakTaklim N where M.nim_mahasantri = A.nim_mhs and A.no_tingkattak = N.no_tingkattak and T.no_Takl = A.no_Takl and M.kode_mab ='" + ambilkodemabna(cm_mahad.getSelectedItem().toString()) + "' and A.bulan = '" + cm_bulan.getSelectedItem() + "' and A.nim_mhs like '%" + txt_nim.getText() + "%' and kelastakl like '%" + txt_kelas.getText() + "%' and A.no_Takl = '" + ambilidtaklim(cm_taklim.getSelectedItem().toString()) + "'");

            while (data.next()) {
                Object[] obj = new Object[11];
                obj[0] = data.getString("A.no_absen");
                obj[1] = data.getString("M.nim_mahasantri");
                obj[2] = data.getString("M.nama");
                obj[3] = data.getString("T.namaTakl");
                obj[4] = data.getString("N.namatingkat");
                obj[5] = data.getString("A.kelastakl");
                obj[6] = data.getString("A.bulan");
                obj[7] = data.getString("A.Hadir");
                obj[8] = data.getString("A.alpha");
                obj[9] = data.getString("A.izin");
                obj[10] = data.getString("A.sakit");
                
                model();
                model.addRow(obj);

            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {

            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "delete from absen where no_absen =?");

            statement.setString(1, txt_no.getText());
            statement.executeUpdate();
            model();
            txt_kelas.setText(null);
            txt_nim.setText(null);
            JOptionPane.showMessageDialog(null, "Data berhasil di Hapus");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        model();
        getdata();
        txt_kelas.setText(null);
        txt_nim.setText(null);
        txt_no.setText(null);
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
            java.util.logging.Logger.getLogger(FormAbsensiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAbsensiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAbsensiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAbsensiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAbsensiAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cm_bulan;
    private javax.swing.JComboBox<String> cm_mahad;
    private javax.swing.JComboBox<String> cm_taklim;
    private javax.swing.JComboBox<String> cm_tingkat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_absen;
    private javax.swing.JTextField txt_kelas;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JLabel txt_no;
    // End of variables declaration//GEN-END:variables
}
