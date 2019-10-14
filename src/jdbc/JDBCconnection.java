/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinh
 */
public class JDBCconnection {

    public static Connection getJDBCconnnection() {
        String url = "jdbc:jtds:sqlserver://localhost:1433/JDBC";
        try {
            java.lang.Class.forName("net.sourceforge.jtds.jdbc.Driver");
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCconnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCconnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        if (JDBCconnection.getJDBCconnnection() == null) {
            System.out.println("error");
        } else {
            System.out.println("success");
        }

    }
}
