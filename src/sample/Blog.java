package sample;

public class Blog {
   private int NumBlog;
    private String NomBlog;
    private String descBlog;

    public Blog(int numBlog, String nomBlog, String descBlog) {
        NumBlog = numBlog;
        NomBlog = nomBlog;
        this.descBlog = descBlog;
    }

    public Blog(String nomBlog, String descBlog) {
        NomBlog = nomBlog;
        this.descBlog = descBlog;
    }

    public Blog(){};

    public int getNumBlog() {
        return NumBlog;
    }

    public String getNomBlog() {
        return NomBlog;
    }

    public String getDescBlog() {
        return descBlog;
    }

    public void setNumBlog(int numBlog) {
        NumBlog = numBlog;
    }

    public void setNomBlog(String nomBlog) {
        NomBlog = nomBlog;
    }

    public void setDescBlog(String descBlog) {
        this.descBlog = descBlog;
    }

    @Override
    public String toString() {
        return  NumBlog +
                "              " + NomBlog ;
    }
}
