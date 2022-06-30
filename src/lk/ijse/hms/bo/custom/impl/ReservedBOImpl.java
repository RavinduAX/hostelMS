package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.ReservedBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.QueryDAO;
import lk.ijse.hms.dto.CustomDTO;
import lk.ijse.hms.entity.CustomEntity;
import lk.ijse.hms.util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservedBOImpl implements ReservedBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUEERYDAO);

    @Override
    public List<CustomDTO> getReservationList() throws SQLException, ClassNotFoundException {
        List<Object[]> customList = queryDAO.getReserveList();
        List<CustomDTO> dto = new ArrayList<>();

        for (Object[] cList : customList) {
            dto.add(new CustomDTO((String)cList[0], (String)cList[1], (String)cList[2], (String)cList[3]));
        }
        return dto;
    }
}
