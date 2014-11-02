package com.beckproduct.quilt.repository;

import com.beckproduct.quilt.domain.RawImage;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 13, 2009
 * Time: 3:03:12 PM
 */
public class ImageRepository implements IImageRepository
{
    static Logger logger = Logger.getLogger(ImageRepository.class);

    private EntityManagerFactory entityManagerFactory;

    public void saveFile(RawImage image)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(image);

        transaction.commit();
        entityManager.close();
    }

    public RawImage getInstance(Serializable id)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        RawImage image = (RawImage) entityManager.createQuery("select i from RawImage i where i.id = " + id).getSingleResult();

        transaction.commit();
        entityManager.close();

        return image;
    }

    public RawImage getInstanceByName(String name)
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        RawImage image = (RawImage) entityManager.createQuery("select i from RawImage i where i.name = '" + name + "'").getSingleResult();

        transaction.commit();
        entityManager.close();

        return image;
    }

    public List list()
    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        List list = entityManager.createQuery("select image.name from RawImage image").getResultList();

        transaction.commit();
        entityManager.close();

        return list;
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
