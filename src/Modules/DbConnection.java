/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Modules;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jojo
 */
public class DbConnection {
    private static String IP = "localhost:3306";
    private static String PORT = "3306";
    private static String SHORTIP = "localhost";
    private static String DB = "student_attendance";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";
    //private static boolean isAllSet = false;
    
    private static String CONN_STRING = "jdbc:mysql://" + IP + "/" + DB;
    
    private static Connection con = null;
    
    public DbConnection(){//constructor
    }
    
    public void setIP(String IpAdd){
        IP = IpAdd;
    }
    
    public void setSHORTIP(String ShortIpAdd){
        SHORTIP = ShortIpAdd;
    }
    
    public void setPORT(String PortAdd){
        PORT = PortAdd;
    }
    
    public void setDB(String Database){
        DB = Database;
    }
    
    public void setUID(String UID){
        USERNAME = UID;
    }
    
    public void setPWD(String PWD){
        PASSWORD = PWD;
    }
    
    public String getIP(){
        return IP;
    }
    
    public String getSHORTIP(){
        return SHORTIP;
    }
    
    public String getPORT(){
        return PORT;
    }
    
    public String getDB(){
        return DB;
    }
    
    public String getUID(){
        return USERNAME;
    }
    
    public String getPWD(){
        return PASSWORD;
    }
    
    public String getConString(){
        return CONN_STRING;
    }
    
    public void setConString(){
        CONN_STRING = "jdbc:mysql://" + IP + "/" + DB;
    }
    
    public boolean checkConnection(){       
        try{
        con = DriverManager.getConnection(CONN_STRING, USERNAME,PASSWORD);
            con.close();
            return true;
        }catch(SQLException ex){
            return false;
        }
    }
    
    public Connection getCon(){
        connect();
        return con;
    }
   
    public void connect(){

        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        try{
        con = DriverManager.getConnection(CONN_STRING, USERNAME,PASSWORD);
        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(null,ex);
            System.err.println(ex.toString());
        }

    }
    
    public void close_con(){
        //
    }
    
    public void insert_data(){
        connect();
        Statement st;
        try {
            st = (Statement) con.createStatement();
            String insert = "INSERT INTO 'class_scheduler.tbl_account'('instructor_id','username','password') VALUES('11','user1','pass1')";
            st.executeUpdate(insert);
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                System.err.println(ex.toString());
            }
        }
        close_con();
    }

    public void insertData(String table, String fields, String values){
        connect();
        try {
            String sqlCommand;
            Statement st;
            st = (Statement) con.createStatement();
            sqlCommand = "INSERT INTO " + table + "(" + fields + ") VALUES(" + values + ")";
            st.executeUpdate(sqlCommand);
            st.close();
            //con.close();
            JOptionPane.showMessageDialog(null, "Data has been saved.");
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                System.err.println(ex.toString());
            }
        }
        close_con();
    }
    
    public boolean insertDataDuplicateException(String table, String fields, String values){
        connect();
        try {
            String sqlCommand;
            Statement st;
            st = (Statement) con.createStatement();
            sqlCommand = "INSERT INTO " + table + "(" + fields + ") VALUES(" + values + ")";
            st.executeUpdate(sqlCommand);
            st.close();
            JOptionPane.showMessageDialog(null, "Data has been saved.");
            return true;
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                //JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                //System.err.println(ex.toString());
            }
            return false;
        }
    }
    
    public boolean insertDataDuplicateExceptionSilently(String table, String fields, String values){
        connect();
        try {
            String sqlCommand;
            Statement st;
            st = (Statement) con.createStatement();
            sqlCommand = "INSERT INTO " + table + "(" + fields + ") VALUES(" + values + ")";
            st.executeUpdate(sqlCommand);
            st.close();
            //JOptionPane.showMessageDialog(null, "Data has been saved.");
            return true;
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                //JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                //System.err.println(ex.toString());
            }
            System.out.println(ex);
            return false;
        }
    }
    
    public void insertDataSilently(String table, String fields, String values){
        connect();
        try {
            String sqlCommand;
            Statement st;
            st = (Statement) con.createStatement();
            sqlCommand = "INSERT INTO " + table + "(" + fields + ") VALUES(" + values + ")";
            st.executeUpdate(sqlCommand);
            st.close();
            //con.close();
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                System.err.println(ex.toString());
            }
        }
        close_con();
    }
       
    public void insertDataForAutomateClassSection(String table, String fields, String values){
        connect();
        try {
            String sqlCommand;
            Statement st;
            st = (Statement) con.createStatement();
            sqlCommand = "INSERT INTO " + table + "(" + fields + ") VALUES(" + values + ")";
            st.executeUpdate(sqlCommand);
            st.close();
            //con.close();
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                //JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                //System.err.println(ex.toString());
            }
        }
        close_con();
    }
    
    public void insertDualData(String table1,String fields1, String values1, String valuesLEC, String valuesLAB){
        connect();
        try {
            //insert to first table
            String sqlCommand;
            Statement st;
            st = (Statement) con.createStatement();
            sqlCommand = "INSERT INTO " + table1 + "(" + fields1 + ") VALUES(" + values1 + ")";
            st.executeUpdate(sqlCommand);
            st.close();
            //con.close();
            
            //get the primary key of the latest saved in the first table
            String latest_PKey = findLastPKey(table1);
            //String valuesLec = "'" + latest_PKey + "','LEC','" + valuesLEC + "'";
            String valuesLec = ("'" + latest_PKey + "',") + ("'LEC',") + valuesLEC;
            String valuesLab = ("'" + latest_PKey + "',") + ("'LAB',") + valuesLAB;
            //String valuesLab = "'" + latest_PKey + "','LAB','" + valuesLAB + "'";
            
            //insert to the second table
            String sqlCommand2;
            Statement st2;
            st2 = (Statement) con.createStatement();
            sqlCommand2 = "INSERT INTO tbl_subject_detail(subject_id,subject_type,numofhours) VALUES(" + valuesLec + ")";
            st2.executeUpdate(sqlCommand2);
            sqlCommand2 = "INSERT INTO tbl_subject_detail(subject_id,subject_type,numofhours) VALUES(" + valuesLab + ")";
            st2.executeUpdate(sqlCommand2);
            st2.close();
            //con.close();
            JOptionPane.showMessageDialog(null, "Data has been saved.");
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                System.err.println(ex.toString());
            }
        }
        close_con();
    }
    
    public void updateData(String table, String SETclause, String WHEREclause){
        connect();
        try {
            String sqlCommand;
            Statement st = con.createStatement();
            sqlCommand = "UPDATE " + table + " SET " + SETclause + " WHERE " + WHEREclause + "";
            //sqlCommand = "update tbl_account set instructor_id='2',username='Maam Vilma',password='pass',usertype='Chairperson' where id='3'";
            st.execute(sqlCommand);
            st.close();
            //con.close();
            JOptionPane.showMessageDialog(null, "Data has been updated.");
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                System.err.println(ex.toString());
            }
        }
        close_con();
    }
    
    public void updateDataSilently(String table, String SETclause, String WHEREclause){
        connect();
        try {
            String sqlCommand;
            Statement st = con.createStatement();
            sqlCommand = "UPDATE " + table + " SET " + SETclause + " WHERE " + WHEREclause + "";
            //sqlCommand = "update tbl_account set instructor_id='2',username='Maam Vilma',password='pass',usertype='Chairperson' where id='3'";
            st.execute(sqlCommand);
            st.close();
            //con.close();
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                System.err.println(ex.toString());
            }
        }
        close_con();
    }
    
    public boolean updateDataDuplicateException(String table, String SETclause, String WHEREclause){
        connect();
        try {
            String sqlCommand;
            Statement st = con.createStatement();
            sqlCommand = "UPDATE " + table + " SET " + SETclause + " WHERE " + WHEREclause + "";
            //sqlCommand = "update tbl_account set instructor_id='2',username='Maam Vilma',password='pass',usertype='Chairperson' where id='3'";
            st.execute(sqlCommand);
            st.close();
            JOptionPane.showMessageDialog(null, "Data has been updated.");
            return true;
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                //JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                System.err.println(ex.toString());
            }
            return false;
        }
    }
    
    public boolean updateDataDuplicateExceptionSilently(String table, String SETclause, String WHEREclause){
        connect();
        try {
            String sqlCommand;
            Statement st = con.createStatement();
            sqlCommand = "UPDATE " + table + " SET " + SETclause + " WHERE " + WHEREclause + "";
            //sqlCommand = "update tbl_account set instructor_id='2',username='Maam Vilma',password='pass',usertype='Chairperson' where id='3'";
            st.execute(sqlCommand);
            st.close();
            return true;
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                //JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                //System.err.println(ex.toString());
            }
            return false;
        }
    }
    
    public void updateDualData(String table, String SETclause, String WHEREclause){
        connect();
        try {
            String sqlCommand;
            Statement st = con.createStatement();
            sqlCommand = "UPDATE " + table + " SET " + SETclause + " WHERE " + WHEREclause + "";
            //sqlCommand = "update tbl_account set instructor_id='2',username='Maam Vilma',password='pass',usertype='Chairperson' where id='3'";
            st.execute(sqlCommand);
            st.close();
            //con.close();
            //JOptionPane.showMessageDialog(null, "Data has been updated.");
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1062){
                JOptionPane.showMessageDialog(null, "The system has encountered duplicate values, please re-check your data.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                System.err.println(ex.toString());
            }
        }
        close_con();
    }
    
    public void removeData(String table, String WHEREclause){
        connect();
        try {
            String sqlCommand;
            Statement st = con.createStatement();
            sqlCommand = "DELETE FROM " + table + " WHERE " + WHEREclause + "";
            st.execute(sqlCommand);
            st.close();
            //con.close();
            JOptionPane.showMessageDialog(null, "Data has been removed.");
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1451){//catch if parent row is deleted, because it is primary key
                JOptionPane.showMessageDialog(null, "Notice: You cannot remove this field, because it is used by other constraints.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                System.err.println(ex.toString());
            }
        }
        close_con();
    }
     
    public void removeDataSilently(String table, String WHEREclause){
        connect();
        try {
            String sqlCommand;
            Statement st = con.createStatement();
            sqlCommand = "DELETE FROM " + table + " WHERE " + WHEREclause + "";
            st.execute(sqlCommand);
            st.close();
            //con.close();
        } catch (SQLException ex) {
            if(ex.getErrorCode()==1451){ //catch if parent row is deleted, because it is primary key
                JOptionPane.showMessageDialog(null, "Notice: You cannot remove this field, because it is used by other constraints.");
            }else{
                //JOptionPane.showMessageDialog(null, ex);
                System.err.println(ex.toString());
            } 
        }
        close_con();
    }
    
    public int check_login(String username,String password){
        connect();
        int value=0;
        String uname="", pwd="";
        try {
            Statement st = (Statement) con.createStatement();
            String query = "SELECT username,password FROM class_scheduler.tbl_account WHERE username='" + username + "' and password = '" + password + "' ";
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                uname = rs.getString("username");
                pwd = rs.getString("password");
            }
            if(pwd.equals(password)){
                value=1;
                System.out.println(pwd);
            }else{
                value=0;System.out.println(pwd);
            }
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex);
            System.err.println(ex.toString());
        }
        close_con();
        return value; 
    }
    public int check_one_value(String condition){
        connect();
        int value=0;
        try {
            Statement st = (Statement) con.createStatement();
            String query = "SELECT username,password FROM class_scheduler.tbl_account WHERE " + condition;
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                value=1;
            }
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex);
            System.err.println(ex.toString());
        }
        close_con();
        return value;
    }
    
    public String findOneQuery(String field, String table, String WHEREClause){
        connect();
        String value="-1";
        try {
            Statement st = (Statement) con.createStatement();
            String query = "SELECT " + field + " FROM " + table + " WHERE " + WHEREClause + "";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                value=rs.getString(1);
            }
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,ex);
            System.err.println(ex.toString());
        }
        close_con();
        return value;
    }
    
    
    public int[] findArrayQuery(String field, String table, String WHEREClause){
        
        connect();
        int count=-1;
        try {
            Statement st = (Statement) con.createStatement();
            String query = "SELECT COUNT(" + field + ") FROM " + table + " WHERE " + WHEREClause + "";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                count=Integer.parseInt(rs.getString(1));
            }
            //con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.err.println(ex.toString());
        }
        close_con();
        
        int []IDs = new int[count];
        
            connect();
            int index=-1;
            try {
                Statement st = (Statement) con.createStatement();
                String query = "SELECT " + field + " FROM " + table + " WHERE " + WHEREClause + "";
                ResultSet rs = st.executeQuery(query);
                while(rs.next()){
                    index+=1;
                    IDs[index]=Integer.parseInt(rs.getString(1));
                }
                //con.close();
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null, ex);
                System.err.println(ex.toString());
            }
            close_con();
        return IDs;
    }
    
    public String justQuery(String query){
        connect();
        String value="-1";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                value=rs.getString(1);
            }
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex);
            System.err.println(ex.toString());
        }
        close_con();
        return value;
    }
    
    public String threadsConnected(){
        connect();
        String query = "show status where `variable_name` = 'Threads_connected'";
        String value="-1";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                value=rs.getString(2);
            }
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex);
            System.err.println(ex.toString());
        }
        close_con();
        return value;
    }
    
    public String findLastPKey(String table){
        connect();
        String value="-1";
        try {
            Statement st = (Statement) con.createStatement();
            String query = "SELECT id FROM " + table + " ORDER BY id";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                value=rs.getString(1);
            }
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex);
            System.err.println(ex.toString());
        }
        return value;
    }
    
    
    public void fillTable(JTable table, String Query){
        connect();
        try
        {
            con = DriverManager.getConnection(CONN_STRING, USERNAME,PASSWORD);

            //CreateConnection();
            com.mysql.jdbc.Statement stat;
            stat = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = stat.executeQuery(Query);

            //To remove previously added rows
            while(table.getRowCount() > 0) 
            {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while(rs.next())
            {  
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {  
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
            }

            rs.close();
            stat.close();
            //con.close();
        }
        catch(SQLException ex){
            //JOptionPane.showMessageDialog(null, ex);
            System.err.println(ex.toString());
            //System.out.println(CONN_STRING);
        }
        close_con();
    }
    
    public void fillSpecialTable(JTable table, String Query){
        connect();
        try
        {
            con = DriverManager.getConnection(CONN_STRING, USERNAME,PASSWORD);

            //CreateConnection();
            com.mysql.jdbc.Statement stat;
            stat = (com.mysql.jdbc.Statement) con.createStatement();
            ResultSet rs = stat.executeQuery(Query);

            //To remove previously added rows
            while(table.getRowCount() > 0) 
            {
                ((DefaultTableModel) table.getModel()).removeRow(0);
            }
            int columns = rs.getMetaData().getColumnCount();
            while(rs.next())
            {  
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++)
                {  
                    row[i-1] = rs.getObject(i);

                }
                row[0] = false;
  
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);
            }

            rs.close();
            stat.close();
            //con.close();
        }
        catch(SQLException ex){
            //JOptionPane.showMessageDialog(null, ex);
            System.err.println(ex.toString());
        }
        close_con();
    }
    
    public void fillListSingleCombo(JComboBox combo, String Query){
        connect();
        combo.removeAllItems();
        try {
            Statement st = (Statement) con.createStatement();
            //String query = "SELECT * FROM class_scheduler.tbl_account";
            ResultSet rs = st.executeQuery(Query);
            while(rs.next()){
                combo.addItem(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex);
            System.err.println(ex.toString());
        }
        close_con();
    }  

}
