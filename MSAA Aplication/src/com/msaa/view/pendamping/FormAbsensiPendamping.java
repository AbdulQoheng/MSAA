/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msaa.view.pendamping;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.koneksi;
import model.pendamping;

/**
 *
 * @author qoheng
 */
public class FormAbsensiPendamping extends javax.swing.JFrame {

    private DefaultTableModel model = new DefaultTableModel();
    private String pathfile;
    private JTable table;
    /**
     * Creates new form ATaklimAfkar
     */
    public FormAbsensiPendamping() {
        initComponents();
        setLocationRelativeTo(null);
        awal();
        model();
        getdata();
        
        btn_Importfile.setEnabled(false);
    }

    public void awal() {
        try {
            txt_mabna.setText(pendamping.getMabna());
            cm_tingkatan.removeAllItems();
            cm_taklim.removeAllItems();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt1 = conn.createStatement();
            Statement stmt2 = conn.createStatement();
            ResultSet tingkat = stmt1.executeQuery("select namatingkat from tingakTaklim");
            ResultSet taklim = stmt2.executeQuery("select namaTakl from taklim");

            while (tingkat.next()) {
                String obj = tingkat.getString("namatingkat");
                cm_tingkatan.addItem(obj);

            }
            while (taklim.next()) {
                String obj = taklim.getString("namaTakl");
                cm_taklim.addItem(obj);

            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
        }
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
        model.addColumn("Hadir");
        model.addColumn("Alpha");
        model.addColumn("Izin");
        model.addColumn("Sakit");

    }
    public void getdata() {
        try {
            model();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select M.nim_mahasantri, M.nama, A.no_absen, A.bulan, T.namaTakl, N.namatingkat , A.kelastakl, A.Hadir, A.alpha, A.izin, A.sakit, U.nama_mab from mahasantri M, absen A, taklim T, tingakTaklim N, mabna U where M.nim_mahasantri = A.nim_mhs and M.kode_mab = U.kode_mab and A.no_tingkattak = N.no_tingkattak and T.no_Takl = A.no_Takl");

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cm_bulan = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_absen = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_mabna = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        cm_taklim = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_hadi = new javax.swing.JTextField();
        txt_alpha = new javax.swing.JTextField();
        txt_izin = new javax.swing.JTextField();
        txt_sakit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cm_tingkatan = new javax.swing.JComboBox<>();
        txt_no = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_kelas = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btn_Importfile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("NIM");

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel15.setText("Absensi");

        jLabel3.setText("Bulan");

        jLabel9.setText("Mahad");

        cm_bulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));
        cm_bulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cm_bulanActionPerformed(evt);
            }
        });

        tabel_absen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "NIM", "Nama", "tanggal", "Hadir", "Izin", "Sakit", "Alpha"
            }
        ));
        tabel_absen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_absenMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_absen);

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

        txt_mabna.setText("jLabel10");

        jLabel8.setText("Taklim");

        jButton5.setText("Segarkan");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Simpan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        cm_taklim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Hadir");

        jLabel5.setText("Alpha");

        jLabel6.setText("Izin");

        jLabel7.setText("Sakit");

        jLabel2.setText("Tingkat");

        cm_tingkatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txt_no.setText("0");

        jLabel11.setText("Kelas");

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton7.setText("Pilih File SCV");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        btn_Importfile.setText("Import File");
        btn_Importfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ImportfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(txt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246)
                .addComponent(jLabel15)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel11))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sakit, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mabna)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cm_tingkatan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cm_taklim, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_nim, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(cm_bulan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_Importfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_kelas, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_izin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                .addComponent(txt_alpha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_hadi, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txt_no, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(cm_taklim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cm_tingkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cm_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_Importfile)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(txt_mabna))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_kelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(txt_hadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txt_alpha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(txt_izin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(txt_sakit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton6)
                            .addComponent(jButton3)
                            .addComponent(jButton4)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new FormPendamping().setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void cm_bulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cm_bulanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cm_bulanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            model();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select M.nim_mahasantri, M.nama, A.no_absen, A.bulan, T.namaTakl, N.namatingkat , A.kelastakl, A.Hadir, A.alpha, A.izin, A.sakit  from mahasantri M natural join absen A natural join taklim T natural join tingakTaklim N where M.nim_mahasantri = A.nim_mhs and A.no_tingkattak = N.no_tingkattak and T.no_Takl = A.no_Takl and M.kode_mab ='" + ambilkodemabna(txt_mabna.getText()) + "' and A.bulan = '" + cm_bulan.getSelectedItem() + "' and A.nim_mhs like '%" + txt_nim.getText() + "%' and kelastakl like '%" + txt_kelas.getText() + "%' and A.no_Takl = '" + ambilidtaklim(cm_taklim.getSelectedItem().toString()) + "'");

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

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {

            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "insert into absen values (null,?,?,?,?,?,?,?,?,?)");

            statement.setString(1, cm_bulan.getSelectedItem().toString());
            statement.setString(2, txt_hadi.getText());
            statement.setString(3, txt_alpha.getText());
            statement.setString(4, txt_izin.getText());
            statement.setString(5, txt_sakit.getText());
            statement.setString(6, txt_kelas.getText());
            statement.setString(7, ambilidtingkatan(cm_tingkatan.getSelectedItem().toString()));
            statement.setString(8, ambilidtaklim(cm_taklim.getSelectedItem().toString()));
            statement.setString(9, txt_nim.getText());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Baru telah di tambahkan");

            model();
            txt_alpha.setText(null);
            txt_hadi.setText(null);
            txt_izin.setText(null);
            txt_kelas.setText(null);
            txt_nim.setText(null);
            txt_sakit.setText(null);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "gagal menambah Data");
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        model();
        getdata();
        awal();
        txt_alpha.setText(null);
        txt_hadi.setText(null);
        txt_izin.setText(null);
        txt_kelas.setText(null);
        txt_nim.setText(null);
        txt_sakit.setText(null);
        txt_no.setText(null);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tabel_absenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_absenMouseClicked
        // TODO add your handling code here:
        try {

            int row = tabel_absen.rowAtPoint(evt.getPoint());
            if (row > -1) {
                txt_no.setText(tabel_absen.getValueAt(row, 0).toString());
                txt_nim.setText(tabel_absen.getValueAt(row, 1).toString());
                cm_taklim.setSelectedItem(tabel_absen.getValueAt(row, 3).toString());
                cm_tingkatan.setSelectedItem(tabel_absen.getValueAt(row, 4).toString());
                txt_kelas.setText(tabel_absen.getValueAt(row, 5).toString());
                cm_bulan.setSelectedItem(tabel_absen.getValueAt(row, 6).toString());
                txt_hadi.setText(tabel_absen.getValueAt(row, 7).toString());
                txt_alpha.setText(tabel_absen.getValueAt(row, 8).toString());
                txt_izin.setText(tabel_absen.getValueAt(row, 9).toString());
                txt_sakit.setText(tabel_absen.getValueAt(row, 10).toString());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_tabel_absenMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {

            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "delete from absen where no_absen =?");

            statement.setString(1, txt_no.getText());
            statement.executeUpdate();
            model();

            JOptionPane.showMessageDialog(null, "Data berhasil di Hapus");
            txt_alpha.setText(null);
            txt_hadi.setText(null);
            txt_izin.setText(null);
            txt_kelas.setText(null);
            txt_nim.setText(null);
            txt_sakit.setText(null);
            txt_no.setText(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "update absen set bulan = ? ,Hadir = ? ,alpha = ? ,izin = ?,sakit = ?,kelastakl = ?,no_tingkattak = ?,no_Takl = ?  where no_absen = ?");

            statement.setString(1, cm_bulan.getSelectedItem().toString());
            statement.setString(2, txt_hadi.getText());
            statement.setString(3, txt_alpha.getText());
            statement.setString(4, txt_izin.getText());
            statement.setString(5, txt_sakit.getText());
            statement.setString(6, txt_kelas.getText());
            statement.setString(7, ambilidtingkatan(cm_tingkatan.getSelectedItem().toString()));
            statement.setString(8, ambilidtaklim(cm_taklim.getSelectedItem().toString()));
            statement.setString(9, txt_no.getText());
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            model();
            txt_alpha.setText(null);
            txt_hadi.setText(null);
            txt_izin.setText(null);
            txt_kelas.setText(null);
            txt_nim.setText(null);
            txt_sakit.setText(null);
            txt_no.setText(null);
            getdata();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooseFile = new JFileChooser();
        chooseFile.showOpenDialog(null);
        File file = chooseFile.getSelectedFile();
        pathfile = file.getAbsolutePath();
        btn_Importfile.setEnabled(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btn_ImportfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ImportfileActionPerformed
        // TODO add your handling code here:
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathfile));
            String line;
            int pas = 0;
            while ((line = br.readLine()) != null) {

                String[] value = line.split(",");
                String sql = "insert into absen values (null,?,?,?,?,?,?,?,?,?)";
                java.sql.Connection conn = (java.sql.Connection) koneksi.koneksiDB();
                PreparedStatement stmt = conn.prepareStatement(sql);

                if (pas == 0) {
                    pas = 1;
                } else {
                    stmt.setString(1, value[0]);
                    stmt.setString(2, value[1]);
                    stmt.setString(3, value[2]);
                    stmt.setString(4, value[3]);
                    stmt.setString(5, value[4]);
                    stmt.setString(6, value[5]);
                    stmt.setString(7, value[6]);
                    stmt.setString(8, value[7]);
                    stmt.setString(9, value[8]);
                    stmt.executeUpdate();
                    stmt.close();
                    awal();
                    
                }

            }

            br.close();
            JOptionPane.showMessageDialog(null, "Import data berhasil !");
            btn_Importfile.setEnabled(false);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    
    }//GEN-LAST:event_btn_ImportfileActionPerformed

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
            java.util.logging.Logger.getLogger(FormAbsensiPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAbsensiPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAbsensiPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAbsensiPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAbsensiPendamping().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Importfile;
    private javax.swing.JComboBox<String> cm_bulan;
    private javax.swing.JComboBox<String> cm_taklim;
    private javax.swing.JComboBox<String> cm_tingkatan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabel_absen;
    private javax.swing.JTextField txt_alpha;
    private javax.swing.JTextField txt_hadi;
    private javax.swing.JTextField txt_izin;
    private javax.swing.JTextField txt_kelas;
    private javax.swing.JLabel txt_mabna;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JLabel txt_no;
    private javax.swing.JTextField txt_sakit;
    // End of variables declaration//GEN-END:variables
}
