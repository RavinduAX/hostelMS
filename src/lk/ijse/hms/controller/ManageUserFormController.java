package lk.ijse.hms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.UserBO;
import lk.ijse.hms.dto.UserDTO;
import lk.ijse.hms.view.tdm.UserTM;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ManageUserFormController {
    public TableView<UserTM> tblUser;
    public TableColumn colUserName;
    public TableColumn colPassword;
    //public TableColumn colDelete;
    public JFXButton btnSave;
    public JFXTextField txtPassword;
    public JFXTextField txtUserName;
    public FontAwesomeIconView btnDelete;
    public TableColumn colUserId;
    public JFXTextField txtUserId;

    UserBO userBO = (UserBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize(){
        colUserName.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colUserId.setCellValueFactory(new PropertyValueFactory<>("uId"));

        loadAllUsers();

        tblUser.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtUserId.setText(newValue.getUId());
            txtUserName.setText(newValue.getUser_name());
            txtPassword.setText(newValue.getPassword());
            if(newValue != null){
                btnSave.setText("Update");
            }
        });

        generateUserID();
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save");
        generateUserID();
        clearUI();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        if(btnSave.getText().equalsIgnoreCase("save")){
            try {
                if(userBO.saveUser(new UserDTO(userName, password))){
                    tblUser.getItems().add(new UserTM(userName, password));
                    new Alert(Alert.AlertType.CONFIRMATION, "Saved... !").show();
                    tblUser.refresh();
                    clearUI();
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if(btnSave.getText().equalsIgnoreCase("update")){
            try {
                if(userBO.updateUser(new UserDTO(userName,password))){
                    UserTM tm = tblUser.getSelectionModel().getSelectedItem();
                    tm.setUser_name(userName);
                    tm.setPassword(password);
                    tblUser.refresh();
                    clearUI();
                    btnSave.setText("Save");
                    new Alert(Alert.AlertType.CONFIRMATION, "Updated... !").show();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String userNme = txtUserName.getText();
        Alert alert = new Alert(Alert.AlertType.WARNING, "Are you sure you want to Delete \"" + userNme + "\" User ?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get().equals(ButtonType.YES)){
            try {
                if(userBO.deleteUser(userNme)){
                    new Alert(Alert.AlertType.CONFIRMATION,"Successfully Deleted !").show();
                    tblUser.getItems().remove(tblUser.getSelectionModel().getSelectedItem());
                    tblUser.getSelectionModel().clearSelection();
                    btnSave.setText("Save");
                    clearUI();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void clearUI(){
        txtUserName.clear();
        txtPassword.clear();
    }

    private void loadAllUsers(){
        try {
            List<UserDTO> allUsers = userBO.getAllUsers();
            for (UserDTO user : allUsers) {
                tblUser.getItems().add(new UserTM(user.getUser_name(),user.getPassword(), user.getNewUnamePwd()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void generateUserID(){
        try {
            String id = userBO.generateUserID();
            txtUserId.setText(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
