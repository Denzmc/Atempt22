package com.example.attemptnumber22;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StockDB {

    public static void saveStock(final Stock stock){
        Transaction transaction ;
        try (final Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.save(stock);
            transaction.commit();
        }
    }

    public static void updateStock(Stock stock){
        Transaction transaction;
        try (final Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.update(stock);
            transaction.commit();
        }
    }
    public static List<Stock> getAllStocks(){
        List<Stock> list;

        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();

            Query query = session.createQuery("FROM Stock ");
            list = query.list();

            session.getTransaction().commit();
        }

        return list;
    }
    public static Stock readById(Integer id){
        try (final Session session = HibernateUtil.getSession()){
            return session.get(Stock.class, id);
        }
    }
    public static Stock readByName(String name){
        for (Stock stock : getAllStocks()) {
            if (stock.getNameStock().equals(name))
                return stock;
        }
        return null;
    }
}
