package com.beckproduct.quilt.repository;

import com.beckproduct.quilt.domain.*;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 15, 2009
 * Time: 11:26:49 AM
 */
public interface ITileRepository
{
    public void create(Object tile);

    public Object getInstance(Serializable id);

    public Object update(Object tile);

    public void delete(Serializable id);
}
