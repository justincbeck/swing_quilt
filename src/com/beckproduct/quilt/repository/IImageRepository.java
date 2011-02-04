package com.beckproduct.quilt.repository;

import com.beckproduct.quilt.domain.RawImage;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 13, 2009
 * Time: 3:03:02 PM
 */
public interface IImageRepository
{
    public void saveFile(RawImage image);

    public RawImage getInstance(Serializable id);

    public RawImage getInstanceByName(String name);

    public List list();
}
