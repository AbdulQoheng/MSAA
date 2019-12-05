/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.msaa.view;

import model.main;
import model.koneksi;
import com.msaa.view.admin.FormAdmin;
import com.msaa.view.pendamping.FormPendamping;
import com.mysql.jdbc.Connection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.pendamping;
import javax.swing.ImageIcon;

/**
 *
 * @author qoheng
 */
public class login extends javax.swing.JFrame {
    
    Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
        lokasi();
        setIcon();
    
        setTitle("MSAA Application");
    }
    
    protected void lokasi(){
        int x = layar.width / 2  -this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        setLocation(x, y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userid_txt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        login = new javax.swing.JLabel();
        pass_txt = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userid_txt.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        userid_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        userid_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userid_txtActionPerformed(evt);
            }
        });
        getContentPane().add(userid_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 140, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        jLabel3.setText("User ID");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 10)); // NOI18N
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, -1, -1));

        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 110, 40));

        login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginMouseClicked(evt);
            }
        });
        getContentPane().add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 110, 40));

        pass_txt.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        pass_txt.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        getContentPane().add(pass_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 140, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1LOGINl.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userid_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userid_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userid_txtActionPerformed

    private void loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginMouseClicked
   try {
            Connection conn = (Connection) koneksi.koneksiDB();
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("select* from admin where user='" + userid_txt.getText() + "' and password='" + pass_txt.getText() + "'");
            Statement stmt1 = conn.createStatement();
            ResultSet result1 = stmt1.executeQuery("select M.nama_mab, A.userid, A.nama, A.password , D.nama_devisi from acount_musyrifah A, mabna M natural join devisi D where M.kode_mab = A.kode_mab and A.id_devisi = D.id_devisi and A.userid='" + userid_txt.getText() + "' and A.password='" + pass_txt.getText() + "'");

            if (result.next()) {

                JOptionPane.showMessageDialog(null, "Log In Sukses");
                main.setUser(userid_txt.getText());
                FormAdmin n = new FormAdmin();
                n.setVisible(true);
                this.setVisible(false);

            } else if (result1.next()) {

                JOptionPane.showMessageDialog(null, "Log In Sukses");
                pendamping.setUserid(userid_txt.getText());
                pendamping.setNama(result1.getString("A.nama"));
                pendamping.setMabna(result1.getString("M.nama_mab"));
                pendamping.setDevisi(result1.getString("D.nama_devisi"));
                pendamping.setPass(pass_txt.getText());
                
                FormPendamping n = new FormPendamping();
                n.setVisible(true);
                this.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "Username atau password anda salah");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_loginMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
    if (JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan keluar ?", " MSAA Application ", 2)
                == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitMouseClicked

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel login;
    private javax.swing.JPasswordField pass_txt;
    private javax.swing.JTextField userid_txt;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
   
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("rsz_picture1.png"))); }
}
