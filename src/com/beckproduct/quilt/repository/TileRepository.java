package com.beckproduct.quilt.repository;

import com.beckproduct.quilt.domain.*;
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
        this.update(instance);
    }

    public Object getInstance(Serializable id)
    {
        return getHibernateTemplate().get(QuiltTile.class, id);
    }

    public Object update(Object instance)
    {
        QuiltTile tile = (QuiltTile) instance;
        getHibernateTemplate().saveOrUpdate(tile);
        getHibernateTemplate().flush();
        return tile;
    }

    public void delete(Serializable id)
    {
        QuiltTile target = (QuiltTile) this.getInstance(id);
        getHibernateTemplate().delete(target);
        getHibernateTemplate().flush();
    }

    public void test()
    {
        System.out.println("Test");
    }
}
