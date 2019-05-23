/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helm;

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
public class HelmDAOImp implements DAO {

    Dao<Helm, Integer> dao;

    public HelmDAOImp(){
        try {
          dao=DaoManager.createDao(Koneksi.cs(), Helm.class); 
        } catch (SQLException ex) {
            Logger.getLogger(HelmDAOImp.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    @Override
    public void insert(Object o) {
        try {
            dao.create((Helm)o);
            JOptionPane.showMessageDialog(null, "tambah data berhasil");
        } catch (SQLException ex) {
            Logger.getLogger(HelmDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object o) {
        try {
            dao.update((Helm)o);
        } catch (SQLException ex) {
            Logger.getLogger(HelmDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(int id) {
        try {
            dao.deleteById(id);
        } catch (SQLException ex) {
            Logger.getLogger(HelmDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel selectAll() {
        String[]kolom={"kode helm","merek","jenis","jumlah stok","harga beli","harga jual"};
        DefaultTableModel dtm =new DefaultTableModel(null, kolom);
    try {
        List<Helm> h =dao.queryForAll();
        for(Helm u:h){
        Object o []=new Object[6];
        o[0]=u.getIdhelm();
        o[1]=u.getMerek();
        o[2]=u.getJenis_helm();
        o[3]=u.getJumlah();
        o[4]=u.getHargabeli();
        o[5]=u.getHargajual();
        dtm.addRow(o);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(HelmDAOImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dtm;
    }

    @Override
    public DefaultTableModel cari(String key) {
        String[]kolom={"kode helm","merek","jenis","jumlah stok"};
        DefaultTableModel dtm =new DefaultTableModel(null, kolom);
    try {
        List<Helm> h =dao.queryBuilder().where().like("jenis_helm", key).query();
        for(Helm u:h){
        Object o []=new Object[4];
        o[0]=u.getIdhelm();
        o[1]=u.getMerek();
        o[2]=u.getJenis_helm();
        o[3]=u.getJumlah();
        dtm.addRow(o);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(HelmDAOImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    return dtm;
    }

}
