package com.iljaust.hibirnate.repository;

import com.iljaust.hibirnate.model.Developer;
import com.iljaust.hibirnate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {
    private Transaction transaction;
    private Session session;
    @Override
    public Developer getById(Long id) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Developer developer = session.load(Developer.class, id);
            transaction.commit();

            return developer;
        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public Developer save(Developer developer) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(developer);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return developer;
    }

    @Override
    public Developer update(Developer developer) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(developer);
            transaction.commit();
        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return developer;
    }

    @Override
    public List<Developer> getAll() {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            List<Developer> developerList = session.createQuery("from Developer",Developer.class).list();

            transaction.commit();

            return developerList;

        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Developer developer = session.load(Developer.class, id);

            if(developer != null){
                session.delete(developer);
            }

            transaction.commit();

        }
        catch (Exception e){
            if(transaction != null)
                transaction.rollback();

            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}
