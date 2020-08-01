package sample;

import java.sql.*;
import java.util.ArrayList;

public class BlogDAO extends DAO<Blog> {

    public BlogDAO(Connection conn) {
        super(conn);
    }


    private Blog createBlog(ResultSet rs) {
        Blog b = new Blog();
        try {
            b.setNumBlog(rs.getInt("NumBlog"));
            b.setNomBlog(rs.getString("NomBlog"));
            b.setDescBlog(rs.getString("descBlog"));
        } catch (SQLException ex) {
        }
        return b;
    }


    @Override
    public boolean insert(Blog obj) {

        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO `scolaritedatabase`.`Blog` (`NomBlog`, `descBlog`) VALUES (?, ?)");
            statement.setString(1, obj.getNomBlog());
            statement.setString(2, obj.getDescBlog());
            statement.execute();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

     public ArrayList<Blog> getAllBlog() {

        String sql = "select * from `scolaritedatabase`.`Blog` ";
        ArrayList<Blog> list = new ArrayList<>();
        try {

            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Blog b = createBlog(rs);
                list.add(b);
            }
            rs.close();
            connect.close();
        } catch (SQLException ex) {
        }
        return list;
    }

    @Override
    public boolean delete(Blog obj) {
        return false;
    }

    @Override
    public boolean update(Blog obj) {
        return false;
    }




    }