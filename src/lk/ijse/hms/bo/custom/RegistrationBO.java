package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.ReservationDTO;
import lk.ijse.hms.dto.RoomDTO;
import lk.ijse.hms.dto.StudentDTO;

import java.sql.SQLException;

public interface RegistrationBO extends SuperBO {
    public String generateNewOrderID() throws SQLException, ClassNotFoundException;

    public boolean reserveRoom(StudentDTO stDTO, RoomDTO roomDTO, ReservationDTO resDTO) throws SQLException, ClassNotFoundException;
}
