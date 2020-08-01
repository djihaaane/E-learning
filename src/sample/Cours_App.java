package sample;

public class Cours_App  {
   int idfApp;
         int   NumCours;
   boolean ValiditeCours;
      int      Note;

    public Cours_App(int idfApp, int numCours) {
        this.idfApp = idfApp;
        NumCours = numCours;
    }

    public Cours_App() {
    }

    public Cours_App(int idfApp, int numCours, boolean validiteCours, int note) {
        this.idfApp = idfApp;
        NumCours = numCours;
        ValiditeCours = validiteCours;
        Note = note;
    }

    public int getIdfApp() {
        return idfApp;
    }

    public void setIdfApp(int idfApp) {
        this.idfApp = idfApp;
    }

    public int getNumCours() {
        return NumCours;
    }

    public void setNumCours(int numCours) {
        NumCours = numCours;
    }

    public boolean isValiditeCours() {
        return ValiditeCours;
    }

    public void setValiditeCours(boolean validiteCours) {
        ValiditeCours = validiteCours;
    }

    public int getNote() {
        return Note;
    }

    public void setNote(int note) {
        Note = note;
    }
}
