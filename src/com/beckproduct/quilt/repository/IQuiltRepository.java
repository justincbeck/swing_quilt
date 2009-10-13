package com.beckproduct.quilt.repository;

import java.io.*;

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

    public void delete(Serializable id);

    public void delete(Object quilt);
}
