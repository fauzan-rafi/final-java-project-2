/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class Model {
    Config config;
    
    public Model(){
        this.config = new Config();
    }
    
    // general method
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
            if ( pst.execute() )
                result = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            result = false;
        }
        return result;
    }
// ------------------------------------------------------------------------------------------------------------------
    public boolean deleteData(int id,String table,String param){
        boolean result = false;
        try{
            java.sql.Connection conn=(Connection)config.configDB();
            String sql = "DELETE FROM "+ table +" WHERE "+ param +" = ?";
            java.sql.PreparedStatement pst= conn.prepareStatement(sql);
            pst.setInt(1,id);
            if ( pst.execute() )
                result = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            result = false;
        }
        return result;
    }
// ------------------------------------------------------------------------------------------------------------------
    public boolean editData(int id,String table,String data,String param){
        boolean result = false;
        try{
            java.sql.Connection conn=(Connection)config.configDB();
            String sql = "UPDATE "+ table +" SET "+data+" WHERE "+ param +" = ?";
            java.sql.PreparedStatement pst= conn.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();
            result = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return result;
    }
// ------------------------------------------------------------------------------------------------------------------
    
}
