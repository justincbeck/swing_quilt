package com.beckproduct.quilt.repository;

import org.springframework.orm.hibernate3.support.*;

import java.io.*;
import java.awt.*;
import java.util.*;

import com.beckproduct.quilt.domain.*;

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
        Quilt quilt = (Quilt) instance;
        Iterator i = quilt.tiles.iterator();
        while(i.hasNext())
        {
            QuiltTile tile = (QuiltTile) i.next();
            tile.setId(1l);
        }
        quilt.setId(1l);
        getHibernateTemplate().save(quilt);
        getHibernateTemplate().flush();
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
        getHibernateTemplate().update(quilt);
        getHibernateTemplate().flush();
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
}
