package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.CustomDTO;

import java.sql.SQLException;
import java.util.List;

public interface CheckOutBO extends SuperBO {

    public List<CustomDTO> searchCheckOut(String id) throws SQLException, ClassNotFoundException;

    boolean checkoutStudent(String sId, String roomId, String status) throws SQLException, ClassNotFoundException;
}
