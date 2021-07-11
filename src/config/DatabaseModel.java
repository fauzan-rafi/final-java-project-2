package config;

import inventoryapp.LoginPage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import user.Dashboard;
import admin.DashboardAdmin;
import inventoryapp.Register;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DatabaseModel {
    Config config;
    
    
    
    public DatabaseModel(){
    this.config = new Config();
    }
// ------------------------------------------------------------------------------------------------------------------
// main function
    public java.sql.ResultSet exec(String sql){
        java.sql.ResultSet res = null;
        try{
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.Statement stm=conn.createStatement();
            res = stm.executeQuery(sql);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return res;
    }
// ------------------------------------------------------------------------------------------------------------------
//    function insert data
    public boolean insertData(String sql){
        boolean result = false;
        try{
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst= conn.prepareStatement(sql);
            if (pst.execute())
                result = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            result = false;
        }
        return result;
    }
// ------------------------------------------------------------------------------------------------------------------
//    function for login
    public boolean login(String username,String password){
        boolean result = false;
        String sql = "SELECT username,password,id_user,status_user FROM data_user WHERE username='"+username+"'"+"AND password='"+password+"'";
        try {
            java.sql.ResultSet res = this.exec(sql);
            if(res.next()){
                if(username.equals(res.getString("username")) && password.equals(res.getString("password"))){
                    JOptionPane.showMessageDialog(null, "berhasil login");
                    if(res.getString("status_user").equals("admin")){
                        new DashboardAdmin(res.getString("id_user")).setVisible(true);
                        result = true;
                    }else if(res.getString("status_user").equals("user")){
                        new Dashboard(res.getString("id_user")).setVisible(true);
                        result = true;
                    }else{
                        JOptionPane.showMessageDialog(null, "Status anda belum ada");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Status anda belum ada");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex.getMessage());
            result = false;
        }
        return result;
    }
    
// ------------------------------------------------------------------------------------------------------------------   
    public boolean register(String [] data)
    {
        boolean retr = false;
        try{
            String sql = "INSERT INTO data_user (nama_user,alamat_user,nomor_user,email_user,username,password) "
                    + "VALUES ('"+data[0]+"','"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"')";
            boolean result = this.insertData(sql);
            if(result)
                JOptionPane.showMessageDialog(null, "Registrasi user Berhasil");
                this.login(data[4],data[5]);
                retr = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Registrasi user gagal");
            retr = false;
        }
        return retr;
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
//    function to get id barang
    private int getIdBarang(String barang){
        int idBarang = 0;
        try {
            String sql = "SELECT id_brg FROM data_barang WHERE nama_brg="+"'"+barang+"'";
            java.sql.ResultSet res= this.exec(sql);
            while(res.next()){
                idBarang = Integer.parseInt(res.getString("id_brg"));
            }
        } catch (Exception e) {
            idBarang = 0;
        }
        return idBarang;
    }
// ------------------------------------------------------------------------------------------------------------------   
// function to create request table
    public int showRequest(JTable table){
        String sql = "SELECT data_barang.nama_brg,data_barang.jumlah_brg,"
                   + "data_user.nama_user,"
                   + "transaksi.banyak_pinjaman,transaksi.keperluan_pinjaman,"
                   + "transaksi.tanggal_pinjaman,transaksi.id_transaksi,transaksi.status_pinjaman,transaksi.tanggal_kembali\n" +
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
    
// ------------------------------------------------------------------------------------------------------------
    public String[] showUser(int id){
        String[] result = new String[10];
        String sql = "SELECT * FROM data_user WHERE id_user="+"'"+id+"'";
        try{
            
            java.sql.ResultSet hasil = this.exec(sql);
            while( hasil.next()){
                result[1] = hasil.getString(2);
                result[2] = hasil.getString(4);
                result[3] = hasil.getString(5);
                result[4] = hasil.getString(3);
                result[5] = hasil.getString(9);
                result[6] = hasil.getString(8);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return result;
    }
// ------------------------------------------------------------------------------------------------------------------    
    public int getTotalUser(){
        int result = 1;
        try{
            String sql = "SELECT * FROM data_user";
            while(this.exec(sql).next()){
                ++result;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            result = 0;
        }
        return result;
    }
// ------------------------------------------------------------------------------------------------------------------
}
