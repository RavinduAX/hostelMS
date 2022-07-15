package lk.ijse.hms.dao.custom.impl;

import lk.ijse.hms.dao.custom.ReservationDAO;
import lk.ijse.hms.entity.Reservation;
import lk.ijse.hms.entity.User;
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
        Session session = FactoryConfiguration.getInstance().openSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Reservation entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Reservation> search(String status) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String resId) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().openSession();
        Transaction transaction = session.beginTransaction();

        Reservation res = session.load(Reservation.class, resId);
        session.delete(res);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<String> generateNewId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().openSession();
        Transaction transaction = session.beginTransaction();

        String sql = "SELECT res_id FROM Reservation ORDER BY res_id DESC";
        NativeQuery query = session.createSQLQuery(sql);
        query.setMaxResults(1);
        List<String> lastId = query.list();

        transaction.commit();
        session.close();
        return lastId;
    }

}
