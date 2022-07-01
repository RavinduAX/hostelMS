package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.LoginBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.UserDAO;
import lk.ijse.hms.dto.UserDTO;
import lk.ijse.hms.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginBOImpl implements LoginBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean checkLogin(String uName, String pwd) throws SQLException, ClassNotFoundException {
        List<Object[]> ldl = userDAO.checkLogin(uName, pwd);
        List<UserDTO> dto = new ArrayList<>();
        String name = null;
        String pswd = null;
        for (Object[] o : ldl) {
            name = (String) o[0];
            pswd = (String) o[1];
        }

        boolean log = false;
        if(name.equals(uName) & pswd.equals(pwd)){
            log = true;
        }else if(!name.equals(uName) & !pswd.equals(pwd)){
            log = false;
        }
        return log;

    }
}
