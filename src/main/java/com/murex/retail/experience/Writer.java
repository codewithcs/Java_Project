package com.murex.retail.experience;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Writer {


    public Writer(){

    }

    static void writeToDb(ComputerComponent obj) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void writeListToDb(List<ComputerComponent> computerComponent){
        for(ComputerComponent item : computerComponent)
            writeToDb(item);
    }
}
