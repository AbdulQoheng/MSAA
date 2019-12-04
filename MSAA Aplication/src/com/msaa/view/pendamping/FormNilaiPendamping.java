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
                
                model();
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
        txt_id = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Tingkatan");

        jButton3.setText("Kembali");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cm_tingkat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Mahad");

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

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Simpan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Jenis");

        cm_jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "UTS", "UAS" }));

        jLabel2.setText("Taklim");

        cm_taklim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Nilai");

        jLabel6.setText("NIM");

        jLabel7.setText("Nilai");

        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Hapus");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        txt_mahad.setText("jLabel8");

        jLabel3.setText("Kelas");

        txt_id.setText("0");

        jButton6.setText("Segarkan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_nim, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(cm_taklim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cm_tingkat, 0, 183, Short.MAX_VALUE)
                            .addComponent(txt_kelas))
                        .addGap(106, 106, 106)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cm_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mahad)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)))))
                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_id))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txt_mahad))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cm_jenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cm_taklim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cm_tingkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

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
                
                model();
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
