package com.beckproduct.quilt.repository;

import org.springframework.orm.hibernate3.support.*;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 15, 2009
 * Time: 11:28:56 AM
 */
public class TileRepository extends HibernateDaoSupport implements ITileRepository
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
}
