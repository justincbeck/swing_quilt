package com.beckproduct.quilt.repository;

import org.springframework.orm.hibernate3.support.*;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 8, 2009
 * Time: 1:09:07 PM
 */
public class QuiltRepository extends HibernateDaoSupport implements IQuiltRepository
{
    public void create(Object instance)
    {
        System.out.println("Create!");
//        this.update(instance);
    }

    public Object getInstance(Serializable id)
    {
        System.out.println("Get!");
        return null;
//        return getHibernateTemplate().get(QuiltTile.class, id);
    }

    public Object update(Object instance)
    {
        System.out.println("Update!");
        return null;
//        QuiltTile tile = (QuiltTile) instance;
//        getHibernateTemplate().saveOrUpdate(tile);
//        getHibernateTemplate().flush();
//        return tile;
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
}
