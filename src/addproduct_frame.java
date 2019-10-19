
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class addproduct_frame {
conn cn = new conn();
public int addproduct(String prname, int prqty, int prprice){
    int z = 0;
    String sql= "insert into product values (null,?,?,?)";
try{
        Class.forName(cn.driver);
        Connection con = DriverManager.getConnection(cn.url,cn.username,cn.password);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, prname);
        ps.setInt(2, prqty);
        ps.setInt(3, prprice);
        ps.executeUpdate();
        
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
    }return z;
}

public void deleteprod(int id){
    try{
        Class.forName(cn.driver);
        Connection con = DriverManager.getConnection(cn.url,cn.username,cn.password);
        PreparedStatement pstmt = con.prepareStatement("Delete from product where id =?");
        pstmt.setInt(1, id);
        pstmt.executeUpdate();
}   catch (ClassNotFoundException ex) {
        Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(addproduct_frame.class.getName()).log(Level.SEVERE, null, ex);
    }
}}
