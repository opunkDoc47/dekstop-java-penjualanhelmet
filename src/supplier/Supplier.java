/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplier;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import pembelian.Pembelian;

/**
 *
 * @author dex
 */
@DatabaseTable(tableName = "supplier")
public class Supplier {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nama_suplier;
    @DatabaseField
    private String alamat_suplier;
    @DatabaseField
    private String no_hp;
    @ForeignCollectionField
    private ForeignCollection<Pembelian> pembelianitem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_suplier() {
        return nama_suplier;
    }

    public void setNama_suplier(String nama_suplier) {
        this.nama_suplier = nama_suplier;
    }

    public String getAlamat_suplier() {
        return alamat_suplier;
    }

    public void setAlamat_suplier(String alamat_suplier) {
        this.alamat_suplier = alamat_suplier;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public ForeignCollection<Pembelian> getPembelianitem() {
        return pembelianitem;
    }

    public void setPembelianitem(ForeignCollection<Pembelian> pembelianitem) {
        this.pembelianitem = pembelianitem;
    }

    
}
