package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.ReservationDTO;
import lk.ijse.hms.dto.RoomDTO;
import lk.ijse.hms.dto.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public interface RegistrationBO extends SuperBO {

    public boolean reserveRoom(StudentDTO stDTO, RoomDTO roomDTO, ReservationDTO resDTO) throws SQLException, ClassNotFoundException;

    public String generateNewRegId() throws SQLException, ClassNotFoundException;
}
