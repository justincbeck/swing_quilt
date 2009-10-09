package com.beckproduct.quilt.domain;


import javax.swing.*;
import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 13, 2009
 * Time: 11:59:39 PM
 *
 * The QuiltTile - The object that contains the metadata about the file
 * <p>
 */

@Entity
@Table(name = "tiles")
public class QuiltTile extends JLabel
{
    @Id
    @GeneratedValue
    private Long id;

    private int rotation;

    private String fileName;

    public QuiltTile(ImageIcon image, String fileName, int rotation)
    {
        super(image);
        this.fileName = fileName;
        this.rotation = rotation;
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
     * @return Returns the filename.
     */
    public int getRotation()
    {
        return rotation;
    }

    /**
     * @param rotation
     *            The rotation to set.
     */
    public void setRotation(int rotation)
    {
        this.rotation = rotation;
    }

    /**
     * @return Returns the filename.
     */
    public String getFileName()
    {
        return fileName;
    }

    /**
     * @param fileName
     *            The fileName to set.
     */
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
}
