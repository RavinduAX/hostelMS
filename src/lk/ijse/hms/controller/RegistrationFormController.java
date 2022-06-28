package lk.ijse.hms.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class RegistrationFormController {
    public Label lblTime;
    public Label lblDate;
    public JFXTextField txtStudentId;
    public JFXTextField btnName;
    public JFXTextField btnAddress;
    public JFXTextField txtContactNo;
    public JFXComboBox cmbGender;
    public JFXDatePicker dPickDob;
    public JFXComboBox cmbRoomType;
    public JFXDatePicker dPickRegistrationDate;
    public JFXComboBox cmbPaymentType;
    public JFXTextField txtAmount;
    public JFXTextField txtKeyMoney;

    public void btnRegisterOnAction(ActionEvent actionEvent) {
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
    }
}
