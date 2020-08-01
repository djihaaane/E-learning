package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QuestionDAO extends DAO {


    public QuestionDAO(Connection conn) {
        super(conn);
    }

    private Question createQst(ResultSet rs) {
        Question m = new Question();
        try {
            m.setContenuQst(rs.getString("ContenuQst"));
            m.setNumQst(rs.getInt("NumQst"));
            m.setTestQst(rs.getInt("TestQst"));
            m.setCoursQst(rs.getInt("CoursQst"));
        } catch (SQLException ex) {
        }
        return m;
    }
    @Override
    public boolean insert(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    public ArrayList<Question> getAllQuestionsTest(int TestQst,int CoursQst) {

        ArrayList<Question> list = new ArrayList<>();
        try {

            PreparedStatement statement = this.connect.prepareStatement("select * from `scolaritedatabase`.`QUESTION`  WHERE (`TestQst` = ?) and (`CoursQst` = ?);");

            statement.setInt(1, TestQst);
            statement.setInt(2, CoursQst);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Question m = createQst(rs);
                System.out.println(m.ContenuQst);
                list.add(m);
            }
            rs.close();
            connect.close();
        } catch (SQLException ex) {
        }
        return list;
    }
}
