/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembelian;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import supplier.Supplier;
import user.User;

/**
 *
 * @author dex
 */
@DatabaseTable(tableName = "pembelian_helm")
public class Pembelian {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private User user;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Supplier supplier;
    @DatabaseField
    private double total;
    @DatabaseField
    private String tanggal;
    @ForeignCollectionField
    private ForeignCollection<Pembelianitem> pembelianitem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return user;
    }

    public void setUser_id(User user_id) {
        this.user = user_id;
    }

    public Supplier getSupplier_id() {
        return supplier;
    }

    public void setSupplier_id(Supplier supplier_id) {
        this.supplier = supplier_id;
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

    public ForeignCollection<Pembelianitem> getPembelianitem() {
        return pembelianitem;
    }

    public void setPembelianitem(ForeignCollection<Pembelianitem> pembelianitem) {
        this.pembelianitem = pembelianitem;
    }

    

}
