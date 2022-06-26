package lk.ijse.hms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLogInFormController {
    public AnchorPane contextAdminLogin;

    public void btnAdminLogInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) contextAdminLogin.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManageUserForm.fxml"))));
    }
}
