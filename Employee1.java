/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaltest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASUS
 */
public class Employee1 {
    
    MyConnection myConnection = new MyConnection();
    
    public boolean addEmployee(String code1, String initials,String firstName, String lastname,String address1,String address2, String dob, String status)
    {
        PreparedStatement st;
        ResultSet rs;
        String addQuery = "INSERT INTO `employee`(`code`, `initials`, `firstName`, `sirName`, `address1`, `address2`, `dob`, `status`) VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            st = myConnection.CreateConnection().prepareStatement(addQuery);
            
            st.setString(1, code1);
            st.setString(2, initials);
            st.setString(3, firstName);
            st.setString(4, lastname);
            st.setString(5, address1);
            st.setString(6, address2);
            st.setString(7, dob);
            st.setString(8, status);
            
            if(st.executeUpdate() > 0)
            {
                return true;
            } else {
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Employee1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean editEmployee(String code1, String initials,String firstName, String lastname,String address1,String address2, String dob, String status)
    {
        PreparedStatement st;
        String editQuery = "UPDATE `employee` SET `code`=?,`initials`=?,`firstName`=?,`sirName`=?,`address1`=?,`address2`=?,`dob`=?,`status`=?";
        
        try {
            st = myConnection.CreateConnection().prepareStatement(editQuery);
            
            st.setString(1, code1);
            st.setString(2, initials);
            st.setString(3, firstName);
            st.setString(4, lastname);
            st.setString(5, address1);
            st.setString(6, address2);
            st.setString(7, dob);
            st.setString(8, status);
            return (st.executeUpdate() > 0);
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(Employee1.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        
    }
    }
    
     public void fillClientJTable(JTable table)
    {
        PreparedStatement ps;
        ResultSet rs;
        String selectQuery = "SELECT * FROM `employee` ";
        
        try {
            ps = myConnection.CreateConnection().prepareStatement(selectQuery);
            
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
            
            Object[] row;
            
            while(rs.next())
            {
                row = new Object[6];
                
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                
                
                tableModel.addRow(row);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Employee1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
        
    
    
    
    

        
    
    
    
    

