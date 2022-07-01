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
        UserDTO uDto = new UserDTO();
        for (User user : userList) {
            dtoList.add(new UserDTO(user.getUId(), user.getUser_name(), user.getPassword()));

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

    @Override
    public boolean changeUName(UserDTO dto) throws SQLException, ClassNotFoundException {
        String curntUName = dto.getUser_name();
        String pwd = dto.getPassword();
        String newUName = dto.getNewUnamePwd();

        List<String> idList = userDAO.getUserID(curntUName, pwd);
        String id = null;
        for (String s : idList) {
            id = s;
        }

        return userDAO.update(new User(id,newUName,pwd));
    }

    @Override
    public boolean changePwd(UserDTO dto) throws SQLException, ClassNotFoundException {
        String uName = dto.getUser_name();
        String crntPwd = dto.getPassword();
        String newPwd = dto.getNewUnamePwd();

        List<String> idList = userDAO.getUserID(uName, crntPwd);
        String id = null;
        for (String s : idList) {
            id = s;
        }

        return userDAO.update(new User(id,uName,newPwd));
    }

    @Override
    public String generateUserID() throws SQLException, ClassNotFoundException {
        List<String> lastId = userDAO.generateNewId();
        String id = null;

        for (String s : lastId) {
            id = s;
        }

        if(id != null){
            return String.format("U%03d", (Integer.parseInt(id.replace("U", "")) + 1));
        }else{
            return "U001";
        }
    }
}
