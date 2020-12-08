package com.iljaust.hibirnate.repository;

import com.iljaust.hibirnate.model.Skill;
import com.iljaust.hibirnate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SkillRepositoryImpl implements SkillRepository {
    private Transaction transaction;
    private Session session;
    @Override
    public Skill getById(Long id) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Skill skill = session.load(Skill.class, id);
            transaction.commit();

            return skill;
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
    public Skill save(Skill skill) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(skill);
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
        return skill;
    }

    @Override
    public Skill update(Skill skill) {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(skill);
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
        return skill;
    }

    @Override
    public List<Skill> getAll() {
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            List<Skill> skillList = session.createQuery("from Skill",Skill.class).list();

            transaction.commit();

            return skillList;

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
            Skill skill = session.load(Skill.class, id);

            if(skill != null){
                session.delete(skill);
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
