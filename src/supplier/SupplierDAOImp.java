/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplier;

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
public class SupplierDAOImp implements DAO{
Dao<Supplier, Integer> dao;

    public SupplierDAOImp(){
        try {
          dao=DaoManager.createDao(Koneksi.cs(), Supplier.class); 
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAOImp.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
     @Override
    public void insert(Object o) {
        try {
            dao.create((Supplier)o);
            JOptionPane.showMessageDialog(null, "tambah data berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object o) {
        try {
            dao.update((Supplier)o);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.deleteById(id);
        } catch (SQLException ex) {
            Logger.getLogger(SupplierDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel selectAll() {
       String[]kolom={"id supplier","nama perusahaan","alamat","no telp"};
        DefaultTableModel dtm =new DefaultTableModel(null, kolom);
    try {
        List<Supplier> s =dao.queryForAll();
        for(Supplier u:s){
        Object o []=new Object[4];
        o[0]=u.getId();
        o[1]=u.getNama_suplier();
        o[2]=u.getAlamat_suplier();
        o[3]=u.getNo_hp();
        dtm.addRow(o);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(SupplierDAOImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dtm;
    }

    @Override
    public DefaultTableModel cari(String key) {
        String[]kolom={"id supplier","nama perusahaan","alamat","no telp"};
        DefaultTableModel dtm =new DefaultTableModel(null, kolom);
    try {
        List<Supplier> s =dao.queryBuilder().where().like("idsupplier", "%"+key+"%").query();
        for(Supplier u:s){
        Object o []=new Object[4];
        o[0]=u.getId();
        o[1]=u.getNama_suplier();
        o[2]=u.getAlamat_suplier();
        o[3]=u.getNo_hp();
        dtm.addRow(o);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(SupplierDAOImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dtm;
    }
    
}
