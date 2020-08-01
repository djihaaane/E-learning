package sample;

public class Test {
    int NumTest;
    int coefTest;
    int NumCours;
    String NomTest;

    @Override
    public String toString() {
        return NumTest +
                  NomTest ;
    }

    public Test(int numTest, int coefTest, int numCours, String nomTest) {
        NumTest = numTest;
        this.coefTest = coefTest;
        NumCours = numCours;
        NomTest = nomTest;
    }

    public Test() {
    }

    public int getNumTest() {
        return NumTest;
    }

    public void setNumTest(int numTest) {
        NumTest = numTest;
    }

    public int getCoefTest() {
        return coefTest;
    }

    public void setCoefTest(int coefTest) {
        this.coefTest = coefTest;
    }

    public int getNumCours() {
        return NumCours;
    }

    public void setNumCours(int numCours) {
        NumCours = numCours;
    }

    public String getNomTest() {
        return NomTest;
    }

    public void setNomTest(String nomTest) {
        NomTest = nomTest;
    }
}
