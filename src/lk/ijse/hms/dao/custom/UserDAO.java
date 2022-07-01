package lk.ijse.hms.dao.custom;

import lk.ijse.hms.dao.CrudDAO;
import lk.ijse.hms.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends CrudDAO<User, String> {
    public boolean updateUname(User entity) throws SQLException, ClassNotFoundException;

    public List<String> getUserID(String uName, String pwd) throws SQLException, ClassNotFoundException;

    public List<Object[]> checkLogin(String uName, String pwd) throws SQLException, ClassNotFoundException;
}
