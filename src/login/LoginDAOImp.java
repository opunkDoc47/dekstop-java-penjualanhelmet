/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.Koneksi;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import user.User;

/**
 *
 * @author dex
 */
public class LoginDAOImp implements LoginDAO {

    private Dao<User, Integer> dao;

    public LoginDAOImp() {
        try {
            //hubungkan cs dengan dao
            dao = DaoManager.createDao(Koneksi.cs(), User.class);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void login(String username, String password) {
        try {
            User user = dao.queryBuilder().where()
                    .eq("username", username)
                    .and()
                    .eq("pass", password)
                    .queryForFirst();
            if(user != null){
                Login.ID = user.getId();
                Login.NAMA = user.getNama();
                Login.AUTH = true;
                Login.Bagian=user.getBagian();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @Override
    public void logout() {
                Login.ID = 0;
                Login.NAMA = null;
                Login.AUTH = false;
                Login.Bagian=null;
    }

}
