/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penjualan;

import helm.Helm;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import user.User;

/**
 *
 * @author dex
 */
public interface PenjualanDaoInterface {
    public void tambahTabel(penjualan p);
    public void tambahList(PenjualanItem p);
    public void updateList(int y,PenjualanItem p);
    public void hapus(int y);
    public double refrestotal();
    List<Helm>listhelm();
    DefaultTableModel lihatbelanjaan();
}
