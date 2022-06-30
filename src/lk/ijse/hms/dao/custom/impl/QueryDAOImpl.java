package lk.ijse.hms.dao.custom.impl;

import lk.ijse.hms.dao.custom.QueryDAO;
import lk.ijse.hms.entity.CustomEntity;
import lk.ijse.hms.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<Object[]> getReserveList() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT s.student_id, s.name, r.type, res.status FROM Student s INNER JOIN Reservation res ON s.student_id = res.student INNER JOIN Room r ON r.room_type_id = res.room";
        List<Object[]> customList = session.createQuery(hql).list();

        transaction.commit();
        session.close();
        return customList;
    }

    @Override
    public List<Object[]> getPendingList() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT s.student_id, s.name, r.type, res.status FROM Student s INNER JOIN Reservation res ON s.student_id = res.student INNER JOIN Room r ON r.room_type_id = res.room WHERE res.status = 'Pending'";
        List <Object[]> pendingList = session.createQuery(hql).list();

        transaction.commit();
        session.close();
        return pendingList;
    }
}
