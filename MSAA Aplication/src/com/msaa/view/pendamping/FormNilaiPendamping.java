/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msaa.view.pendamping;

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
import model.pendamping;

/**
 *
 * @author ABD, Qohar Agus Maulana (18650051)
 * @author Rizki Fitriani (18650053)
 * @author Annisa Rizkiana Putri (18650048)
 * @author Nisa Kholifatul Ummah (18650065)
 */
public class FormNilaiPendamping extends javax.swing.JFrame {

    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form Nilai
     */
    public FormNilaiPendamping() {
        initComponents();
        lokasi();
        getdata();
    
        setTitle("MSAA Application");
    }

    protected void lokasi() {
        int x = layar.width / 2 - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        setLocation(x, y);
        awal();
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

    public String ambilidtingkatan(String namatingkatan) {
        try {
            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "select no_tingkattak from tingakTaklim where namatingkat = ?");

            statement.setString(1, namatingkatan);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return result.getString("no_tingkattak");
            }

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public void awal() {
        try {
            txt_mahad.setText(pendamping.getMabna());
            cm_tingkat.removeAllItems();
            cm_taklim.removeAllItems();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            ResultSet mahad = stmt.executeQuery("select nama_mab from mabna");
            ResultSet tingkat = stmt1.executeQuery("select namatingkat from tingakTaklim");
            ResultSet taklim = stmt2.executeQuery("select namaTakl from taklim");

            while (tingkat.next()) {
                String obj = tingkat.getString("namatingkat");
                cm_tingkat.addItem(obj);

            }
            while (taklim.next()) {
                String obj = taklim.getString("namaTakl");
                cm_taklim.addItem(obj);

            }
            model();
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void model() {

        model = new DefaultTableModel();
        tabel_nilai.setModel(model);
        model.addColumn("id nilai");
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Jenis");
        model.addColumn("Taklim");
        model.addColumn("Tingkatan");
        model.addColumn("Kelas");
        model.addColumn("Nilai");

    }
    
    public void getdata(){
        try {
            model();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select N.no_nilai, M.nim_mahasantri, M.nama, N.jenis, T.namaTakl, U.namatingkat, N.kelastakl, N.nilai from nilai N natural join mahasantri M natural join taklim T natural join tingakTaklim U where N.no_Takl = T.no_Takl and N.no_tingkattakl = U.no_tingkattak and N.nim_mhs = M.nim_mahasantri and M.kode_mab ='" + ambilkodemabna(txt_mahad.getText()) + "'");

            while (data.next()) {
                Object[] obj = new Object[8];
                obj[0] = data.getString("N.no_nilai");
                obj[1] = data.getString("M.nim_mahasantri");
                obj[2] = data.getString("M.nama");
                obj[3] = data.getString("N.jenis");
                obj[4] = data.getString("T.namaTakl");
                obj[5] = data.getString("U.namatingkat");
                obj[6] = data.getString("N.kelastakl");
                obj[7] = data.getString("N.nilai");
                
                
                model.addRow(obj);
                
                txt_id.setText(null);
                txt_kelas.setText(null);
                txt_nilai.setText(null);
                txt_nim.setText(null);
            }
        } catch (SQLException | HeadlessException e) {
            e.printStackTrace();
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

        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        cm_tingkat = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_nilai = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cm_jenis = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cm_taklim = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_nilai = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txt_mahad = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_kelas = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel5.setText("Tingkatan");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 134, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton3.setText("Kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        cm_tingkat.setBackground(new java.awt.Color(255, 255, 255));
        cm_tingkat.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cm_tingkat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cm_tingkat, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 129, 183, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel9.setText("Mahad");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 58, -1, -1));

        tabel_nilai.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "NIM", "Nama", "Hadir", "Izin", "Sakit", "Alpha"
            }
        ));
        tabel_nilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_nilaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_nilai);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 690, 200));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 240, 80, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(254, 240, 92, -1));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel1.setText("Jenis");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 92, -1, -1));

        cm_jenis.setBackground(new java.awt.Color(255, 255, 255));
        cm_jenis.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cm_jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UTS", "UAS" }));
        getContentPane().add(cm_jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 87, 152, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel2.setText("Taklim");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 92, -1, -1));

        cm_taklim.setBackground(new java.awt.Color(255, 255, 255));
        cm_taklim.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        cm_taklim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cm_taklim, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 87, 183, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel4.setText("Nilai");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 134, -1, -1));

        txt_nilai.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        getContentPane().add(txt_nilai, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 132, 152, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel6.setText("NIM");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 58, -1, -1));

        txt_nim.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        getContentPane().add(txt_nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 56, 183, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel7.setText("Nilai");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 12, -1, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(364, 240, -1, -1));

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton5.setText("Hapus");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 240, -1, -1));

        txt_mahad.setBackground(new java.awt.Color(255, 255, 255));
        txt_mahad.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        txt_mahad.setText("jLabel8");
        getContentPane().add(txt_mahad, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 58, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setText("Kelas");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 173, -1, -1));

        txt_kelas.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        getContentPane().add(txt_kelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 171, 183, -1));

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton6.setText("Segarkan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, -1, -1));

        jLabel8.setBackground(null);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/8nilai.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 600));

        txt_id.setText("0");
        getContentPane().add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 12, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        try {
            model();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select N.no_nilai, M.nim_mahasantri, M.nama, N.jenis, T.namaTakl, U.namatingkat, N.kelastakl, N.nilai from nilai N natural join mahasantri M natural join taklim T natural join tingakTaklim U where N.no_Takl = T.no_Takl and N.no_tingkattakl = U.no_tingkattak and N.nim_mhs = M.nim_mahasantri and N.no_Takl = '"+ambilidtaklim(cm_taklim.getSelectedItem().toString())+"' and N.no_tingkattakl = '"+ambilidtingkatan(cm_tingkat.getSelectedItem().toString())+"' and M.kode_mab ='" + ambilkodemabna(txt_mahad.getText()) + "' and N.jenis = '"+cm_jenis.getSelectedItem().toString()+"' and N.nim_mhs like '%"+txt_nim.getText()+"%' and N.kelastakl ='"+txt_kelas.getText()+"'");

            while (data.next()) {
                Object[] obj = new Object[8];
                obj[0] = data.getString("N.no_nilai");
                obj[1] = data.getString("M.nim_mahasantri");
                obj[2] = data.getString("M.nama");
                obj[3] = data.getString("N.jenis");
                obj[4] = data.getString("T.namaTakl");
                obj[5] = data.getString("U.namatingkat");
                obj[6] = data.getString("N.kelastakl");
                obj[7] = data.getString("N.nilai");
                
                model.addRow(obj);
                
                txt_id.setText(null);
                txt_kelas.setText(null);
                txt_nilai.setText(null);
                txt_nim.setText(null);
            }
        } catch (SQLException | HeadlessException e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        try {

            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "insert into nilai values (null,?,?,?,?,?,?)");

            statement.setString(1, cm_jenis.getSelectedItem().toString());
            statement.setString(2, txt_nilai.getText());
            statement.setString(3, ambilidtaklim(cm_taklim.getSelectedItem().toString()));
            statement.setString(4, ambilidtingkatan(cm_tingkat.getSelectedItem().toString()));
            statement.setString(5, txt_kelas.getText());
            statement.setString(6, txt_nim.getText());

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Baru telah di tambahkan");

            model();
            txt_id.setText(null);
            txt_kelas.setText(null);
            txt_nilai.setText(null);
            txt_nim.setText(null);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "gagal menambah Data");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        try {
            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "update nilai set jenis = ? ,nilai = ? ,no_Takl = ? ,no_tingkattakl = ?,kelastakl = ?,nim_mhs = ? where no_nilai = ?");

            statement.setString(1, cm_jenis.getSelectedItem().toString());
            statement.setString(2, txt_nilai.getText());
            statement.setString(3, ambilidtaklim(cm_taklim.getSelectedItem().toString()));
            statement.setString(4, ambilidtingkatan(cm_tingkat.getSelectedItem().toString()));
            statement.setString(5, txt_kelas.getText());
            statement.setString(6, txt_nim.getText());
            statement.setString(7, txt_id.getText());
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");

            model();
            txt_id.setText(null);
            txt_kelas.setText(null);
            txt_nilai.setText(null);
            txt_nim.setText(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        try {

            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "delete from nilai where no_nilai =?");

            statement.setString(1, txt_id.getText());
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data berhasil di Hapus");
            model();
            txt_id.setText(null);
            txt_kelas.setText(null);
            txt_nilai.setText(null);
            txt_nim.setText(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        model();
        txt_id.setText(null);
        txt_kelas.setText(null);
        txt_nilai.setText(null);
        txt_nim.setText(null);
        getdata();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new FormPendamping().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabel_nilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_nilaiMouseClicked
        // TODO add your handling code here:
        try {

            int row = tabel_nilai.rowAtPoint(evt.getPoint());
            if (row > -1) {
                txt_id.setText(tabel_nilai.getValueAt(row, 0).toString());
                txt_nim.setText(tabel_nilai.getValueAt(row, 1).toString());
                cm_jenis.setSelectedItem(tabel_nilai.getValueAt(row, 3).toString());
                cm_taklim.setSelectedItem(tabel_nilai.getValueAt(row, 4).toString());
                cm_tingkat.setSelectedItem(tabel_nilai.getValueAt(row, 5).toString());
                txt_kelas.setText(tabel_nilai.getValueAt(row, 6).toString());
                txt_nilai.setText(tabel_nilai.getValueAt(row, 7).toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabel_nilaiMouseClicked

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
            java.util.logging.Logger.getLogger(FormNilaiPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNilaiPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNilaiPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNilaiPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormNilaiPendamping().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cm_jenis;
    private javax.swing.JComboBox<String> cm_taklim;
    private javax.swing.JComboBox<String> cm_tingkat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_nilai;
    private javax.swing.JLabel txt_id;
    private javax.swing.JTextField txt_kelas;
    private javax.swing.JLabel txt_mahad;
    private javax.swing.JTextField txt_nilai;
    private javax.swing.JTextField txt_nim;
    // End of variables declaration//GEN-END:variables
}
