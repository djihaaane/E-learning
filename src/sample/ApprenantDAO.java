package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

public class ApprenantDAO extends DAO<Apprenant> {

    public ApprenantDAO(Connection conn) {
        super(conn);
    }



    @Override
    public boolean insert(Apprenant obj) {
       /* try {
            ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("" );
            if(result.first())
                obj = new Apprenant(
                        id,
                        result.getString("elv_nom"),
                        result.getString("elv_prenom"
                        ));
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        return false;
    }

    @Override
    public boolean delete(Apprenant obj) {
        return false;
    }

    @Override
    public boolean update(Apprenant obj) {
        return false;
    }


    public boolean update2( Apprenant app,int idf ){
        try {
            PreparedStatement statement = this.connect.prepareStatement(" UPDATE `scolaritedatabase`.`APPRENANT` SET `nom` = ?, `prenom` = ?, `email` = ?, `passworda` = ?, `langue` = ? WHERE (`idfApp` = ?)");
            statement.setString(1,app.getNom());
            statement.setString(2, app.getPrenom());
            statement.setString(3,app.getEmail());
            statement.setString(4, app.getPasswordAd());
            statement.setString(5,app.getLangue());
            statement.setInt(6, idf);
            statement.execute();

            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    public boolean updateImage(Apprenant app, File image, int idf) throws FileNotFoundException, SQLException {


       FileInputStream inputStream = new FileInputStream(image);

        try {
        PreparedStatement statement = this.connect.prepareStatement(" UPDATE `scolaritedatabase`.`APPRENANT` SET `photoap` = ? WHERE (`idfApp` = ?)");
        statement.setBlob(1, inputStream);
        statement.setInt(2, idf);
        statement.execute();

            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Apprenant createApprenant(ResultSet rs) {
        Apprenant b = new Apprenant();
        try {
            b.setIdf(rs.getInt("idfApp"));
            b.setLangue(rs.getString("langue"));
            b.setImg(rs.getBlob("photoap"));
        } catch (SQLException ex) {
        }
        return b;
    }

    public ArrayList<Apprenant> getAllApprenant() {

        String sql = "select * from `scolaritedatabase`.`APPRENANT` ";
        ArrayList<Apprenant> list = new ArrayList<>();
        try {

            Statement stmt = connect.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Apprenant b = createApprenant(rs);
                list.add(b);
            }
            rs.close();
            connect.close();
        } catch (SQLException ex) {
        }
        return list;
    }
    public ArrayList<Apprenant> getApprenantNum(ArrayList<Integer> NumApprenant) {
        ArrayList<Apprenant> cc= new ArrayList<Apprenant>();
        Apprenant list ;

        for (int i = 0; i < NumApprenant.size(); i++) {
            try {
                PreparedStatement statement = this.connect.prepareStatement("select * from `scolaritedatabase`.`APPRENANT` WHERE `idfApp`= ? ");

                statement.setInt(1, NumApprenant.get(i).intValue());
                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    list = createApprenant(rs);
                    cc.add(list);
                    System.out.println(list.getIdf());
                }

            } catch(SQLException ex){
            }
        }
        return cc;

    }

}