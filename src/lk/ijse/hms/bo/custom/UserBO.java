package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {
    public boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException;

    public List<UserDTO> getAllUsers() throws SQLException, ClassNotFoundException;

    public boolean deleteUser(String userNme) throws SQLException, ClassNotFoundException;

    public boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException;
}
