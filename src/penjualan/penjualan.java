/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import user.User;

/**
 *
 * @author dex
 */
@DatabaseTable(tableName = "penjualan_helm")
public class penjualan {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private User user;
    @DatabaseField
    private double total;
    @DatabaseField
    private String tanggal;
    @ForeignCollectionField
    private ForeignCollection<PenjualanItem> penjualanitem;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public ForeignCollection<PenjualanItem> getPenjualanitem() {
        return penjualanitem;
    }

    public void setPenjualanitem(ForeignCollection<PenjualanItem> penjualanitem) {
        this.penjualanitem = penjualanitem;
    }
    

    
}
