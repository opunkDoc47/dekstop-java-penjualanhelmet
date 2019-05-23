/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.Koneksi;
import helm.Helm;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import user.User;

/**
 *
 * @author dex
 */
public class PenjualanDaoImp implements PenjualanDaoInterface{
     Dao<penjualan, Integer> dao;
    Dao<Helm, Integer> daohelm;
    Dao<PenjualanItem, Integer> daoitem;
    public static List<PenjualanItem> listitem = new ArrayList<>();

    public PenjualanDaoImp() {
        try {
            dao = DaoManager.createDao(Koneksi.cs(), penjualan.class);
            daohelm = DaoManager.createDao(Koneksi.cs(), Helm.class);
            daoitem = DaoManager.createDao(Koneksi.cs(), PenjualanItem.class);

        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void tambahTabel(penjualan p) {
         try {
             dao.create(p);
             for(PenjualanItem q : listitem){
             PenjualanItem penjualan=new PenjualanItem();
             penjualan.setHelm(q.getHelm());
             penjualan.setpenjualan_helm(p);
             penjualan.setQty(q.getQty());
             penjualan.setSubtotal(q.getSubtotal());
             daoitem.create(penjualan);
             }
         } catch (SQLException ex) {
             Logger.getLogger(PenjualanDaoImp.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public void tambahList(PenjualanItem p) {
        listitem.add(p);
    }

    @Override
    public void updateList(int y, PenjualanItem p) {
        listitem.set(y, p);
    }

    @Override
    public void hapus(int y) {
        listitem.remove(y);
    }

    @Override
    public double refrestotal() {
        double total = 0;
        for (PenjualanItem p : listitem) {
            total += p.getSubtotal();
        }
        return total;
    }

    @Override
    public List<Helm> listhelm() {
       List<Helm> s = null;
        try {
            s = daohelm.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PenjualanDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    @Override
    public DefaultTableModel lihatbelanjaan() {
        String[] j = {"id helm", "merek", "jenis", "jumlah", "sub total"};
        DefaultTableModel dtm = new DefaultTableModel(null, j);
        for (PenjualanItem item : listitem) {
            Object[] o = new Object[5];
            o[0] = item.getHelm().getIdhelm();
            o[1] = item.getHelm().getMerek();
            o[2] = item.getHelm().getJenis_helm();
            o[3] = item.getQty();
            o[4] = item.getSubtotal();
            dtm.addRow(o);
        }
        return dtm;
    }
    
}
