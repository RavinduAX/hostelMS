package lk.ijse.hms.bo.custom.impl;

import lk.ijse.hms.bo.custom.CheckOutBO;
import lk.ijse.hms.dao.DAOFactory;
import lk.ijse.hms.dao.custom.QueryDAO;
import lk.ijse.hms.dao.custom.ReservationDAO;
import lk.ijse.hms.dao.custom.RoomDAO;
import lk.ijse.hms.dao.custom.StudentDAO;
import lk.ijse.hms.dto.CustomDTO;
import lk.ijse.hms.dto.RoomDTO;
import lk.ijse.hms.entity.Room;
import lk.ijse.hms.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckOutBOImpl implements CheckOutBO {
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUEERYDAO);
    ReservationDAO resDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION);
    StudentDAO stuDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);


    @Override
    public List<CustomDTO> searchCheckOut(String id) throws SQLException, ClassNotFoundException {
        List<Object[]> searchList = queryDAO.search(id);
        List<CustomDTO> dto = new ArrayList<>();

        for (Object[] o : searchList) {
            dto.add(new CustomDTO((String)o[0], (String)o[1], (String)o[2]));
        }
        return dto;
    }

    @Override
    public boolean checkoutStudent(String sId, String roomId, String status) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().openSession();
        Transaction transaction = session.beginTransaction();

        boolean stuDelete = stuDAO.delete(sId);
        if(!stuDelete){
            transaction.rollback();
        }else{
            transaction.commit();
        }

        List<Room> srchList = roomDAO.search(roomId);
        RoomDTO dto = null;
        for (Room r : srchList) {
            new RoomDTO(r.getRoom_type_id(),r.getType(),r.getKey_money(),r.getQty());
        }
        int qty = dto.getQty();
        dto.setQty(qty + 1);
        Room room = new Room();
        room.setRoom_type_id(dto.getRoom_type_id());
        room.setType(dto.getType());
        room.setKey_money(dto.getKey_money());
        room.setQty(dto.getQty());
        boolean roomUpdate = roomDAO.update(room);
        if(!roomUpdate){
            transaction.rollback();
        }else{
            transaction.commit();
        }

        List<Object[]> obj = queryDAO.searchResId(sId, roomId, status);
        String reserveId = null;
        for (Object[] o : obj) {
            reserveId = (String) o[0];
        }
        boolean deleteRes = resDAO.delete(reserveId);
        if(!deleteRes){
            transaction.rollback();
        }else{
            transaction.commit();
        }

        transaction.commit();
        session.close();
        return true;
    }
}
