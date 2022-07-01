package lk.ijse.hms.dao.custom.impl;

import lk.ijse.hms.dao.custom.UserDAO;
import lk.ijse.hms.entity.Reservation;
import lk.ijse.hms.entity.User;
import lk.ijse.hms.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "FROM User";
        List<User> userList = session.createQuery(hql).list();

        transaction.commit();
        session.close();
        return userList;
    }

    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<User> search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String userNme) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.load(User.class, userNme);
        session.delete(user);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<String> generateNewId() throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String sql = "SELECT uId FROM User ORDER BY uId DESC";
        NativeQuery query = session.createSQLQuery(sql);
        query.setMaxResults(1);
        List<String> lastId = query.list();

        transaction.commit();
        session.close();
        return lastId;
    }

    @Override
    public boolean updateUname(User entity) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();



        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<String> getUserID(String uName, String pwd) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT uId FROM User WHERE user_name = :name AND password = :pswd";
        Query query = session.createQuery(hql);
        query.setParameter("name", uName);
        query.setParameter("pswd", pwd);
        List<String> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public List<Object[]> checkLogin(String uName, String pwd) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        String hql = "SELECT user_name, password FROM User WHERE user_name = :name AND password = :pswd";
        Query query = session.createQuery(hql);
        query.setParameter("name", uName);
        query.setParameter("pswd", pwd);
        List<Object[]> list = query.list();

        transaction.commit();
        session.close();
        return list;
    }
}
