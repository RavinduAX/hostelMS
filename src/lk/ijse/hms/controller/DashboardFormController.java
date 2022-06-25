package lk.ijse.hms.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane contextDashboard;
    public AnchorPane contextSubAnchor;
    public Label lblTitle;
    public JFXButton btnRegistration;
    public JFXButton btnManageStudents;
    public JFXButton btnManageRooms;
    public JFXButton btnUserSettings;
    public JFXButton btnReservedDetails;

    public void initialize() throws IOException {
        lblTitle.setText("Manage Rooms");
        loadUI("../view/RoomManageForm.fxml");
        btnManageRooms.setStyle("-fx-background-color: #E84545;");
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) contextSubAnchor.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
    }

    public void btnRegistrationOnAction(ActionEvent actionEvent) throws IOException {
        lblTitle.setText("Registration");
        loadUI("../view/RegistrationForm.fxml");
        btnRegistration.setStyle("-fx-background-color: #E84545;");
        btnManageStudents.setStyle("-fx-background-color: #ffffff; ");
        btnManageRooms.setStyle("-fx-background-color: #ffffff; ");
        btnUserSettings.setStyle("-fx-background-color: #ffffff; ");
        btnReservedDetails.setStyle("-fx-background-color: #ffffff; ");
    }

    public void btnManageStudentOnAction(ActionEvent actionEvent) throws IOException {
        lblTitle.setText("Manage Students");
        loadUI("../view/StudentManageForm.fxml");
        btnManageStudents.setStyle("-fx-background-color: #E84545;");
        btnRegistration.setStyle("-fx-background-color: #ffffff; ");
        btnManageRooms.setStyle("-fx-background-color: #ffffff; ");
        btnUserSettings.setStyle("-fx-background-color: #ffffff; ");
        btnReservedDetails.setStyle("-fx-background-color: #ffffff; ");
    }

    public void btnManageRoomOnAction(ActionEvent actionEvent) throws IOException {
        lblTitle.setText("Manage Rooms");
        loadUI("../view/RoomManageForm.fxml");
        btnManageRooms.setStyle("-fx-background-color: #E84545;");
        btnRegistration.setStyle("-fx-background-color: #ffffff; ");
        btnManageStudents.setStyle("-fx-background-color: #ffffff; ");
        btnUserSettings.setStyle("-fx-background-color: #ffffff; ");
        btnReservedDetails.setStyle("-fx-background-color: #ffffff; ");
    }

    public void btnUserSettingsOnAction(ActionEvent actionEvent) throws IOException {
        lblTitle.setText("User Settings");
        loadUI("../view/UserManageForm.fxml");
        btnUserSettings.setStyle("-fx-background-color: #E84545;");
        btnRegistration.setStyle("-fx-background-color: #ffffff; ");
        btnManageStudents.setStyle("-fx-background-color: #ffffff; ");
        btnManageRooms.setStyle("-fx-background-color: #ffffff; ");
        btnReservedDetails.setStyle("-fx-background-color: #ffffff; ");
    }

    public void btnReservedDetailsOnAction(ActionEvent actionEvent) throws IOException {
        lblTitle.setText("Reserved Details");
        loadUI("../view/ReservedForm.fxml");
        btnReservedDetails.setStyle("-fx-background-color: #E84545;");
        btnRegistration.setStyle("-fx-background-color: #ffffff; ");
        btnManageStudents.setStyle("-fx-background-color: #ffffff; ");
        btnManageRooms.setStyle("-fx-background-color: #ffffff; ");
        btnUserSettings.setStyle("-fx-background-color: #ffffff; ");
    }

    private void loadUI(String location) throws IOException {
        contextSubAnchor.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource(location));
        contextSubAnchor.getChildren().add(parent);
    }

}
