package lk.ijse.hms.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.UserBO;
import lk.ijse.hms.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;

public class UserManageFormController {

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public TextField txtCrntUName;
    public TextField txtNewUName;
    public TextField txtPwd;

    public TextField txtUName;
    public TextField txtCrntPwd;
    public TextField txtNewPwd;


    public void btnChangeUNameOnAction(ActionEvent actionEvent) {
        String curntUName = txtCrntUName.getText();
        String pwd = txtPwd.getText();
        String newUName = txtNewUName.getText();

        try {
            if(userBO.changeUName(new UserDTO(curntUName, pwd, newUName))){
                new Alert(Alert.AlertType.CONFIRMATION, "UserName Updated ...!").show();
                clearUI();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnChangePwdOnAction(ActionEvent actionEvent) {
        String uName = txtUName.getText();
        String crntPwd = txtCrntPwd.getText();
        String newPwd = txtNewPwd.getText();

        try {
            if(userBO.changePwd(new UserDTO(uName, crntPwd, newPwd))){
                new Alert(Alert.AlertType.CONFIRMATION, "Password Updated ...!").show();
                clearUI();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void clearUI(){
        txtCrntUName.clear();
        txtNewUName.clear();
        txtPwd.clear();
        txtUName.clear();
        txtCrntPwd.clear();
        txtNewPwd.clear();
    }

}
