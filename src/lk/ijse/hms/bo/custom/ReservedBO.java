package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.CustomDTO;

import java.sql.SQLException;
import java.util.List;

public interface ReservedBO extends SuperBO {

    public List<CustomDTO> getReservationList() throws SQLException, ClassNotFoundException;

}
