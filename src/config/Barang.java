/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class Barang extends DatabaseModel{
    
    public Barang(){
        super();
    }
    
    // ------------------------------------------------------------------------------------------------------------------   
//    function for show data barang in user
    public int barangTableUser(JTable table){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Barang");
        model.addColumn("Jenis");
        model.addColumn("Jumlah");
        //menampilkan data database kedalam tabel
        int no=0;
        try {
            String sql = "select nama_brg,jenis_brg,jumlah_brg from data_barang";
            java.sql.ResultSet res = this.exec(sql);
            while(res.next()){
                model.addRow(new Object[]{
                    ++no,res.getString("nama_brg"),res.getString("jenis_brg"),
                    res.getString("jumlah_brg")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
        return no;
    }
// ------------------------------------------------------------------------------------------------------------------   
//    function for show data barang in user
    public int barangTableAdmin(JTable table){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("ID");
        model.addColumn("Barang");
        model.addColumn("Jenis");
        model.addColumn("Status");
        model.addColumn("Jumlah");
        //menampilkan data database kedalam tabel
        int no=0;
        try {
            String sql = "select * from data_barang";
            java.sql.ResultSet res = this.exec(sql);
            while(res.next()){
                model.addRow(new Object[]{
                    ++no,res.getString("id_brg"),res.getString("nama_brg"),res.getString("jenis_brg"),res.getString("status_brg"),
                    res.getString("jumlah_brg")});
            }
            table.setModel(model);
        } catch (Exception e) {
        }
        return no;
    }
// ------------------------------------------------------------------------------------------------------------------   
    @Override
    public boolean deleteBarang(int id){
        boolean result = false;
        try{
            this.deleteData(id, "data_barang", "id_brg");
            result = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return result;
    }    
// ------------------------------------------------------------------------------------------------------------------   
    @Override
    public boolean insertBarang(String [] param){
        boolean result = false;
        try{
            String sql = "INSERT INTO data_barang (nama_brg,jenis_brg,satuan_brg,jumlah_brg)"
                            + "VALUES ('"+param[0]+"','"+param[1]+"','"+param[2]+"','"+param[3]+"')";
            this.insertData(sql);
            result = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return result;
    }    
// ------------------------------------------------------------------------------------------------------------------   

}
