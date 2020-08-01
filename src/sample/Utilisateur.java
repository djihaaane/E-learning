package sample;


import java.sql.Blob;
import java.sql.Date;
import java.util.Objects;

abstract class  Utilisateur  {
   private int idf;
    private String nom,prenom,email;
    private Date dateN;
    private String passwordAd;
    private Blob img;
    private  String langue;
    private String Sexe;

    public Utilisateur(String nom, String prenom, String email, String passwordAd, String langue, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwordAd = passwordAd;
        this.langue = langue;
        Sexe = sexe;
    }

    public Utilisateur(int idf, String nom, String prenom, String email, String passwordAd, String langue, String sexe) {
        this.idf = idf;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwordAd = passwordAd;
        this.langue = langue;
        Sexe = sexe;
    }

    public String getSexe() {
        return Sexe;
    }

    public void setSexe(String sexe) {
        Sexe = sexe;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Utilisateur(int idf, String nom, String prenom, String email, String passwordAd, String langue) {
        this.idf = idf;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwordAd = passwordAd;
        this.langue=langue;
    }

    public Utilisateur(int idf, String nom, String prenom, String email, Date dateN, String passwordAd, Blob img) {
        this.idf = idf;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateN = dateN;
        this.passwordAd = passwordAd;
        this.img = img;
    }

    public Utilisateur(){};

    public int getIdf() {
        return idf;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateN() {
        return dateN;
    }

    public String getPasswordAd() {
        return passwordAd;
    }

    public Blob getImg() {
        return img;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateN(Date dateN) {
        this.dateN = dateN;
    }

    public void setPasswordAd(String passwordAd) {
        this.passwordAd = passwordAd;
    }

    public void setImg(Blob img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return
                idf +
                "  " + nom + " " +
                " " + prenom
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return passwordAd == that.passwordAd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(passwordAd);
    }
}

