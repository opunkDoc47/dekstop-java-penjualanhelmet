/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembelian;

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
import supplier.Supplier;
import user.User;

/**
 *
 * @author dex
 */
public class PembelianDAOImp implements PembelianDaoInterface {

    Dao<Pembelian, Integer> dao;
    Dao<Helm, Integer> daohelm;
    Dao<Pembelianitem, Integer> daoitem;
    Dao<Supplier, Integer> daosupplier;
    public static List<Pembelianitem> listitem = new ArrayList<>();

    public PembelianDAOImp() {
        try {
            dao = DaoManager.createDao(Koneksi.cs(), Pembelian.class);
            daohelm = DaoManager.createDao(Koneksi.cs(), Helm.class);
            daosupplier = DaoManager.createDao(Koneksi.cs(), Supplier.class);
            daoitem = DaoManager.createDao(Koneksi.cs(), Pembelianitem.class);

        } catch (SQLException ex) {
            Logger.getLogger(PembelianDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Supplier> listsuplier() {
        List<Supplier> s = null;
        try {
            s = daosupplier.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PembelianDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    @Override
    public List<Helm> listhelm() {
        List<Helm> s = null;
        try {
            s = daohelm.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(PembelianDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    @Override
    public void tambahTabel(Pembelian p) {
        try {
               dao.create(p);
            for (Pembelianitem i : listitem) {
                Pembelianitem pembelianItem = new Pembelianitem();
                //set pembelian
                pembelianItem.setPembelian_helm(p);
                pembelianItem.setQty(i.getQty());
                pembelianItem.setSubtotal(i.getSubtotal());
                //setbarang
                pembelianItem.setHelm(i.getHelm());
                daoitem.create(pembelianItem);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PembelianDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel lihatbelanjaan() {
        String[] j = {"id helm", "merek", "jenis", "jumlah", "sub total"};
        DefaultTableModel dtm = new DefaultTableModel(null, j);
        for (Pembelianitem item : listitem) {
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

    @Override
    public void tambahList(Pembelianitem p) {
        listitem.add(p);
    }

    @Override
    public void updateList(int y, Pembelianitem p) {
        listitem.set(y, p);
    }

    @Override
    public void hapus(int y) {
        listitem.remove(y);
    }

    @Override
    public double refrestotal() {
        double total = 0;
        for (Pembelianitem p : listitem) {
            total += p.getSubtotal();
        }
        return total;
    }

}
