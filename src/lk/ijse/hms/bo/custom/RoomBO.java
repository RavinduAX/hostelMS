package lk.ijse.hms.bo.custom;

import lk.ijse.hms.bo.SuperBO;
import lk.ijse.hms.dto.RoomDTO;

import java.sql.SQLException;
import java.util.List;

public interface RoomBO extends SuperBO {

    public boolean saveRooms(RoomDTO dto) throws SQLException, ClassNotFoundException;

    public boolean updateRooms(RoomDTO dto) throws SQLException, ClassNotFoundException;

    public List<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException;

    public boolean deleteRoom(String typeId) throws SQLException, ClassNotFoundException;
}
