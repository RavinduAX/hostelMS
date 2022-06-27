package lk.ijse.hms.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.RoomBO;
import lk.ijse.hms.bo.custom.impl.RoomBOImpl;
import lk.ijse.hms.dto.RoomDTO;

import java.sql.SQLException;

public class RoomManageFormController {
    public TableView tblRoom;
    public TableColumn colRoomTypeId;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colRoomsQty;
    public TableColumn colDelete;
    public JFXTextField txtRoomTypeId;
    public JFXTextField txtType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public JFXButton btnSave;

    RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

    public void btnAddNewOnAction(ActionEvent actionEvent) {
        txtKeyMoney.clear();
        txtRoomQty.clear();
        txtRoomTypeId.clear();
        txtType.clear();
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {

    }
}
