package sample;

public class Question {
    int NumQst;
    String ContenuQst;
    int BaremeQst;
    int TestQst;
    int CoursQst;

    public int getNumQst() {
        return NumQst;
    }

    public Question() {
    }

    public void setNumQst(int numQst) {
        NumQst = numQst;
    }

    public String getContenuQst() {
        return ContenuQst;
    }

    public void setContenuQst(String contenuQst) {
        ContenuQst = contenuQst;
    }

    public int getBaremeQst() {
        return BaremeQst;
    }

    public void setBaremeQst(int baremeQst) {
        BaremeQst = baremeQst;
    }

    public int getTestQst() {
        return TestQst;
    }

    public void setTestQst(int testQst) {
        TestQst = testQst;
    }

    public int getCoursQst() {
        return CoursQst;
    }

    public void setCoursQst(int coursQst) {
        CoursQst = coursQst;
    }

    public Question(int numQst, String contenuQst, int baremeQst, int testQst, int coursTest) {
        NumQst = numQst;
        ContenuQst = contenuQst;
        BaremeQst = baremeQst;
        TestQst = testQst;
        CoursQst = coursTest;
    }
}
