package com.beckproduct.quilt.repository;

import org.springframework.orm.hibernate3.support.*;

import java.io.*;
import java.awt.*;
import java.util.*;

import com.beckproduct.quilt.domain.*;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 8, 2009
 * Time: 1:09:07 PM
 */
public class QuiltRepository implements IQuiltRepository
{
    private EntityManagerFactory entityManagerFactory;

    public void create(Object instance)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();

        Quilt quilt = (Quilt) instance;
        entityManager.persist(quilt);

        tx.commit();
        entityManager.close();
    }

    public Object getInstance(Serializable id)
    {
        System.out.println("Get!");
        return null;
//        return getHibernateTemplate().get(QuiltTile.class, id);
    }

    public Object update(Object instance)
    {
        Quilt quilt = (Quilt) instance;
//        getHibernateTemplate().update(quilt);
//        getHibernateTemplate().flush();
        return quilt;
    }

    public void delete(Serializable id)
    {
        System.out.println("Delete!");
//        QuiltTile target = (QuiltTile) this.getInstance(id);
//        getHibernateTemplate().delete(target);
//        getHibernateTemplate().flush();
    }

    public void delete(Object id)
    {
        System.out.println("Delete!");
//        QuiltTile target = (QuiltTile) this.getInstance(id);
//        getHibernateTemplate().delete(target);
//        getHibernateTemplate().flush();
    }

    public EntityManagerFactory getEntityManagerFactory()
    {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory)
    {
        this.entityManagerFactory = entityManagerFactory;
    }
}
