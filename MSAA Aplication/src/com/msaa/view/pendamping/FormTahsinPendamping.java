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
public class FormTahsinPendamping extends javax.swing.JFrame {

    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
    private DefaultTableModel model = new DefaultTableModel();
    private String pathfile;

    /**
     * Creates new form Tahsin
     */
    public FormTahsinPendamping() {
        initComponents();
        lokasi();
        getdata();
        btn_importfile.setEnabled(true);
    }

    protected void lokasi() {
        int x = layar.width / 2 - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        setLocation(x, y);
        txt_mabna.setText(pendamping.getMabna());
    }

    public void model() {

        model = new DefaultTableModel();
        tabel_tahsin.setModel(model);
        model.addColumn("id Tahsin");
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Bulan");
        model.addColumn("Juz");
        model.addColumn("Surat");
        model.addColumn("Ayat");

    }
    public void getdata(){
        try {
            model();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select T.no_tahsin, T.bulan, T.juz, T.surat, T.ayat, T.nim_mhs, M.nama from tahsin T natural join mahasantri M natural join mabna N where T.nim_mhs = M.nim_mahasantri and M.kode_mab = N.kode_mab and N.nama_mab = '"+txt_mabna.getText()+"'");

            while (data.next()) {
                Object[] obj = new Object[8];
                obj[0] = data.getString("T.no_tahsin");
                obj[1] = data.getString("T.nim_mhs");
                obj[2] = data.getString("M.nama");
                obj[3] = data.getString("T.bulan");
                obj[4] = data.getString("T.juz");
                obj[5] = data.getString("T.surat");
                obj[6] = data.getString("T.surat");
                obj[7] = data.getString("T.ayat");

                model.addRow(obj);

            }
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e);
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

        jLabel4 = new javax.swing.JLabel();
        txt_nim = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cm_bulan = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txt_juz = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txt_surah = new javax.swing.JTextField();
        txt_ayat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_tahsin = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        txt_mabna = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        txt_id = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        btn_importfile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("NIM");

        jLabel6.setText("Juz/Surat/Ayat");

        jLabel1.setText("Tahsin");

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel3.setText("Bulan");

        cm_bulan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember" }));

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setText("Kembali");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tabel_tahsin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Kelas", "Mahad", "Lantai", "Kamar", "Juz", "Surat", "ayat", "Kelancaran", "Fashohah", "Tajwid"
            }
        ));
        tabel_tahsin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_tahsinMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_tahsin);

        jLabel9.setText("Mahad");

        txt_mabna.setText("jLabel2");

        jButton6.setText("Segarkan");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Simpan");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        txt_id.setText("0");

        jButton5.setText("Pilih file csv");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btn_importfile.setText("import file");
        btn_importfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_importfileActionPerformed(evt);
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
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cm_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_mabna)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_juz, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_surah, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_ayat, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_importfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(376, 376, 376)
                        .addComponent(jLabel1)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cm_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_mabna)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_juz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_surah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ayat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_importfile)))))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new FormPendamping().setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        model();
        txt_id.setText(null);
        txt_ayat.setText(null);
        txt_juz.setText(null);
        txt_nim.setText(null);
        txt_surah.setText(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        try {

            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "insert into tahsin values (null,?,?,?,?,?)");

            statement.setString(1, cm_bulan.getSelectedItem().toString());
            statement.setString(2, txt_juz.getText());
            statement.setString(3, txt_surah.getText());
            statement.setString(4, txt_ayat.getText());
            statement.setString(5, txt_nim.getText());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Baru telah di tambahkan");

            model();
            txt_ayat.setText(null);
            txt_id.setText(null);
            txt_juz.setText(null);
            txt_nim.setText(null);
            txt_surah.setText(null);
            getdata();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "gagal menambah Data");
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            model();
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet data = stmt.executeQuery("select T.no_tahsin, T.bulan, T.juz, T.surat, T.ayat, T.nim_mhs, M.nama from tahsin T natural join mahasantri M natural join mabna N where T.nim_mhs = M.nim_mahasantri and M.kode_mab = N.kode_mab and N.nama_mab = '"+txt_mabna.getText()+"' and T.nim_mhs like '%" + txt_nim.getText() + "%' and T.bulan = '" + cm_bulan.getSelectedItem().toString() + "'");

            while (data.next()) {
                Object[] obj = new Object[8];
                obj[0] = data.getString("T.no_tahsin");
                obj[1] = data.getString("T.nim_mhs");
                obj[2] = data.getString("M.nama");
                obj[3] = data.getString("T.bulan");
                obj[4] = data.getString("T.juz");
                obj[5] = data.getString("T.surat");
                obj[6] = data.getString("T.surat");
                obj[7] = data.getString("T.ayat");

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
                    "delete from tahsin where no_tahsin =?");

            statement.setString(1, txt_id.getText());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil di Hapus");
            model();
            txt_id.setText(null);
            txt_ayat.setText(null);
            txt_juz.setText(null);
            txt_nim.setText(null);
            txt_surah.setText(null);
            getdata();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        try {
            PreparedStatement statement = koneksi.koneksiDB().prepareStatement(
                    "update nilai set bulan = ? ,juz = ? ,surat = ? ,ayat = ?, nim_mhs = ? where no_tahsin = ?");

            statement.setString(1, cm_bulan.getSelectedItem().toString());
            statement.setString(2, txt_juz.getText());
            statement.setString(3, txt_surah.getText());
            statement.setString(4, txt_ayat.getText());
            statement.setString(6, txt_nim.getText());
            statement.setString(7, txt_id.getText());
            statement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            model();
            txt_id.setText(null);
            txt_ayat.setText(null);
            txt_juz.setText(null);
            txt_nim.setText(null);
            txt_surah.setText(null);
            getdata();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooseFile = new JFileChooser();
        chooseFile.showOpenDialog(null);
        File file = chooseFile.getSelectedFile();
        pathfile = file.getAbsolutePath();
        btn_importfile.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_importfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_importfileActionPerformed
        // TODO add your handling code here:
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathfile));
            String line;
            int pas = 0;
            while ((line = br.readLine()) != null) {

                String[] value = line.split(",");
                String sql = "insert into tahsin values (null,?,?,?,?,?)";
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
                    stmt.executeUpdate();
                    stmt.close();
                    
                    
                }

            }

            br.close();
            JOptionPane.showMessageDialog(null, "Import data berhasil !");
            btn_importfile.setEnabled(false);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btn_importfileActionPerformed

    private void tabel_tahsinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_tahsinMouseClicked
        // TODO add your handling code here:
        try {

            int row = tabel_tahsin.rowAtPoint(evt.getPoint());
            if (row > -1) {
                txt_id.setText(tabel_tahsin.getValueAt(row, 0).toString());
                txt_nim.setText(tabel_tahsin.getValueAt(row, 1).toString());
                cm_bulan.setSelectedItem(tabel_tahsin.getValueAt(row, 3).toString());
                txt_juz.setText(tabel_tahsin.getValueAt(row, 4).toString());
                txt_surah.setText(tabel_tahsin.getValueAt(row, 5).toString());
                txt_ayat.setText(tabel_tahsin.getValueAt(row, 6).toString());
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_tabel_tahsinMouseClicked

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
            java.util.logging.Logger.getLogger(FormTahsinPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTahsinPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTahsinPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTahsinPendamping.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTahsinPendamping().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_importfile;
    private javax.swing.JComboBox<String> cm_bulan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_tahsin;
    private javax.swing.JTextField txt_ayat;
    private javax.swing.JLabel txt_id;
    private javax.swing.JTextField txt_juz;
    private javax.swing.JLabel txt_mabna;
    private javax.swing.JTextField txt_nim;
    private javax.swing.JTextField txt_surah;
    // End of variables declaration//GEN-END:variables
}
