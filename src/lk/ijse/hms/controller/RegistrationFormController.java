package lk.ijse.hms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.util.Duration;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.RegistrationBO;
import lk.ijse.hms.bo.custom.RoomBO;
import lk.ijse.hms.dao.custom.RoomDAO;
import lk.ijse.hms.dto.ReservationDTO;
import lk.ijse.hms.dto.RoomDTO;
import lk.ijse.hms.dto.StudentDTO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public class RegistrationFormController {

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);
    RegistrationBO regBO = (RegistrationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.REGISTRATION);

    public JFXButton btnRegister;
    public JFXTextField txtAddress;
    public Label lblRsId;
    public JFXTextField txtName;
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
    public JFXTextField txtRoomTypeId;

    public void initialize(){
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");

        cmbPaymentType.getItems().add("Pay Now");
        cmbPaymentType.getItems().add("Pay Later");
        cmbPaymentType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals("Pay Later")){
                txtAmount.setText("Pending");
                txtAmount.setEditable(false);
            }else if(newValue.equals("Pay Now")) {
                txtAmount.setText("Complete");
                txtAmount.setEditable(false);
            }
        });

        loadRoomTypes();

        loadDateAndTime();

        cmbRoomType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String type = (String) newValue;
            try {
                List<RoomDTO> roomDto= getRoomID(type);
                for (RoomDTO r : roomDto) {
                    txtRoomTypeId.setText(r.getRoom_type_id());
                    txtRoomTypeId.setEditable(false);
                    txtKeyMoney.setText(r.getKey_money());
                    txtKeyMoney.setEditable(false);
                }


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        });

        generateNewRegId();
    }

    private void loadDateAndTime() {
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, event ->{
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(currentTime.getHour()+":"+currentTime.getMinute()+":"+currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    private void loadRoomTypes(){
        try {
            List<String> roomTypes = roomBO.getRoomTypes();
            for (String roomType : roomTypes) {
                cmbRoomType.getItems().add(roomType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<RoomDTO> getRoomID(String type) throws SQLException, ClassNotFoundException {
        List<RoomDTO> roomDetail = roomBO.getRoomId(type);
        return roomDetail;
    }

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        btnRegister.setDisable(false);
        generateNewRegId();
        clearUI();
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {
        String sId=txtStudentId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contactNo = txtContactNo.getText();
        LocalDate dob = dPickDob.getValue();
        String gender = (String) cmbGender.getValue();

        StudentDTO studentDTO = new StudentDTO(sId,name,address,contactNo,dob,gender);

        String roomTypeId = txtRoomTypeId.getText();
        String type = (String)cmbRoomType.getValue();
        String keyMoney = txtKeyMoney.getText();
        int qty = 1;

        RoomDTO roomDTO = new RoomDTO(roomTypeId,type,keyMoney,qty);

        String rsId = lblRsId.getText();
        LocalDate resDate = dPickRegistrationDate.getValue();
        String status = txtAmount.getText();

        ReservationDTO reservationDTO = new ReservationDTO(rsId,resDate,status);

        reserveRoom(studentDTO,roomDTO,reservationDTO);

        generateNewRegId();
        clearUI();
//===================================
        if (!sId.matches("^(S)[0-9]{3}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid StudentID 'S000'").show();
            txtStudentId.requestFocus();
            return;
        }else if (!name.matches("[A-Za-z ]")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Name '[A-z ]'").show();
            txtName.requestFocus();
            return;
        }else if (!address.matches("^[A-z0-9 ,/.]{4,50}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Address [A-z 0-9]").show();
            txtAddress.requestFocus();
            return;
        }else if (!contactNo.matches("^[0-9]{10}$")) {
            new Alert(Alert.AlertType.ERROR, "Invalid ContactNo '0123456789'").show();
            txtContactNo.requestFocus();
            return;
        }


    }

    private Boolean reserveRoom(StudentDTO stDTO, RoomDTO roomDTO, ReservationDTO resDTO) {
        try {
            return regBO.reserveRoom(stDTO,roomDTO,resDTO);
        } catch (SQLException e1) {
            e1.printStackTrace();
            new Alert(Alert.AlertType.WARNING, e1.getMessage()).show();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
        }
        return true;
    }

    private void generateNewRegId(){
        try {
            String id = regBO.generateNewRegId();
            lblRsId.setText(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void clearUI(){
        txtStudentId.clear();
        txtName.clear();
        txtAddress.clear();
        txtContactNo.clear();
        dPickDob.setValue(null);
        cmbGender.setValue(null);

        dPickRegistrationDate.setValue(null);
        cmbRoomType.setValue(null);
        txtRoomTypeId.clear();
        txtKeyMoney.clear();

        cmbPaymentType.setValue(null);
        txtAmount.clear();
    }

}
