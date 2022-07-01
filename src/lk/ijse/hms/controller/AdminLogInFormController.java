package lk.ijse.hms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminLogInFormController {
    public AnchorPane contextAdminLogin;
    public TextField txtUserName;
    public TextField txtPassword;

    public void btnAdminLogInOnAction(ActionEvent actionEvent) throws IOException {
       /* if(txtUserName.getText().equals("admin") & txtPassword.getText().equals("12345")){
            Stage stage = (Stage) contextAdminLogin.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManageUserForm.fxml"))));
        }*/

        Stage stage = (Stage) contextAdminLogin.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManageUserForm.fxml"))));
    }
}
