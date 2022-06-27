package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.RoomBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.RoomDAO;
import lk.ijse.hms.dto.RoomDTO;
import lk.ijse.hms.entity.Room;

import java.sql.SQLException;

public class RoomBOImpl implements RoomBO {

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);

}
