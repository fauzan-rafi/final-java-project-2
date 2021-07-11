/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class User extends DatabaseModel{
    // ------------------------------------------------------------------------------------------------------------
    @Override
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
}
