/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author Win
 */
public class User {
    private String account, password, name, dob, gender, address;

    public User() {
    }
    
    public User(String account, String password) {
        this.account = account;
        this.password = password;
        connect();
    }

    public User(String account, String password, String name, String dob, String gender, String address) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        connect();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" + "account=" + account + ", password=" + password + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", address=" + address + '}';
    }

    
    
    Connection cnn; //ket noi db
    Statement stm; //thuc thi sql
    PreparedStatement pstm;
    ResultSet rs; //luu tru xi li dl
    
    public boolean checkUser() {
        //neu account = admin
        //pass 123 
//        if ("admin".equals(account) && "123".equals(password)) {
//            return true;
//        } else {
//            return false;
//        }
/*
        try {
            String strSelect = "select * from Users "
                    + "where account = '" + account + "' and password='" + password + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return false;
    }

    private void connect() {

        try {
            cnn = new DBContext().connection;
            if (cnn != null) {
                System.out.println("Connect success");
            }
        } catch (Exception e) {

        }
*/
     
    try {
            String strSelect = "select * from Users "
                    + "where account =? and "
                    + "password=?";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs=pstm.executeQuery(); 
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return false;
    }

    private void connect() {

        try {
            cnn = new DBContext().connection;
            if (cnn != null) {
                System.out.println("Connect success");
            }
        } catch (Exception e) {

        }

    }

    public String getNameByAccount(String account) {
        try {
            String strSelect = "select * from Users "
                    + "where account='" + account + "'  ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String name = rs.getString(3);
                return name;
            }
        } catch (Exception e) {
            System.out.println("getNameByAccount: " + e.getMessage());
        }
        return "";
    }

    public ArrayList<User> getListUser() {
        ArrayList<User> data = new ArrayList<>();
        try {
            String strSelect = "select * from Users ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String account = rs.getString(1);
                String password = rs.getString(2);
                String name = rs.getString(3);
                String gender = "Femal";
                if(rs.getBoolean(4)){
                    gender="Male";
                }
                String address = rs.getString(5);
                String dob="";
                SimpleDateFormat f=new SimpleDateFormat("dd-MM-yyyy");
                if(rs.getDate(6)!=null){
                    //dob = rs.getDate(6).toString();
                    dob =f.format(rs.getDate(6));
                }
                User u = new User(account, password, name, dob, gender, address);
                data.add(u);
            }
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
        return data;
    }
    
 

    public static void main(String[] args) {
        User u = new User();
        ArrayList<User> data = u.getListUser();
        for (User o : data) {
            System.out.println(o);
        }

    }

    public void getUser(String account) {
        try {
            String strSelect = "select * from Users "
                    + "where account='" + account + "'  ";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                setAccount(rs.getString(1)) ;
                setPassword(rs.getString(2));
                setName(rs.getString(3));
                setGender(String.valueOf(rs.getBoolean(4)));
                setAddress(rs.getString(5));
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                if (rs.getDate(6) != null) {
                    setDob(f.format(rs.getDate(6)));
                }
            }
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
     
    }

}
