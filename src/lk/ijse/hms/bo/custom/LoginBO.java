package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;

import java.sql.SQLException;

public interface LoginBO extends SuperBO {
    public boolean checkLogin(String uName, String pwd) throws SQLException, ClassNotFoundException;
}
