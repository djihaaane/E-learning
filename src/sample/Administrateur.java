package sample;

import com.mysql.jdbc.Blob;

import java.sql.Date;

public class Administrateur  extends Utilisateur{
    public Administrateur( String nom, String prenom, String email, String passwordAd, String langue, String sexe) {
        super( nom, prenom, email, passwordAd, langue, sexe);
    }

    public Administrateur(int idf, String nom, String prenom, String email, Date dateN, String passwordAd, Blob img) {
        super(idf, nom, prenom, email, dateN, passwordAd, img);
    }

    public Administrateur() {
    }
}
