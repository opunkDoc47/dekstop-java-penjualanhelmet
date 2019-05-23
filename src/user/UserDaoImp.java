/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.DAO;
import database.Koneksi;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dex
 */
public class UserDaoImp implements DAO {

    Dao<User, Integer> dao;

    public UserDaoImp() {
        try {
            dao = DaoManager.createDao(Koneksi.cs(), User.class);
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insert(Object o) {
        try {
            dao.create((User) o);
            JOptionPane.showMessageDialog(null, "tambah data berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object o) {
        try {
            dao.update((User) o);
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.deleteById(id);
        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel selectAll() {
        String[] kolom = {"nip", "nama", "bagian", "no hp", "username", "alamat","pass"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);
        try {
            List<User> user = dao.queryForAll();
            for (User u : user) {
                Object o[] = new Object[7];
                o[0] = u.getId();
                o[1] = u.getNama();
                o[2] = u.getBagian();
                o[3] = u.getNO_TELEPON();
                o[4] = u.getUsername();
                o[5] = u.getAlamat();
                o[6]=u.getPass();
                dtm.addRow(o);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

    @Override
    public DefaultTableModel cari(String key) {
        String[] kolom = {"nip", "nama", "bagian", "no hp", "nik", "alamat","pass"};
        DefaultTableModel dtm = new DefaultTableModel(null, kolom);
        try {
            List<User> user = dao.queryBuilder().where().like("nama", "%" + key + "%").query();
            for (User u : user) {
                Object o[] = new Object[7];
                o[0] = u.getId();
                o[1] = u.getNama();
                o[2] = u.getBagian();
                o[3] = u.getNO_TELEPON();
                o[4] = u.getUsername();
                o[5] = u.getAlamat();
                o[6] = u.getPass();
                dtm.addRow(o);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dtm;
    }

}
