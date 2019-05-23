/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import database.Koneksi;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import pembelian.Pembelian;
import pembelian.Pembelianitem;
import penjualan.PenjualanItem;
import penjualan.penjualan;

/**
 *
 * @author dex
 */
public class NotaDaoImp implements NotaDAO {

    private Dao<Pembelian, Integer> daobeli;
    private Dao<Pembelianitem, Integer> daoItembeli;
    Dao<penjualan, Integer> daojual;
    Dao<PenjualanItem, Integer> daoitemjual;

    public NotaDaoImp() {
        try {
            daobeli = DaoManager.createDao(Koneksi.cs(), Pembelian.class);
            daoItembeli = DaoManager.createDao(Koneksi.cs(), Pembelianitem.class);
            daojual = DaoManager.createDao(Koneksi.cs(), penjualan.class);
            daoitemjual = DaoManager.createDao(Koneksi.cs(), PenjualanItem.class);

        } catch (SQLException ex) {
            Logger.getLogger(NotaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DefaultTableModel penjualan() {
        List<penjualan> penjualan = null;
        try {
            penjualan = daojual.queryForAll();

        } catch (SQLException ex) {
            Logger.getLogger(NotaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] j = {"id transaksi", "tanggal", "total"};
        DefaultTableModel dtm = new DefaultTableModel(null, j);
        for (penjualan p : penjualan) {
            Object[] o = new Object[5];
            o[0] = p.getId();
            o[1] = p.getTanggal();
            o[2] = p.getTotal();
            dtm.addRow(o);
        }

        return dtm;
    }

    @Override
    public DefaultTableModel pembelian() {
        List<Pembelian> pembelian = null;
        try {
            pembelian = daobeli.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(NotaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] j = {"id transaksi", "tanggal", "total"};
        DefaultTableModel dtm = new DefaultTableModel(null, j);
        for (Pembelian p : pembelian) {
            Object[] o = new Object[5];
            o[0] = p.getId();
            o[1] = p.getTanggal();
            o[2] = p.getTotal();
            dtm.addRow(o);
        }
        return dtm;
    }

    @Override
    public DefaultTableModel penjualanitem(int k) {
        List<PenjualanItem> penjualanitem = null;
        try {
            penjualanitem = daoitemjual.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(NotaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] j = {"id helm", "merek", "jenis", "jumlah", "sub total"};
        DefaultTableModel dtm = new DefaultTableModel(null, j);
        for (PenjualanItem item : penjualanitem) {
            if (k == item.getpenjualan_helm().getId()) {
                Object[] o = new Object[5];
                o[0] = item.getHelm().getIdhelm();
                o[1] = item.getHelm().getMerek();
                o[2] = item.getHelm().getJenis_helm();
                o[3] = item.getQty();
                o[4] = item.getSubtotal();
                dtm.addRow(o);
            }

        }
        return dtm;
    }

    @Override
    public DefaultTableModel pembelianitem(int k) {
        List<Pembelianitem> pembelianitem = null;
        try {
            pembelianitem = daoItembeli.queryForAll();
        } catch (SQLException ex) {
            Logger.getLogger(NotaDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] j = {"id helm", "merek", "jenis", "jumlah", "sub total"};
        DefaultTableModel dtm = new DefaultTableModel(null, j);
        for (Pembelianitem item : pembelianitem) {
            if (k == item.getPembelian_helm().getId()) {
                Object[] o = new Object[5];
                o[0] = item.getHelm().getIdhelm();
                o[1] = item.getHelm().getMerek();
                o[2] = item.getHelm().getJenis_helm();
                o[3] = item.getQty();
                o[4] = item.getSubtotal();
                dtm.addRow(o);
            }

        }
        return dtm;
    }

}
