package sample;

import java.sql.*;
import java.util.ArrayList;

public class MessageDAO extends DAO<Message> {
    public MessageDAO(Connection conn) {
        super(conn);
    }

    private Message createMessage(ResultSet rs) {
        Message m = new Message();
        try {
            m.setNomEx(rs.getString("NomEx"));
            m.setNomDis(rs.getString("NomDis"));
            m.setContenuM(rs.getString("ContenuM"));
        } catch (SQLException ex) {
        }
        return m;
    }

    @Override
    public boolean insert(Message obj) {

        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO `scolaritedatabase`.`MESSAGE` (`NomEx`, `ContenuM`,`NomDis`) VALUES (?,?,?)");
            statement.setString(1, obj.NomEx);
            statement.setString(2, obj.contenuM);
            statement.setString(3, obj.NomDis);
            statement.execute();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Message> getAllMessages(String nomDis) {

        ArrayList<Message> list = new ArrayList<>();
        try {

            PreparedStatement statement = this.connect.prepareStatement("select * from `scolaritedatabase`.`MESSAGE` WHERE NomDis= ? ");

            statement.setString(1, nomDis);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Message m = createMessage(rs);
                list.add(m);
            }
            rs.close();
            connect.close();
        } catch (SQLException ex) {
        }
        return list;
    }

    @Override
    public boolean delete(Message obj) {
        return false;
    }

    @Override
    public boolean update(Message obj) {
        return false;
    }
}
