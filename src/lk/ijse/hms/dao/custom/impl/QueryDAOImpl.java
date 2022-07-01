package lk.ijse.hms.dao.custom.impl;

import lk.ijse.hms.dao.custom.QueryDAO;
import lk.ijse.hms.entity.CustomEntity;
import lk.ijse.hms.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    @Override
    public List<Object[]> search(String id) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT s.student_id, r.room_type_id, res.status FROM Student s INNER JOIN Reservation res ON s.student_id = res.student INNER JOIN Room r ON r.room_type_id = res.room WHERE s.student_id = :sId";
        Query query = session.createQuery(hql);
        query.setParameter("sId", id);
        List<Object[]> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<Object[]> searchResId(String sId, String roomId, String status) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql = "SELECT res.res_id FROM Student s INNER JOIN Reservation res ON s.student_id = res.student INNER JOIN Room r ON r.room_type_id = res.room WHERE ((s.student_id = :stId AND res.status = :resstatus) AND r.room_type_id = :rTypeId )";
        Query query = session.createQuery(hql);
        query.setParameter("stId", sId);
        query.setParameter("resstatus", roomId);
        query.setParameter("rTypeId", status);
        List<Object[]> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }
}
