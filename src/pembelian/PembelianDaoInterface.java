/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembelian;

import helm.Helm;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import supplier.Supplier;
import user.User;

/**
 *
 * @author dex
 */
public interface PembelianDaoInterface {
    public void tambahTabel(Pembelian p);
    public void tambahList(Pembelianitem p);
    public void updateList(int y,Pembelianitem p);
    public void hapus(int y);
    public double refrestotal();
    List<Supplier>listsuplier();
    List<Helm>listhelm();
    DefaultTableModel lihatbelanjaan();
}
