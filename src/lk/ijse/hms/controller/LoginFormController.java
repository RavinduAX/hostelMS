package lk.ijse.hms.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.LoginBO;
import lk.ijse.hms.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginFormController {
    LoginBO loginBO = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.LOGIN);

    public AnchorPane contxtLoginForm;
    public JFXTextField txtUserName;
    public JFXTextField txtPwd;

    public void btnLogInOnAction(ActionEvent actionEvent) throws IOException {
        String uName = txtUserName.getText();
        String pwd = txtPwd.getText();

        try {

            boolean log = loginBO.checkLogin(uName, pwd);
            if(log == true){
                Stage stage = (Stage) contxtLoginForm.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"))));
            }else if (log == false){
                new Alert(Alert.AlertType.ERROR, "UserName and Password Incorrect... Try Again!!!").show();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Stage stage = (Stage) contxtLoginForm.getScene().getWindow();
        //stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"))));
    }

    public void btnAdminLogInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AdminLogInForm.fxml"))));
        stage.show();
    }
}
