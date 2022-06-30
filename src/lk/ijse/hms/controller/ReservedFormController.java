package lk.ijse.hms.controller;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hms.bo.BOFactory;
import lk.ijse.hms.bo.custom.ReservedBO;
import lk.ijse.hms.dto.CustomDTO;
import lk.ijse.hms.view.tdm.PendingDetailTM;
import lk.ijse.hms.view.tdm.ReserveDetailTM;

import java.sql.SQLException;
import java.util.List;

public class ReservedFormController {

    ReservedBO reservedBO = (ReservedBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESERVED);

    public TableView<ReserveDetailTM> tblStudentReservation;
    public TableColumn colStudentId;
    public TableColumn colStudentName;
    public TableColumn colRoomType;
    public TableColumn colStatus;
    public TableView<PendingDetailTM> tblKeyMoneyPendingK;
    public TableColumn colStudentIdK;
    public TableColumn colStudentNameK;
    public TableColumn colRoomTypeK;
    public TableColumn colStatusK;

    public void initialize(){
        colStudentId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        colStudentIdK.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        colStudentNameK.setCellValueFactory(new PropertyValueFactory<>("name"));
        colRoomTypeK.setCellValueFactory(new PropertyValueFactory<>("type"));
        colStatusK.setCellValueFactory(new PropertyValueFactory<>("status"));

        getReservationList();

        getPendingList();

    }

    private void getReservationList() {
        try {
            List<CustomDTO> resList = reservedBO.getReservationList();
            for (CustomDTO dto : resList) {
                tblStudentReservation.getItems().add(new ReserveDetailTM(dto.getStudent_id(), dto.getName(), dto.getType(), dto.getStatus()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void getPendingList() {
        try {
            List<CustomDTO> penList = reservedBO.getPendingList();
            for (CustomDTO dto : penList) {
                tblKeyMoneyPendingK.getItems().add(new PendingDetailTM(dto.getStudent_id(), dto.getName(), dto.getType(), dto.getStatus()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
