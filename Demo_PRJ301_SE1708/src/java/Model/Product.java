/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Win
 */
public class Product {
    private String id, name, price, stock, image;

    public Product() {
        connect();
    }

    public Product(String id, String name, String price, String stock, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.image = image;
        connect();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", image=" + image + '}';
    }
    
    Connection cnn; //ket noi db
    PreparedStatement pstm;
    Statement stm; //thuc thi sql
    ResultSet rs; //luu tru xi li dl
    
    private void connect() {

        try {
            cnn = new DBContext().connection;
            if (cnn != null) {
                System.out.println("Connect success");
            }
        } catch (Exception e) {

        }
    }
   
    
    public ArrayList<Product> getListProduct(){
        ArrayList<Product> data = new ArrayList<Product>();
        try {
            String sql="select *from Products";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);
            while(rs.next()){
                String id=rs.getString(1);
                String name=rs.getString(2);
                String price=String.valueOf(rs.getDouble(3));
                String stock=rs.getString(4);
                String image=rs.getString(5);
                data.add(new Product(id, name, price, stock, image));
            }
        } catch (Exception e) {
            System.out.println("getListProduct: " + e.getMessage());
        }
        return data;
    }
    
    public void getProduct(String id){
        try {
            String strSelect = "select *from Products where ProductID=?";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, id);
            rs=pstm.executeQuery();
            while (rs.next()) {
                this.id=id;
                setName(rs.getString(2));
                setPrice(String.valueOf(rs.getDouble(3)));
                setStock(rs.getString(4));
                setImage(rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println("getProduct: " + e.getMessage());
        }
    }
    
    
    public void update() {
        try {
            String strSelect = "UPDATE [dbo].[Products]\n"
                    + "   SET [ProductName] = ?\n"
                    + "      ,[UnitPrice] = ?\n"
                    + "      ,[UnitsInStock] = ?\n"
                    + "      ,[Image] = ?\n"
                    + " WHERE [ProductID] = ?";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, name);
            pstm.setString(2, price);
            pstm.setString(3, stock);
            pstm.setString(4, image);
            pstm.setString(5, id);
            pstm.execute();
            
        } catch (Exception e) {
            System.out.println("Update: "+e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Product u = new Product();
        ArrayList<Product> data = u.getListProduct();
        for (Product o : data) {
            System.out.println(o);
        }
    }

    public Product getProductById(String id) {
        try {
            String strSelect = "select *from Products where ProductID=?";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, id);
            rs=pstm.executeQuery();
            while (rs.next()) {
                Product p= new Product(rs.getString("id"), rs.getString("name"), rs.getString("price"), 
                rs.getString("stock"), rs.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insert() {
        try {
            String strSelect = "INSERT INTO [dbo].[Products]\n"
                    + "           ([ProductName]\n"
                    + "           ,[UnitPrice]\n"
                    + "           ,[UnitsInStock]\n"
                    + "           ,[Image])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?)";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, name);
            pstm.setString(2, price);
            pstm.setString(3, stock);
            pstm.setString(4, image);
            pstm.execute();
            
        } catch (Exception e) {
            System.out.println("Insert: "+e.getMessage());
        }
    }

    public void delete(String id) {
        try {
            String strSelect = "DELETE FROM [dbo].[Products]\n" +
"      WHERE ProductID = ?";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1, id);
            pstm.execute();
            
        } catch (Exception e) {
            System.out.println("Delete: "+e.getMessage());
        }
    }
    
}
