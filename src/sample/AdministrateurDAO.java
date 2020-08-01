package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministrateurDAO extends DAO<Administrateur> {

    public AdministrateurDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean insert(Administrateur obj) {
        try {
            PreparedStatement statement = this.connect.prepareStatement(
                    "INSERT INTO `scolaritedatabase`.`ADMINISTRATEUR` ( `email`, `nom`, `prenom`, `password`, `langue`,  `sexe`) VALUES ( ?, ?, ?, ?, ?, ?)");
            statement.setString(2, obj.getNom());
            statement.setString(3, obj.getPrenom());
            statement.setString(1, obj.getEmail());
            statement.setString(4, obj.getPasswordAd());
            statement.setString(6, obj.getSexe());
            statement.setString(5, obj.getLangue());

            statement.execute();
            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean delete(Administrateur obj) {
        return false;
    }

    @Override
    public boolean update(Administrateur obj) {
        return false;
    }


    public Administrateur createAdmin(ResultSet rs) {
        Administrateur b = new Administrateur();
        try {
            b.setIdf(rs.getInt("idfA"));
            b.setLangue(rs.getString("langue"));
            b.setImg(rs.getBlob("photoad"));
        } catch (SQLException ex) {
        }
        return b;
    }

    public boolean update2( Administrateur app,int idf ){
        try {
            PreparedStatement statement = this.connect.prepareStatement(" UPDATE `scolaritedatabase`.`ADMINISTRATEUR` SET `nom` = ?, `prenom` = ?, `email` = ?, `password` = ?, `langue` = ? WHERE (`idfA` = ?)");
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
    public boolean updateImage(Administrateur app, File image, int idf) throws FileNotFoundException, SQLException {


        FileInputStream inputStream = new FileInputStream(image);

        try {
            PreparedStatement statement = this.connect.prepareStatement(" UPDATE `scolaritedatabase`.`ADMINISTRATEUR` SET `photoad` = ? WHERE (`idfA` = ?)");
            statement.setBlob(1, inputStream);
            statement.setInt(2, idf);
            statement.execute();

            return true;


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
