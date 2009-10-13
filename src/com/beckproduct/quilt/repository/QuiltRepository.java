package com.beckproduct.quilt.repository;

import com.beckproduct.quilt.domain.*;

import javax.persistence.*;
import java.io.*;
import java.util.*;

import org.apache.log4j.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 8, 2009
 * Time: 1:09:07 PM
 */
public class QuiltRepository implements IQuiltRepository
{
    static Logger logger = Logger.getLogger(QuiltRepository.class);

    private EntityManagerFactory entityManagerFactory;

    public void save(Object instance)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Quilt quilt = (Quilt) instance;
        if (quilt.getId() == null)
        {
            try
            {
                entityManager.persist(quilt);
            }
            catch (Exception e)
            {
                logger.error(e.getMessage());
                return;
            }
        }
        else
        {
            entityManager.merge(quilt);
        }

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

    public Object getInstanceByName(String name)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Object instance = entityManager.createQuery("select quilt from Quilt quilt where quilt.name = '" + name + "'").getSingleResult();

        transaction.commit();
        entityManager.close();
        return instance;
    }

    public List list()
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List quiltNames = entityManager.createQuery("select quilt.name from Quilt quilt").getResultList();

        transaction.commit();
        entityManager.close();
        return quiltNames;
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
