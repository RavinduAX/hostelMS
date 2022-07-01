package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.LoginBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.UserDAO;
import lk.ijse.hms.entity.User;

import java.sql.SQLException;
import java.util.List;

public class LoginBOImpl implements LoginBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean checkLogin(String uName, String pwd) throws SQLException, ClassNotFoundException {
        List<User> loginDetails = userDAO.checkLogin(uName, pwd);
        String userName = null;
        String pswd = null;
        for (User u : loginDetails) {
            userName = u.getUser_name();
            pswd = u.getPassword();
        }
        if((uName == userName) & (pwd == pswd)){
            return true;
        }else{
            return false;
        }

    }
}
