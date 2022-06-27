package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.UserBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.UserDAO;
import lk.ijse.hms.dto.UserDTO;
import lk.ijse.hms.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.save(new User(dto.getUser_name(), dto.getPassword()));
    }

    @Override
    public List<UserDTO> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> userList = userDAO.getAll();
        List<UserDTO> dtoList= new ArrayList<>();
        for (User user : userList) {
            dtoList.add(new UserDTO(user.getUser_name(), user.getPassword()));
        }
        return dtoList;
    }

    @Override
    public boolean deleteUser(String userNme) throws SQLException, ClassNotFoundException {
        return userDAO.delete(userNme);
    }

    @Override
    public boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.update(new User(dto.getUser_name(), dto.getPassword()));
    }
}
