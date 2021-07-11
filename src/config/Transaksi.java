/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class Transaksi extends DatabaseModel{
    // transaksi fungsi
// ------------------------------------------------------------------------------------------------------------------   
//    function for create request in user
    public void createRequest(int id_user,String barang,String keperluan,String jumlah,String pinjam,String kembali){
        int id_barang = this.getIdBarang(barang);
        try{
            String sql = "INSERT INTO transaksi "
                        + "(id_brg,id_user,keperluan_pinjaman,banyak_pinjaman,tanggal_pinjaman,tanggal_kembali) "
                        + "VALUES"
                        + "('"+id_barang+"','"+id_user+"','"+keperluan+"','"+jumlah+"','"+pinjam+"','"+kembali+"')";
            this.insertData(sql);
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
// ------------------------------------------------------------------------------------------------------------------   
// function to create request table
    @Override
    public int showRequest(JTable table){
        String sql = "SELECT data_barang.nama_brg,"
                   + "data_user.nama_user,"
                   + "transaksi.banyak_pinjaman,transaksi.keperluan_pinjaman,"
                   + "transaksi.tanggal_pinjaman,transaksi.id_transaksi,"
                   + "transaksi.status_pinjaman,transaksi.tanggal_kembali\n" +
                     "FROM transaksi\n" +
                     "INNER JOIN data_barang ON transaksi.id_brg = data_barang.id_brg "
                   + "JOIN data_user ON transaksi.id_user = data_user.id_user; ";
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("No Transaksi");
            model.addColumn("Barang");
            model.addColumn("Pemohon");
            model.addColumn("Jumlah");
            model.addColumn("Keperluan");
            model.addColumn("Tgl pinjam");
            model.addColumn("Tgl kembali");
            model.addColumn("Status Pinjaman");
            
            int no=0;
        try {
            java.sql.ResultSet res = this.exec(sql);
            while(res.next()){
                model.addRow(new Object[]
                {
                 ++no,
                 res.getString("id_transaksi"),
                 res.getString("nama_brg"),
                 res.getString("nama_user"),
                 res.getString("banyak_pinjaman"),
                 res.getString("keperluan_pinjaman"),
                 res.getString("tanggal_pinjaman"),
                 res.getString("tanggal_kembali"),
                 res.getString("status_pinjaman")
                });
            }
            table.setModel(model);
        } catch (Exception e) {
        }
        return no;
    }
// ------------------------------------------------------------------------------------------------------------------   
    public int showNewRequest(JTable table){
        String sql = "SELECT data_barang.nama_brg,data_barang.jumlah_brg,"
                   + "data_user.nama_user,"
                   + "transaksi.banyak_pinjaman,transaksi.keperluan_pinjaman,"
                   + "transaksi.tanggal_pinjaman,transaksi.id_transaksi,transaksi.status_pinjaman,transaksi.tanggal_kembali\n" +
                     "FROM transaksi\n" +
                     "INNER JOIN data_barang ON transaksi.id_brg = data_barang.id_brg "
                   + "JOIN data_user ON transaksi.id_user = data_user.id_user WHERE transaksi.status_pinjaman = 'Pending'; ";
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("No Transaksi");
            model.addColumn("Barang");
            model.addColumn("Pemohon");
            model.addColumn("Jumlah");
            model.addColumn("Keperluan");
            model.addColumn("Tgl pinjam");
            model.addColumn("Tgl kembali");
            model.addColumn("Stock");
            model.addColumn("Status Pinjaman");
            
            int no=0;
        try {
            java.sql.ResultSet res = this.exec(sql);
            while(res.next()){
                model.addRow(new Object[]
                {
                 ++no,
                 res.getString("id_transaksi"),
                 res.getString("nama_brg"),
                 res.getString("nama_user"),
                 res.getString("banyak_pinjaman"),
                 res.getString("keperluan_pinjaman"),
                 res.getString("tanggal_pinjaman"),
                 res.getString("tanggal_kembali"),
                 res.getString("jumlah_brg"),
                 res.getString("status_pinjaman")
                });
            }
            table.setModel(model);
        } catch (Exception e) {
        }
        return no;
    }
// ------------------------------------------------------------------------------------------------------------------    
    public int showUserRequest(JTable table,int id){
        int no = 0;
        String sql = "SELECT data_barang.nama_brg,data_barang.jumlah_brg,"
                   + "transaksi.banyak_pinjaman,transaksi.keperluan_pinjaman,"
                   + "transaksi.status_pinjaman\n" +
                     "FROM transaksi\n" +
                     "INNER JOIN data_barang ON transaksi.id_brg = data_barang.id_brg "
                   + "JOIN data_user ON transaksi.id_user = data_user.id_user "
                   + "WHERE data_user.id_user ="+"'"+id+"'";
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No");
            model.addColumn("Barang");
            model.addColumn("Jumlah");
            model.addColumn("Keperluan");
            model.addColumn("Stock");
            model.addColumn("Status Pinjaman");
            
        try {
            java.sql.ResultSet res = this.exec(sql);
            while(res.next()){
                model.addRow(new Object[]
                {
                 ++no,
                 res.getString("nama_brg"),
                 res.getString("banyak_pinjaman"),
                 res.getString("keperluan_pinjaman"),
                 res.getString("jumlah_brg"),
                 res.getString("status_pinjaman")
                });
            }
            table.setModel(model);
        } catch (Exception e) {
        }
        return no;
    }
// ------------------------------------------------------------------------------------------------------------------
    public void approveReq(int idTransaksi){
        String status = "Approve";
        String sql = "UPDATE transaksi SET status_pinjaman = "+"'"+status+"'" +" WHERE transaksi.id_transaksi="+"'"+idTransaksi+"'";
        try{
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.Statement stm=conn.createStatement();
            int res = stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Request berhasil di approve");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Request gagal di approve Error: "+e.getMessage());
        }
    }
}
