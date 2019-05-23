/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helm;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import pembelian.Pembelianitem;
import penjualan.PenjualanItem;

/**
 *
 * @author dex
 */
@DatabaseTable(tableName = "helm")
public class Helm {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField
    private String jenis_helm;
    @DatabaseField
    private String merek;
    @DatabaseField
    private int jumlah;
    @DatabaseField
    private double hargabeli;
    @DatabaseField
    private double hargajual;
    @ForeignCollectionField
    private ForeignCollection<PenjualanItem> penjualanitem;
    @ForeignCollectionField
    private ForeignCollection<Pembelianitem> pembelianitem;

    public double getHargabeli() {
        return hargabeli;
    }

    public void setHargabeli(double hargabeli) {
        this.hargabeli = hargabeli;
    }

    public double getHargajual() {
        return hargajual;
    }

    public void setHargajual(double hargajual) {
        this.hargajual = hargajual;
    }

    public int getIdhelm() {
        return id;
    }

    public void setIdhelm(int idhelm) {
        this.id = idhelm;
    }

    public String getJenis_helm() {
        return jenis_helm;
    }

    public void setJenis_helm(String jenis_helm) {
        this.jenis_helm = jenis_helm;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
