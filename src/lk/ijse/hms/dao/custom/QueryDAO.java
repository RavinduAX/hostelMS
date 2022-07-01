package lk.ijse.hms.dao.custom;

import lk.ijse.hms.dao.SuperDAO;
import lk.ijse.hms.dto.CustomDTO;
import lk.ijse.hms.entity.CustomEntity;

import java.sql.SQLException;
import java.util.List;

public interface QueryDAO extends SuperDAO {
    public List<Object[]> getReserveList() throws SQLException, ClassNotFoundException;

    public List<Object[]> getPendingList() throws SQLException, ClassNotFoundException;

    public List<Object[]> search(String id) throws SQLException, ClassNotFoundException;

    public List<Object[]> searchResId(String sId, String roomId, String status) throws SQLException, ClassNotFoundException;
}
