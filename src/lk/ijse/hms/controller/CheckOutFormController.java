package lk.ijse.hms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.CheckOutBO;
import lk.ijse.hms.dto.CustomDTO;

import java.sql.SQLException;
import java.util.List;

public class CheckOutFormController {

    CheckOutBO checkOutBO = (CheckOutBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CHECKOUT);

    public JFXButton btnCheckOut;
    public JFXTextField txtStudentId;
    public JFXTextField txtRoomId;
    public JFXTextField txtStatus;
    public Label lblWarning;

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
            List<CustomDTO> searchList = checkOutBO.searchCheckOut(txtStudentId.getText());
            String roomId = null;
            String status = null;
            for (CustomDTO dto : searchList) {
                roomId = dto.getRoom_type_id();
                status = dto.getStatus();
            }
            txtRoomId.setText(roomId);
            txtStatus.setText(status);

            if(txtStatus.getText().equals("Pending")){
                lblWarning.setText("Can't CheckOut Until Pay KeyMoney");
                btnCheckOut.setDisable(true);
            }else{
                lblWarning.setText("Can CheckOut...");
                btnCheckOut.setDisable(false);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void btnCheckOutOnAction(ActionEvent actionEvent) {
        String sId = txtStudentId.getText();
        String roomId = txtRoomId.getText();
        String status = txtStatus.getText();

        try {
            checkOutBO.checkoutStudent(sId, roomId, status);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
