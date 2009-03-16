package com.beckproduct.quilt.repository;

import com.beckproduct.quilt.domain.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 15, 2009
 * Time: 11:26:49 AM
 */
public interface ITileRepository
{
    public void create(QuiltTile tile);

    public QuiltTile get(String id);

    public void update(QuiltTile tile);

    public void delete(QuiltTile tile);
}
