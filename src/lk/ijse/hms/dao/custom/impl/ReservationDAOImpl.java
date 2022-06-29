package lk.ijse.hms.dao.custom.impl;

import lk.ijse.hms.dao.custom.ReservationDAO;
import lk.ijse.hms.entity.Reservation;
import lk.ijse.hms.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public List<Reservation> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Reservation entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Reservation entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Reservation search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Reservation> generateNewId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT res_id FROM Reservation ORDER BY res_id DESC LIMIT 1";
        NativeQuery sqlQuery = session.createSQLQuery(hql);
        sqlQuery.addEntity(Reservation.class);
        List<Reservation> idList = sqlQuery.list();

        transaction.commit();
        session.close();
        return idList;
    }

}
