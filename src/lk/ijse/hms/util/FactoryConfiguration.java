package lk.ijse.hms.util;

import lk.ijse.hms.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FactoryConfiguration {
    private static SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().loadProperties("application.properties").build();

        Metadata meta = new MetadataSources(registry)
                .addAnnotatedClass(CustomEntity.class)
                .addAnnotatedClass(Reservation.class)
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(User.class)
                .getMetadataBuilder().build();

       return meta.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getInstance(){
        return sessionFactory;
    }
}
