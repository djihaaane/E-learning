package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Cours_AppDAO extends DAO<Cours_App> {

    public Cours_AppDAO(Connection conn) {
        super(conn);
    }
    private Cours_App createCours_App(ResultSet rs) {
        Cours_App m = new Cours_App();
        try {
            m.setIdfApp(rs.getInt("idfApp"));
            m.setNumCours(rs.getInt("NumCours"));
        } catch (SQLException ex) {
        }
        return m;
    }
    @Override
    public boolean insert(Cours_App obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO `scolaritedatabase`.`APPRENANT_COURS` (`idfApp`, `NumCours`) VALUES (?, ?)");
            statement.setInt(1, obj.getIdfApp());
            statement.setInt(2,obj.getNumCours());
            statement.execute();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public ArrayList<Integer> getAllCours_App(int idfApp) {

        ArrayList<Cours_App> list = new ArrayList<>();
        ArrayList<Integer> listInt= new ArrayList<Integer>();
        try {

            PreparedStatement statement = this.connect.prepareStatement("select * from `scolaritedatabase`.`APPRENANT_COURS` WHERE `idfApp` = ? ");

            statement.setInt(1, idfApp);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cours_App m = createCours_App(rs);
                list.add(m);
                listInt.add(m.getNumCours());
            }
            rs.close();
            connect.close();
        } catch (SQLException ex) {
        }
        return listInt;
    }
    public ArrayList<Integer> getAllApp_Cours(int NumCours) {

        ArrayList<Cours_App> list = new ArrayList<>();
        ArrayList<Integer> listInt= new ArrayList<Integer>();
        try {

            PreparedStatement statement = this.connect.prepareStatement("select * from `scolaritedatabase`.`APPRENANT_COURS` WHERE `NumCOurs` = ? ");

            statement.setInt(1, NumCours);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cours_App m = createCours_App(rs);
                list.add(m);
                listInt.add(m.getIdfApp());
            }
            rs.close();
            connect.close();
        } catch (SQLException ex) {
        }
        return listInt;
    }

    @Override
    public boolean delete(Cours_App obj) {
        return false;
    }

    @Override
    public boolean update(Cours_App obj) {
        return false;
    }

}
