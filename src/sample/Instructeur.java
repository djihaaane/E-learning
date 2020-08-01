package sample;

import java.sql.Blob;
import java.sql.Date;

public class Instructeur extends Utilisateur {
     String Professiom;

     public Instructeur(int idf, String nom, String prenom, String email, int passwordAd) {
          super();
     }

     public Instructeur() {
     }

     public Instructeur(int idf, String nom, String prenom, String email, Date dateN, String passwordAd, Blob img, String professiom) {
          super(idf, nom, prenom, email, dateN, passwordAd, img);
          Professiom = professiom;
     }

     public Instructeur(String professiom) {
          Professiom = professiom;
     }

     public Instructeur(int idf, String nom, String prenom, String email, Date dateN, String passwordAd, Blob img) {
          super(idf, nom, prenom, email, dateN, passwordAd, img);
     }

     public String getProfessiom() {
          return Professiom;
     }
}
