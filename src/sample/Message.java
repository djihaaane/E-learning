package sample;

public class Message {
    int NumMess;
    String NomEx;
    String NomDis;
    String contenuM;

    public String getContenuM() {
        return contenuM;
    }

    public void setContenuM(String contenuM) {
        this.contenuM = contenuM;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return  NomEx +'\n' +
                 contenuM + '\n';
    }

    public Message(String nomEx, String nomDis, String contenuM) {
        NomEx = nomEx;
        NomDis = nomDis;
        this.contenuM = contenuM;
    }

    public int getNumMess() {
        return NumMess;
    }

    public void setNumMess(int numMess) {
        NumMess = numMess;
    }

    public String getNomEx() {
        return NomEx;
    }

    public void setNomEx(String nomEx) {
        NomEx = nomEx;
    }

    public String getNomDis() {
        return NomDis;
    }

    public void setNomDis(String nomDis) {
        NomDis = nomDis;
    }
}






