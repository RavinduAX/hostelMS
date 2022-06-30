package lk.ijse.hms.dao.custom;

import lk.ijse.hms.dao.SuperDAO;
import lk.ijse.hms.dto.CustomDTO;
import lk.ijse.hms.entity.CustomEntity;

import java.sql.SQLException;
import java.util.List;

public interface QueryDAO extends SuperDAO {
    public List<Object[]> getReserveList() throws SQLException, ClassNotFoundException;
}
