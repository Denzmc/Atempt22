package com.example.attemptnumber22;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class UserDB {

    public static void saveUser(final User user){
        Transaction transaction ;
        try (final Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }
    public static void updateUser(User user){
        Transaction transaction;
        try (final Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }
    public static User readById(Integer id){
        try (final Session session = HibernateUtil.getSession()){
            return session.get(User.class, id);
        }
    }
    public static User readByName(String name){
        for (User allUser : getAllUsers()) {
            if (allUser.getName().equals(name))
                return allUser;
        }
        return null;
    }

    public static List<User> getAllUsers(){
        List<User> list;

        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();

            Query query = session.createQuery("FROM User");
            list = query.list();

            session.getTransaction().commit();
        }

        return list;
    }

    public static void deleteUser(User user){
        Transaction transaction;
        try (final Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.delete(user);
            transaction.commit();
        }
    }
}
