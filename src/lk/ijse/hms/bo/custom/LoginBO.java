package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface LoginBO extends SuperBO {
    public boolean checkLogin(String uName, String pwd) throws SQLException, ClassNotFoundException;
}
