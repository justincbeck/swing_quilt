package com.beckproduct.quilt.domain;

import javax.persistence.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(unique = true)
    private String name;

    private int rows;

    private int cols;

    @OneToMany(targetEntity = QuiltTile.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<QuiltTile> tiles = new ArrayList<QuiltTile>();

    public Quilt()
    {
        super();
    }

    public Quilt(String name, int cols, int rows)
    {
        super();
        this.name = name;
        this.cols = cols;
        this.rows = rows;
    }

    public Component addComponent(QuiltTile component)
    {
        super.add(component);
        return component;
    }

    public Component addTile(QuiltTile component)
    {
        tiles.add(component);
        return component;
    }

    public void setLayoutManager(LayoutManager layoutManager)
    {
        super.setLayout(layoutManager);
    }

    public LayoutManager getLayoutManager()
    {
        return super.getLayout();
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

    /**
     * @return Returns the rows.
     */
    public int getRows()
    {
        return rows;
    }

    /**
     * @param rows
     *            The rows to set.
     */
    public void setRows(int rows)
    {
        this.rows = rows;
    }

    /**
     * @return Returns the cols.
     */
    public int getCols()
    {
        return cols;
    }

    /**
     * @param cols
     *            The cols to set.
     */
    public void setCols(int cols)
    {
        this.cols = cols;
    }

    /**
     * @return Returns the tiles.
     */
    public List<QuiltTile> getTiles()
    {
        return tiles;
    }

    /**
     * @param tiles
     *            The tiles to set.
     */
    public void setTiles(List<QuiltTile> tiles)
    {
        this.tiles = tiles;
    }
}
