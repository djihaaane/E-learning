package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstructeurDAO extends DAO<Instructeur> {
    public InstructeurDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean insert(Instructeur obj) {
        return false;
    }

    @Override
    public boolean delete(Instructeur obj) {
        return false;
    }

    @Override
    public boolean update(Instructeur obj) {
        return false;
    }


    public Instructeur createInstructeur(ResultSet rs) {
        Instructeur b = new Instructeur();
        try {
            b.setIdf(rs.getInt("idfIn"));
            b.setLangue(rs.getString("langue"));
            b.setNom(rs.getString("nom"));
            b.setNom(rs.getString("penom"));
            b.setImg(rs.getBlob("photoi"));
        } catch (SQLException ex) {
        }
        return b;
    }
    public boolean update2( Instructeur app,int idf ){
        try {
            PreparedStatement statement = this.connect.prepareStatement(" UPDATE `scolaritedatabase`.`INSTRUCTEUR` SET `nom` = ?, `prenom` = ?, `email` = ?, `passwordi` = ?, `langue` = ? WHERE (`idfAppIn` = ?)");
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
    public boolean updateImage(Instructeur app, File image, int idf) throws FileNotFoundException, SQLException {


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

}
