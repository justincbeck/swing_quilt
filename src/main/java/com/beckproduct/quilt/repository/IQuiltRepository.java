package com.beckproduct.quilt.repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 8, 2009
 * Time: 1:08:56 PM
 */
public interface IQuiltRepository
{
    public void save(Object quilt);

    public Object getInstance(Serializable id);

    public Object getInstanceByName(String name);

    public List list();

    public void delete(Serializable id);

    public void delete(Object quilt);
}
