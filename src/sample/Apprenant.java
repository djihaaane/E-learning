package sample;

import com.mysql.jdbc.Blob;

import java.sql.Date;

public class Apprenant extends Utilisateur {
    String niveau;
    int nbrCoursFaits;
    int nbrCoursSuivis;

    public Apprenant(){
        super();
    };

    public Apprenant(int idf, String nom, String prenom, String email, Date dateN, String passwordAd, Blob img, String niveau, int nbrCoursFaits, int nbrCoursSuivis) {
        super(idf, nom, prenom, email, dateN, passwordAd, img);
        this.niveau = niveau;
        this.nbrCoursFaits = nbrCoursFaits;
        this.nbrCoursSuivis = nbrCoursSuivis;
    }

    public Apprenant(String niveau, int nbrCoursFaits, int nbrCoursSuivis) {
        this.niveau = niveau;
        this.nbrCoursFaits = nbrCoursFaits;
        this.nbrCoursSuivis = nbrCoursSuivis;
    }

    public String getNiveau() {
        return niveau;
    }

    public int getNbrCoursFaits() {
        return nbrCoursFaits;
    }

    public int getNbrCoursSuivis() {
        return nbrCoursSuivis;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setNbrCoursFaits(int nbrCoursFaits) {
        this.nbrCoursFaits = nbrCoursFaits;
    }

    public void setNbrCoursSuivis(int nbrCoursSuivis) {
        this.nbrCoursSuivis = nbrCoursSuivis;
    }

}
