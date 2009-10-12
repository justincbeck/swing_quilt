package com.beckproduct.quilt.repository;

import com.beckproduct.quilt.domain.*;

import javax.persistence.*;
import java.io.*;

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
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Quilt quilt = (Quilt) instance;
        entityManager.persist(quilt);

        transaction.commit();
        entityManager.close();
    }

    public Object getInstance(Serializable id)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Quilt quilt =
            (Quilt) entityManager.createQuery("select q from Quilt q where q.id = " + id).getSingleResult();

        transaction.commit();
        entityManager.close();

        return quilt;
    }

    public Object update(Object instance)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Quilt quilt = (Quilt) instance;
        entityManager.merge(quilt);

        transaction.commit();
        entityManager.close();

        return quilt;
    }

    public void delete(Serializable id)
    {
        Object q = this.getInstance(id);
        this.delete(q);
    }

    public void delete(Object instance)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.remove(instance);

        transaction.commit();
        entityManager.close();
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
