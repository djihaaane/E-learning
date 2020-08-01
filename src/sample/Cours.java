package sample;

public class Cours {
    int NumCOurs;
    String NomCours;
    String ContenuCours;
    String domaine;
    int duree;
    Instructeur redacteur;
    static int redacteur2;

    public static int getRedacteur2() {
        return redacteur2;
    }

    public static void setRedacteur2(int redacteur2) {
        Cours.redacteur2 = redacteur2;
    }

    public Cours(String nomCours, String contenuCours, int redacteur) {
        NomCours = nomCours;
        ContenuCours = contenuCours;
        this.redacteur2 = redacteur;
    }

    public Cours(int numCOurs, String NomCours, String contenuCours, String domaine, int duree, Instructeur redacteur) {
        NumCOurs = numCOurs;
        this.NomCours = NomCours;
        ContenuCours = contenuCours;
        this.domaine = domaine;
        this.duree = duree;
        this.redacteur = redacteur;
    }

    public Cours()
    { }
    public int getNumCOurs() {
        return NumCOurs;
    }

    public void setNumCOurs(int numCOurs) {
        NumCOurs = numCOurs;
    }

    public String getNomCours() {
        return NomCours;
    }

    public void setNomCours(String NomCours) {
        this.NomCours = NomCours;
    }

    public String getContenuCours() {
        return ContenuCours;
    }

    public void setContenuCours(String contenuCours) {
        ContenuCours = contenuCours;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Instructeur getRedacteur() {
        return redacteur;
    }

    @Override
    public String toString() {
        return  NumCOurs
                +"              " + NomCours
                ;
    }
}
