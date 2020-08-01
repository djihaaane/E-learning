package sample;
import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.Window;

import static javafx.collections.FXCollections.observableArrayList;

public class RegisterController{
    @FXML
    private JFXComboBox<String> AAI =new  JFXComboBox<>();
    @FXML
    private TextField prenom;

    @FXML
    private TextField matricule;

    @FXML
    private TextField nom;

    @FXML
    JFXComboBox<String> sexe =new  JFXComboBox<>();

    @FXML
    private TextField mail;
    @FXML
    private PasswordField password;

    @FXML
    private Button confirmer;

    @FXML
    private JFXComboBox<String> langue = new JFXComboBox<>();

    @FXML
    private Button annuler;
    @FXML
    private ComboBox role;

    @FXML
    private void SignupToLogin(ActionEvent event) throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("/sample/LOGIN.fxml"));

        Scene scene2 = new Scene(view2);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    @FXML
    public void register(ActionEvent event) throws SQLException {

        Window owner = confirmer.getScene().getWindow();

        System.out.println(nom.getText());
        System.out.println(mail.getText());
        System.out.println(password.getText());
        if (nom.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your name");
            return;
        }

        if (mail.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your email id");
            return;
        }
        if (password.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }


        JdbcDao jdbcDao = new JdbcDao();
        jdbcDao.insertRecord(nom.getText(), prenom.getText(), mail.getText(), password.getText(), sexe.getValue(), langue.getValue(), AAI.getValue());

        showAlert(Alert.AlertType.CONFIRMATION, owner, "Registration Successful!",
                "Welcome " + prenom.getText());
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
    @FXML
    void combolanrc(ActionEvent event) {
        ObservableList<String> list = FXCollections.observableArrayList("Anglais","Francais");
        langue.setItems(observableArrayList(list));

    }


    public void AAICombo(ActionEvent event) {
        ObservableList<String> list = FXCollections.observableArrayList("Apprenant","Instructeur");
        AAI.setItems(observableArrayList(list));
    }

    public void sexeCombo(ActionEvent event) {
        ObservableList<String> list = FXCollections.observableArrayList("FEMME","HOMME","NE PAS DIRE");
        sexe.setItems(observableArrayList(list));
    }
}
