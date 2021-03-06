package com.iljaust.hibirnate.util;


import com.iljaust.hibirnate.model.Account;
import com.iljaust.hibirnate.model.AccountStatus;
import com.iljaust.hibirnate.model.Developer;
import com.iljaust.hibirnate.model.Skill;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL,"jdbc:mysql://localhost/myapp");
                settings.put(Environment.USER,"root");
                settings.put(Environment.PASS,"1234");
                settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL57InnoDBDialect");

                settings.put(Environment.SHOW_SQL,"true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");

                settings.put(Environment.HBM2DDL_AUTO,"none");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Skill.class);
                configuration.addAnnotatedClass(Developer.class);
                configuration.addAnnotatedClass(Account.class);
                configuration.addAnnotatedClass(AccountStatus.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
