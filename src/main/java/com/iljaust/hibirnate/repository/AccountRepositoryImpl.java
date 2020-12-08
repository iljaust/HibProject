package com.iljaust.hibirnate.repository;

import com.iljaust.hibirnate.model.Account;
import com.iljaust.hibirnate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {
    private Transaction transaction;
    private Session session;

    @Override
    public Account getById(Long id) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Account account = session.load(Account.class, id);
            transaction.commit();

            return account;
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
    public Account save(Account account) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(account);
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
        return account;
    }

    @Override
    public Account update(Account account) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(account);
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
        return account;
    }

    @Override
    public List<Account> getAll() {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            List<Account> accountList = session.createQuery("from Account",Account.class).list();

            transaction.commit();

            return accountList;

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
            Account account = session.load(Account.class, id);

            if(account != null){
                session.delete(account);
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
