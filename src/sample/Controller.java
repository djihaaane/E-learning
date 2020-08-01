package sample;
import com.jfoenix.controls.*;
import javafx.beans.property.ObjectProperty;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.lang.Class;
import java.awt.image.BufferedImage;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Window;
import sun.awt.shell.ShellFolder;

import javax.imageio.ImageIO;
import javax.swing.*;

import static com.sun.jmx.mbeanserver.Util.cast;
import static javafx.collections.FXCollections.observableArrayList;

public class Controller {
    public TextField prenom;
    public PasswordField password;
    String NomUtilisateur="djihane";
      Instructeur s =new Instructeur(1, "mezhod", "ramy", "dd", 23);
    public static   String imagePath;
    public static   String langueUti;
   public static    int idfUti;
   public static  String NomPrenom ;
   public static Utilisateur u;
   public static  int NumCSel;
   public static  int NumTest;
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      @FXML
      private Button gsondage;

    @FXML
    private Button gblog;

    @FXML
    private Button gwiki;

    @FXML
    private Button gsystem;

    @FXML
    private Button ajt;

    @FXML
    private Button supp;

    @FXML
    private TextField nom;

    @FXML
    private TextField mail;

    @FXML
    private Button gcompte;
    private MouseEvent event;
    private JFXComboBox<String> sexe= new JFXComboBox();

    @FXML
    void AdminToBlog(ActionEvent event) {

    }

    @FXML
    void AdminToReg(ActionEvent event) {

    }

    @FXML
    void AdminToSondage(ActionEvent event) {

    }


    ///////////////////////////////////////////////////////////////
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnSignup;
    @FXML
    private Button btnSignin;

    @FXML
    private TextField txtUsername;
    @FXML
    private void ToSignup(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("SignUp.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToAdminZone(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("AdminZone.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    private void ToAdminZoneENG(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("AdminZoneENG.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToProfZone(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("ProfZone.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToProfZoneENG(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("ProfZoneENG.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToEtudiantZone(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("EtudiantZone.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToEtudiantZoneENG(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("EtudiantZoneENG.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    public Utilisateur login(ActionEvent event) throws SQLException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        Window owner = btnSignin.getScene().getWindow();

        if (txtUsername.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            return null;
        }
        if (txtPassword.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return null;
        }

        String email = txtUsername.getText();
        String password = txtPassword.getText();

        JdbcDao jdbcDao = new JdbcDao();
        Utilisateur flag = jdbcDao.validate(email, password);
        String f="Francais";
        if(flag==null)
        { infoBox("Please enter correct Email and Password", null, "Failed");
            return null;}
          Class cl= flag.getClass();
        if (cl.getName()=="sample.Apprenant") {

           langueUti=flag.getLangue();
            idfUti=flag.getIdf();

            if( langueUti.equals(f))
            {
                ToEtudiantZone(event);
                return flag;
            }
            else
            {
                ToEtudiantZoneENG(event);
                return flag;
            }

        }
            if (cl.getName()=="sample.Administrateur") {
                langueUti = flag.getLangue();
                idfUti = flag.getIdf();

                System.out.println(langueUti + "          " + idfUti);
                if (langueUti.equals(f))
                {   ToAdminZone(event);      return flag;}
                else
                {
                                ToAdminZoneENG(event);
                                return flag;
                }

            }
             if(cl.getName()=="sample.Instructeur"){

                    langueUti=flag.getLangue();

                            idfUti=flag.getIdf();
                 if(langueUti.equals(f))
                 {       NomPrenom=flag.getNom()+flag.getPrenom();
                ToProfZone(event);
                 return flag;}
                 else
                 {
                     ToProfZoneENG(event);    return flag;}
            }
                             return null;

    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }




























    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //////////////// DECLARATION POUR REGLAGE COMPTE////////////////
    @FXML
    private TextField prenomrc;

    @FXML
    private TextField nomrc;
    @FXML
    private JFXComboBox<String> lanrc = new JFXComboBox<String>();

    @FXML
    private ImageView photochanrc = new ImageView()   ;

    @FXML
    private TextField mailrc;

    @FXML
    private PasswordField mdprc;

    @FXML
    private JFXComboBox<String> horrc = new JFXComboBox();
    @FXML
    private Button btnannulerrc;


    @FXML
    void Nomrc(ActionEvent event) {

    }

    @FXML
    void annulerrc(ActionEvent event) {
        Stage stage = (Stage) btnannulerrc.getScene().getWindow();
        stage.close();

    }

    @FXML
    void chanphorc(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        BufferedImage bufferedImage = ImageIO.read(selectedFile);
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        imagePath=selectedFile.getPath();
        System.out.println(imagePath);

              new FileChooser.ExtensionFilter("JPG", "*.jpg");
         if(selectedFile!= null)
        {
             photochanrc.setImage(image);

        }
        else
        {
            System.out.println("file non trouve");
        }

    }

    @FXML
    void combolanrc(ActionEvent event) {
        ObservableList<String> list = FXCollections.observableArrayList("Anglais","Francais");
        lanrc.setItems(observableArrayList(list));


    }

    @FXML
    void fuhorc(ActionEvent event) {

        ObservableList<String> list = FXCollections.observableArrayList("123","212");
        horrc.setItems(observableArrayList(list));

    }

    @FXML
    void modifierrc(ActionEvent event) throws IOException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");


        DAO<Apprenant> appModif = new ApprenantDAO(conn);
        Apprenant app = new Apprenant();

        File selectedFile = new File(imagePath);

         ((ApprenantDAO) appModif).updateImage(app,selectedFile,1);


    }
//////////////////////////////////Bloooooooooooooooog////////////////////////////////////////////////////////////

    @FXML
    private TextField NBlog;

    @FXML
    private Button btnBlogCreer;

    @FXML
    private TextArea desBlog;

    @FXML
    private JFXListView<String> listBlog = new JFXListView<>();

    @FXML
    private Button btnBlogCon;

    @FXML
    void ConsulterBlog(ActionEvent event) {
        listBlog.getItems().clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");


        ArrayList<Blog> Blogs =new BlogDAO(conn).getAllBlog() ;
         for (Blog i: Blogs)
         {
             listBlog.getItems().add(i.toString());
         }

    }


    @FXML
    void selectedBlog(MouseEvent event) {
        System.out.println("clicked on " + listBlog.getSelectionModel().getSelectedItem());
        try {

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");

        ArrayList<Blog> Blogs =new BlogDAO(conn).getAllBlog() ;

        String blogSel =listBlog.getSelectionModel().getSelectedItem();
         int index = Integer.parseInt(String.valueOf(blogSel.charAt(0)));
         System.out.print(index);
        NBlog.setText(Blogs.get(index-1).getNomBlog());
        desBlog.setText(Blogs.get(index-1).getDescBlog());
    }
    @FXML
    void inserBlog(ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        DAO<Blog> blogdao = new BlogDAO(conn);
        Blog blog = new Blog(NBlog.getText(),desBlog.getText());
        blogdao.insert(blog);



    }










    /////////////////////////////////////MESSAGEEEEEEEEEEEEEEEEEEEEEEEEEEEEE//////////////
    @FXML
    private TextField NomDist;

    @FXML
    private Button btnEnvoyer;

    @FXML
    private TextArea messageEnv;

    @FXML
    private TextField nomF;

    @FXML
    private Button btnPar;

    @FXML
    private JFXListView<String> listMRecu = new JFXListView<>();


    @FXML
    void Envoyer(ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        DAO<Message> Messdao = new MessageDAO(conn);
        Message mess = new Message(NomUtilisateur,NomDist.getText(),messageEnv.getText());
        Messdao.insert(mess);

    }
    @FXML
    void consulterMRecus(ActionEvent event) {

        listMRecu.getItems().clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");

        ArrayList<Message> messages =new MessageDAO(conn).getAllMessages(NomUtilisateur) ;
        for (Message i: messages)
        {
            listMRecu.getItems().add(i.toString());
        }


    }
    @FXML
    void Participer(ActionEvent event) {

    }







    ///////////////////////////////////////////CCCCCOOUUUUUUUUUUUUUURRRSSSS////////////////////////////////////
           ///////////////////////////////////////////////////COURSSSSSSSSSS PROOOOOOOOOOOOOOOOOOF

    @FXML
    private JFXListView<String> listCoursProfApprenant;
    @FXML
    private JFXListView<String> listProfCours;


    @FXML
    private JFXListView<?> AreaProfCours;

    @FXML
    private JFXTextArea CoursProfArea;


    @FXML
    void AfficherApprenant(ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        Connection conn2 = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        try {
            conn2= DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");

        DAO<Cours_App> blogdao = new Cours_AppDAO(conn);
        DAO<Apprenant> blogdao2 = new ApprenantDAO(conn2);


        ArrayList<Integer> listNC=((Cours_AppDAO)blogdao).getAllCours_App(idfUti);

        ArrayList<Apprenant> c=((ApprenantDAO)blogdao2).getApprenantNum(listNC);

        for (Apprenant i : c) listCoursProfApprenant.getItems().add(i.toString());


    }



    @FXML
    void AjouterApprenant(ActionEvent event) {

    }

    @FXML
    void AjouterCours(ActionEvent event) throws IOException {
        String name="";
        System.out.println(NomPrenom);
        System.out.println(idfUti);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(null);
            File f1 = new File(open.getSelectedFile().getPath());
            FileReader fr = new FileReader(f1);
            BufferedReader br = new BufferedReader(fr);
             name  =f1.getName();
            String s;
            while((s=br.readLine())!=null)
            {
                CoursProfArea.appendText(s + "\n");
            }
            DAO<Cours> blogdao = new CoursDAO(conn);
            Cours blog = new Cours(name, CoursProfArea.getText(),idfUti);
            blogdao.insert(blog);
            fr.close();


    }

    @FXML
    void GestionBlogProf(ActionEvent event) {

    }

    @FXML
    void GestionComProf(ActionEvent event) {

    }

    @FXML
    void GestionSonProf(ActionEvent event) {

    }

    @FXML
    void GestionWikiProf(ActionEvent event) {

    }

    @FXML
    void ModifierCours(ActionEvent event) {

    }

    @FXML
    void ReglageCompteProf(ActionEvent event) {

    }

    @FXML
    void afficherCoursProf(ActionEvent event) {

        System.out.println("clicked on " + listProfCours.getSelectionModel().getSelectedItem());
        try {

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        System.out.println(NomPrenom);
        ArrayList<Cours> cours =new CoursDAO(conn).getAllCours() ;
        String blogSel =listProfCours.getSelectionModel().getSelectedItem();
        try {
            int index = Integer.parseInt(String.valueOf(blogSel.charAt(0)));
            System.out.print(index);
            CoursProfArea.setText(cours.get(index-1).ContenuCours);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void selectedCoursProf(MouseEvent event) {

        System.out.println("clicked on " + listProfCours.getSelectionModel().getSelectedItem());
        try {

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        System.out.println(NomPrenom);
        ArrayList<Cours> cours =new CoursDAO(conn).getAllCours() ;

        String blogSel =listProfCours.getSelectionModel().getSelectedItem();
        try {
            int index = Integer.parseInt(String.valueOf(blogSel.charAt(0)));

            System.out.print(index);
            CoursProfArea.setText(cours.get(index-1).ContenuCours);
        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public  void voirProfrCours(ActionEvent event) {
        listProfCours.getItems().clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        ArrayList<Cours> cours = new CoursDAO(conn).getAllProfCours(idfUti);
        for (Cours i : cours) {
            listProfCours.getItems().add(i.toString());
        }
    }




////////////////////////////////////////////////////////COURRRRRRRRRRRRRRRRRSSSSSSSS APPPPRENAAAAAAAAAAAAAAAAAAAAAAAAAAAAT

    @FXML
    private JFXListView<String> listCoursApprenant;
    @FXML
    private JFXListView<String> listTest;
    @FXML
    private Button btnVC;
    @FXML
    private Button passerT;

    @FXML
    private TextArea CoursArea;
    @FXML
    void AjouterCoursApp(ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        DAO<Cours_App> blogdao = new Cours_AppDAO(conn);
        Cours_App blog = new Cours_App(idfUti, NumCSel) ;
        blogdao.insert(blog);


    }
    @FXML
    void AfficherTest(ActionEvent event) {
        System.out.println(NumCSel);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        System.out.println( "\n"+NumCSel);
        ArrayList<Test> cours =new TestDAO(conn).getAllTestCours(NumCSel) ;
        for (Test i: cours)
        {

            listTest.getItems().add(i.toString());
        }
    }


    @FXML
    void voirCoursApprenant(ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        Connection conn2 = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        try {
            conn2= DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");

        DAO<Cours_App> blogdao = new Cours_AppDAO(conn);
        DAO<Cours> blogdao2 = new CoursDAO(conn2);


        ArrayList<Integer> listNC=((Cours_AppDAO)blogdao).getAllCours_App(idfUti);

         ArrayList<Cours> c=((CoursDAO)blogdao2).getCoursNum(listNC);

        for (Cours i : c) listCoursApprenant.getItems().add(i.toString());



    }

    @FXML
    private JFXListView<String> listCours= new JFXListView<>();
    @FXML
    void selectedCours(MouseEvent event) {
        System.out.println("clicked on " + listCours.getSelectionModel().getSelectedItem());
        try {

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        System.out.println(NomPrenom);
        ArrayList<Cours> cours =new CoursDAO(conn).getAllCours() ;

        String blogSel =listCours.getSelectionModel().getSelectedItem();
      try {
              int index = Integer.parseInt(String.valueOf(blogSel.charAt(0)));
          NumCSel=index;
          System.out.print(index);
          CoursArea.setText(cours.get(index-1).ContenuCours);
      }
      catch(NullPointerException e)
        {
            e.printStackTrace();
        }

    }

    @FXML
    void voirCours(ActionEvent event) {
        listCours.getItems().clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        ArrayList<Cours> cours =new CoursDAO(conn).getAllCours() ;
        for (Cours i: cours)
        {
            listCours.getItems().add(i.toString());
        }
     /*   FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if(selectedFile!= null)
        {
            listCours.getItems().add(selectedFile.getName());

        }
        else
        {
         System.out.println("file non trouve");
        }*/

    }



    @FXML
    void selectedTest(MouseEvent event) {
        System.out.println("clicked on " + listCours.getSelectionModel().getSelectedItem());
        try {

            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");

        ArrayList<Test> cours =new TestDAO(conn).getAllTestCours(NumCSel) ;

        String blogSel =listTest.getSelectionModel().getSelectedItem();
        try {
            int index = Integer.parseInt(String.valueOf(blogSel.charAt(0)));
            NumTest=index;
            System.out.print(index);

        }
        catch(NullPointerException e)
        {
            e.printStackTrace();
        }

    }

























    /////////////////////////////////////////////////////////////////TEEEEEESSSSSSSSSSSSSSSSSSSTTTTTTTTTTTTTTTTTTTT





    @FXML
    private TextField rps3;

    @FXML
    private TextField rps4;

    @FXML
    private RadioButton vrai1;

    @FXML
    private RadioButton faux1;

    @FXML
    private RadioButton vrai2;

    @FXML
    private RadioButton faux2;

    @FXML
    private Text qst1;

    @FXML
    private Text qst2;

    @FXML
    private Text qst3;

    @FXML
    private Text qst4;
    @FXML
    void CommencerTest(ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        DAO<Question> Messdao = new QuestionDAO(conn);
        ArrayList<Question> listQst= ((QuestionDAO)Messdao).getAllQuestionsTest(NumTest,NumCSel);
        qst1.setText(listQst.get(0).ContenuQst);
        qst2.setText(listQst.get(1).ContenuQst);
        qst3.setText(listQst.get(2).ContenuQst);
        qst4.setText(listQst.get(3).ContenuQst);

    }
    @FXML
    private Button btnCOnfirmer;
    @FXML
    void ConfirmerTest(ActionEvent event) {
        Window owner = btnCOnfirmer.getScene().getWindow();
        showAlert(Alert.AlertType.CONFIRMATION, owner, " YOU PASSED THE TEST!",
                " Score 15 ");

    }


    public void PasserTest(ActionEvent event) throws IOException {

        Parent view2 = FXMLLoader.load(getClass().getResource("Test.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }


    @FXML
    private void ToAdminSondage(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("AdminSondage.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToLogin(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("Login.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToMenuBlog(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("MenuBlog.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToMenuCommunication(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("MenuCommunication.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToProfEtudSondage(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("ProfEtudSondage.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToReglageCompte(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("ReglageCompte.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToTest(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("Test.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToAdminSondageENG(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("AdminSondageENG.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToMenuBlogENG(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("MenuBlogENG.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToMenuCommunicationENG(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("MenuCommunicationENG.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToProfEtudSondageENG(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("ProfEtudSondageENG.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    private void ToReglageCompteENG(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("ReglageCompteENG.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    @FXML
    private void ToTestENG(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("TestENG.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }

    public void supprimerAdmin(ActionEvent event) {
    }

    public void AjouterAdmin(ActionEvent event) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.print("connection");
        String url = "jdbc:mysql://localhost/scolaritedatabase?autoReconnect=true&useSSL=false";
        String user = "root";
        String passwd = "Djihane_9";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.print("driver");
        DAO<Administrateur> blogdao = new AdministrateurDAO(conn);
        Administrateur blog = new Administrateur(nom.getText(),prenom.getText(),mail.getText(),password.getText(),lanrc.getValue(),sexe.getValue());
        blogdao.insert(blog);

    }
    public void sexeCombo(ActionEvent event) {
        ObservableList<String> list = FXCollections.observableArrayList("FEMME","HOMME","NE PAS DIRE");
        sexe.setItems(observableArrayList(list));
    }

}
