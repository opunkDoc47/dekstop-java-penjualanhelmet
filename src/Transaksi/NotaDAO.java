/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dex
 */
public interface NotaDAO {

    public DefaultTableModel penjualan();
    public DefaultTableModel pembelian();
    public DefaultTableModel penjualanitem(int k);
    public DefaultTableModel pembelianitem(int k);
}
