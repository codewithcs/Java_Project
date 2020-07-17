package com.murex.retail.experience;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Reader {

    public static List<ComputerComponent> getDataFromDB() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from ComputerComponent", ComputerComponent.class).list();
        } catch (Exception e) {
            throw new DatabaseReadException("Failed to read from the database\n", e);
        }
    }
}
