/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class RegistroUsuarioDAO {
    public boolean validar(String userName, String password) throws Exception {
         boolean status=false;  
        System.out.println("jdbc connection");
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost/agencia", "root", "root");
 
        try {
 
            try {
                Statement st = con.createStatement();
                PreparedStatement ps=con.prepareStatement("select * from usuario where usuario=? and password=?");  
                ps.setString(1,userName);  
                ps.setString(2,password);  
                ResultSet rs=ps.executeQuery();  
                status=rs.next();
            } catch (SQLException ex) {
                System.out.println("SQL statement is not executed!" + ex);
            }
            con.close();
        } catch (Exception e) {
        }
        
        return status;
    }                

}

