/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembelian;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import helm.Helm;

/**
 *
 * @author dex
 */
@DatabaseTable(tableName = "itemBeli")
public class Pembelianitem {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Pembelian pembelian_helm;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Helm helm;
    @DatabaseField
    private double subtotal;
    @DatabaseField
    private int qty;

    public int getIditemBeli() {
        return id;
    }

    public void setIditemBeli(int iditemBeli) {
        this.id = iditemBeli;
    }

    public Pembelian getPembelian_helm() {
        return pembelian_helm;
    }

    public void setPembelian_helm(Pembelian pembelian_helm) {
        this.pembelian_helm = pembelian_helm;
    }

    public Helm getHelm() {
        return helm;
    }

    public void setHelm(Helm helm) {
        this.helm = helm;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    

}
