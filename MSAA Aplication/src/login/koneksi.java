/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 *
 * @author ABD, Qohar Agus Maulana (18650051)
 * @author Rizki Fitriani (18650053)
 * @author Annisa Rizkiana Putri (18650048)
 * @author Nisa Kholifatul Ummah (18650065)
 * 
 */
public class koneksi {
    private static Connection mysqlkonek;
    
    public static void main(String[] args) throws SQLException{
        koneksiDB();
    }
    
    public static Connection koneksiDB() throws SQLException {
        if(mysqlkonek==null){
            try {
                String DB="jdbc:mysql://localhost:3306/msaa"; // tabungan_haji database
                String user="root"; // user database
                String pass=""; // password database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(DB,user,pass);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Koneksi Gagal");
            }
        }
        return mysqlkonek;
        
    }
}
