package sample;

import java.sql.*;
import java.util.ArrayList;

public class TestDAO extends DAO<Test> {

    public TestDAO(Connection conn) {
        super(conn);
    }




    private Test createTest(ResultSet rs) {
        Test c = new Test();
        try {
            c.setNumTest(rs.getInt("NumTest"));
            c.setNomTest(rs.getString("NomTest"));
        } catch (SQLException ex) {
        }
        return c;
    }


    @Override
    public boolean insert(Test obj) {
        return false;
    }

    @Override
    public boolean delete(Test obj) {
        return false;
    }

    @Override
    public boolean update(Test obj) {
        return false;
    }

    public ArrayList<Test> getAllTest() {


        String sql = "select * from `scolaritedatabase`.`TEST` ";
        ArrayList<Test> list = new ArrayList<>();
        try {

            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Test c = createTest(rs);
                list.add(c);
            }
            rs.close();
            connect.close();
        } catch (SQLException ex) {
        }
        return list;
    }

    public ArrayList<Test> getAllTestCours(int CoursTest) {

        ArrayList<Test> list = new ArrayList<>();
        try {

            PreparedStatement statement = this.connect.prepareStatement("select * from `scolaritedatabase`.`TEST` WHERE CoursTest = ? ");

            statement.setInt(1, CoursTest);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Test m = createTest(rs);
               // System.out.println(m.NomTest);
                list.add(m);
            }
            rs.close();
            connect.close();
        } catch (SQLException ex) {
        }
        return list;
    }
}
