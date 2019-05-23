/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import helm.Helm;

/**
 *
 * @author dex
 */
@DatabaseTable(tableName = "itemjual")
public class PenjualanItem {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private penjualan penjualan_helm;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Helm helm;
    @DatabaseField
    private double subtotal;
    @DatabaseField
    private int qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public penjualan getpenjualan_helm() {
        return penjualan_helm;
    }

    public void setpenjualan_helm(penjualan pembelian_helm) {
        this.penjualan_helm = pembelian_helm;
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
