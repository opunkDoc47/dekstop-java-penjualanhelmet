/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dex
 */
public class Koneksi {

    public static ConnectionSource cs() {
        String database = "helm2";
        String url = "jdbc:mysql://localhost:3306/" + database;
        String user = "root";
        String pass = "";
        ConnectionSource csInit = null;
        try {
            csInit = new JdbcConnectionSource(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return csInit;
    }
}
