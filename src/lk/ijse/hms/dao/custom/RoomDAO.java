package lk.ijse.hms.dao.custom;

import lk.ijse.hms.dao.CrudDAO;
import lk.ijse.hms.dao.SuperDAO;
import lk.ijse.hms.entity.Room;
import lk.ijse.hms.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface RoomDAO extends CrudDAO<Room, String> {
    public List<String> getRoomTypes() throws SQLException, ClassNotFoundException;

    public List<Room> getRoomId(String type) throws SQLException, ClassNotFoundException;
}
