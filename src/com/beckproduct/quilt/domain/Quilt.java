package com.beckproduct.quilt.domain;

import javax.swing.*;
import javax.persistence.*;

import java.util.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 16, 2009
 * Time: 2:54:14 PM
 *
 * The Quilt - The object that contains the all the tiles
 * <p>
 */

@Entity
@Table(name = "quilts")
public class Quilt extends JPanel
{
    @Id
    @GeneratedValue
    private Long id;

    private String name = "test";

    @OneToMany(targetEntity = QuiltTile.class, cascade = CascadeType.ALL)
    public Set<QuiltTile> tiles;

    public Quilt(LayoutManager layoutManager)
    {
        super(layoutManager);
        this.tiles = new LinkedHashSet<QuiltTile>();
    }

    public Component add(QuiltTile component)
    {
        tiles.add(component);
        super.add(component);
        return component;
    }

    /**
     * @return Returns the id.
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id
     *            The Id to set.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return Returns the name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
