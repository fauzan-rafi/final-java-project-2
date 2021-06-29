package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Config {
    private static Connection mysqlconfig;
    public static Connection configDB()throws SQLException{
        try {
            String url="jdbc:mysql://localhost:3306/final_java"; //url database
            String user="root"; //user database
            String pass=""; //password database
//            memanggil driver
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            koneksi database
            mysqlconfig=DriverManager.getConnection(url, user, pass); 
        } catch (Exception e) {
            System.err.println("koneksi gagal "+e.getMessage()); //perintah menampilkan error pada koneksi
        }
        return mysqlconfig;
    }    
    
    public static void main(String[] args) throws SQLException {
        configDB();
        
    }
}
