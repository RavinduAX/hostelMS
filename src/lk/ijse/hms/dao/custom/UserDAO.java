package lk.ijse.hms.dao.custom;

import lk.ijse.hms.dao.CrudDAO;
import lk.ijse.hms.entity.User;

import java.sql.SQLException;

public interface UserDAO extends CrudDAO<User, String> {
    public boolean updateUname(User entity) throws SQLException, ClassNotFoundException;
}
