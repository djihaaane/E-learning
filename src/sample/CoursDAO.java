package sample;

import java.sql.*;
import java.util.ArrayList;

public class CoursDAO extends DAO<Cours> {

    public CoursDAO(Connection conn) {
        super(conn);
    }



    private Cours createCours(ResultSet rs) {
         Cours c = new Cours();
        try {
            c.setNumCOurs(rs.getInt("NumCours"));
            c.setNomCours(rs.getString("NomCours"));
            c.setContenuCours(rs.getString("ContenuCours"));
        } catch (SQLException ex) {
        }
        return c;
    }

    public boolean insert(Cours obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO `scolaritedatabase`.`COURS` (`NomCours`, `ContenuCours`,`Redacteur`) VALUES (?, ?, ?)");
            statement.setString(1, obj.getNomCours());
            statement.setString(2, obj.getContenuCours());
            statement.setInt(3, obj.getRedacteur2());
             statement.execute();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

    }


    @Override
    public boolean delete(Cours obj) {
        return false;
    }

    @Override
    public boolean update(Cours obj) {
        return false;
    }

    public ArrayList<Cours> getAllCours() {


         String sql = "select * from `scolaritedatabase`.`COURS` ";
            ArrayList<Cours> list = new ArrayList<>();
            try {

                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Cours c = createCours(rs);
                    list.add(c);
                }
                rs.close();
                connect.close();
            } catch (SQLException ex) {
            }
            return list;
        }

    public ArrayList<Cours> getAllProfCours(int redacteur) {

        ArrayList<Cours> list = new ArrayList<>();
        try {

            PreparedStatement statement = this.connect.prepareStatement("select * from `scolaritedatabase`.`COURS` WHERE Redacteur= ? ");

            statement.setInt(1, redacteur);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Cours m = createCours(rs);
                list.add(m);
            }
            rs.close();
            connect.close();
        } catch (SQLException ex) {
        }
        return list;
    }
    public ArrayList<Cours> getCoursNum(ArrayList<Integer> NumCours) {
        ArrayList<Cours> cc= new ArrayList<Cours>();
        Cours list ;

            for (int i = 0; i < NumCours.size(); i++) {
                try {
            PreparedStatement statement = this.connect.prepareStatement("select * from `scolaritedatabase`.`COURS` WHERE `NumCours`= ? ");

                statement.setInt(1, NumCours.get(i).intValue());
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    list = createCours(rs);
                    cc.add(list);
                    System.out.println(list.getNumCOurs());
                }

            } catch(SQLException ex){
            }
        }
        return cc;

    }

    }
