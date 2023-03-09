/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Win
 */
public class DAO extends DBContext {

    public List<Student> getAllStudent() {
        List<Student> list = new ArrayList<>();
        String sql = "select * from Student";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student c = new Student(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public void insert(Student c) {
        String sql = "INSERT INTO [dbo].[Student]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[gender]\n"
                + "           ,[did])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, c.getId());
            st.setString(2, c.getName());
            st.setString(3, c.getGender());
            st.setString(4, c.getDid());

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
