/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import pembelian.Pembelian;
import penjualan.penjualan;

/**
 *
 * @author dex
 */
@DatabaseTable(tableName = "user")
public class User {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String nama;
    @DatabaseField
    private String alamat;
    @DatabaseField
    private String bagian;
    @DatabaseField
    private String username;
    @DatabaseField
    private String NO_TELEPON;
    @DatabaseField
    private String pass;

    @ForeignCollectionField
    private ForeignCollection<Pembelian> pembelian;
    @ForeignCollectionField
    private ForeignCollection<penjualan> penjualan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getBagian() {
        return bagian;
    }

    public void setBagian(String bagian) {
        this.bagian = bagian;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String nik) {
        this.username = nik;
    }

    public String getNO_TELEPON() {
        return NO_TELEPON;
    }

    public void setNO_TELEPON(String NO_TELEPON) {
        this.NO_TELEPON = NO_TELEPON;
    }

    public ForeignCollection<Pembelian> getPembelian() {
        return pembelian;
    }

    public void setPembelian(ForeignCollection<Pembelian> pembelian) {
        this.pembelian = pembelian;
    }

    public ForeignCollection<penjualan> getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(ForeignCollection<penjualan> penjualan) {
        this.penjualan = penjualan;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
