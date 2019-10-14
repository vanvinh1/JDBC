/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Class {
    //--------Câu a---------//
    public static void intsertStu(int id , String name, String age){
        String sql = "insert into Student (name,age) values (?,?)" ;
        Connection conn = JDBCconnection.getJDBCconnnection();
        try {
            PreparedStatement ptsm=conn.prepareStatement(sql);            
            ptsm.setString(1,name);
            ptsm.setString(2,age);
            ptsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------Câu b---------//
    public static void intsertClass(int id , String Classname){
        String sql = "insert into Student (id,Classname) values (?,?)" ;
        Connection conn = JDBCconnection.getJDBCconnnection();
        try {
            PreparedStatement ptsm=conn.prepareStatement(sql);            
            ptsm.setString(2,Classname);
            ptsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------Câu c---------//
    public static void regisClass(int Class_id ,int Student_id,String name , String age){
         String sql = "insert into Class_Student (name,age) values (?,?)" ;
         Connection conn = JDBCconnection.getJDBCconnnection();
        try {
            PreparedStatement ptsm=conn.prepareStatement(sql);
            ptsm.setString(1,name);
            ptsm.setString(2,age);
            ptsm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------Câu d---------//
    public static void regisDayOff(int id ,int Student_id,String name,int dayOff){
         String sql = "insert into DayOff (name,dayOff) values (?)" ;
         Connection conn = JDBCconnection.getJDBCconnnection();
        try {
            PreparedStatement ptsm=conn.prepareStatement(sql);
            ptsm.setString(1,name);
            ptsm.setInt(2,dayOff);
            ptsm.executeUpdate();
        }        
        catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();          
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //--------Câu e ---------//
     public static void searchStu(int Student_id ,String Student_name,int Student_age){
         String sql = "select id,name,age from Student where values (?,?,?)" ;
         Connection conn = JDBCconnection.getJDBCconnnection();
        try {
            PreparedStatement ptsm=conn.prepareStatement(sql);
            ptsm.setInt(1,Student_id);
            ptsm.setString(2,Student_name);
            ptsm.setInt(2,Student_age);
            ResultSet rs=ptsm.executeQuery();
            while(rs.next()){
                rs.getInt("Student_id");
                rs.getString("Student_name");
                rs.getInt("Student_age");
                rs.getString("Class_name");               
            }
            conn.close();
            ptsm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     //--------Câu f---------//
     public static void searchClass(int id ,String class_name,String amount){
         String sql = "select id,class_name,amount from Class  where class_name LIKE ?" ;
         Connection conn = JDBCconnection.getJDBCconnnection();
        try {
            PreparedStatement ptsm=conn.prepareStatement(sql);
            ptsm.setString(1,class_name);
            ResultSet rs=ptsm.executeQuery();
            while(rs.next()){
                rs.getInt("id");
                rs.getString("class_name");
                rs.getString("amount");
            }
            conn.close();
            ptsm.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        
    }
}
