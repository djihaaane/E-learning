package sample;
import javafx.scene.control.ComboBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDao {


    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/scolaritedatabase";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "Djihane_9";
    private static final String SELECT_QUERY1 = "SELECT * FROM `scolaritedatabase`.`ADMINISTRATEUR` WHERE email = ? and password = ?";
    private static final String SELECT_QUERY2 = "SELECT * FROM INSTRUCTEUR WHERE email = ? and passwordi = ?";
    private static final String SELECT_QUERY3 = "SELECT * FROM APPRENANT WHERE email = ? and passworda = ?";
    private static final String INSERT_QUERY= "INSERT INTO `scolaritedatabase`.`ADMINISTRATEUR` ( `email`, `nom`, `prenom`, `password`, `langue`,  `sexe`) VALUES ( ?, ?, ?, ?, ?, ?);";
    private static final String INSERT_QUERY0= "INSERT INTO `scolaritedatabase`.`INSTRUCTEUR` ( `email`, `nom`, `prenom`, `passwordi`, `langue`,  `sexe`) VALUES ( ?, ?, ?, ?, ?, ?);";
    private static final String INSERT_QUERY00= "INSERT INTO `scolaritedatabase`.`APPRENANT` ( `email`, `nom`, `prenom`, `passworda`, `langue`,  `sexe`) VALUES ( ?, ?, ?, ?, ?, ?);";

    public void insertRecord(String nom, String prenom, String email, String password, String sexe, String langue, String role) throws SQLException {



        if(role.equals("Apprenant"))
        { try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY00)) {
            preparedStatement.setString(2, nom);
            preparedStatement.setString(3, prenom);
            preparedStatement.setString(1, email);
            preparedStatement.setString(4, password);
            preparedStatement.setString(6, sexe);
            preparedStatement.setString(5, langue);



            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            printSQLException(e);
        }}
        if(role.equals("Instructeur"))
        {
            try (Connection connection = DriverManager
                    .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY0)) {
                preparedStatement.setString(2, nom);
                preparedStatement.setString(3, prenom);
                preparedStatement.setString(1, email);
                preparedStatement.setString(4, password);
                preparedStatement.setString(6, sexe);
                preparedStatement.setString(5, langue);



                System.out.println(preparedStatement);
                preparedStatement.execute();
            } catch (SQLException e) {
                printSQLException(e);

        }
        }
    }

    public  Utilisateur validate(String email, String password) throws SQLException {


        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY1)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            System.out.println(preparedStatement);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DAO<Administrateur> admindao = new AdministrateurDAO(connection);
                Utilisateur admin = ((AdministrateurDAO) admindao).createAdmin(resultSet);
                return admin;
            } else {
                try(Connection connection2 = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

                    PreparedStatement preparedStatement2 = connection2.prepareStatement(SELECT_QUERY2)) {
                    preparedStatement2.setString(1, email);
                    preparedStatement2.setString(2, password);

                    System.out.println(preparedStatement2);

                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    if (resultSet2.next()) {

                        DAO<Instructeur> admindao = new InstructeurDAO(connection2);
                        Utilisateur admin = ((InstructeurDAO) admindao).createInstructeur(resultSet2);
                        return admin;}
                    else {
                        try(Connection connection3 = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
                            PreparedStatement preparedStatement3 = connection3.prepareStatement(SELECT_QUERY3)) {
                            preparedStatement3.setString(1, email);
                            preparedStatement3.setString(2, password);

                            System.out.println(preparedStatement3);

                            ResultSet resultSet3 = preparedStatement3.executeQuery();
                            if (resultSet3.next()) {
                                DAO<Apprenant> admindao = new ApprenantDAO(connection3);
                                Utilisateur admin = ((ApprenantDAO) admindao).createApprenant(resultSet3);

                                return admin;

                            }

                        }catch (SQLException e) {
                            printSQLException(e);
                        }
                    }
                }catch (SQLException e) {
                    printSQLException(e);
                }
            }

        } catch (SQLException e) {
            printSQLException(e);
        }

        Utilisateur admin=null;
        return admin ;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


}