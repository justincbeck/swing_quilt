package com.beckproduct.quilt.domain;


import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Mar 13, 2009
 * Time: 11:59:39 PM
 *
 * The QuiltTile - The object that contains the metadata about the file
 * <p>
 *
 * @hibernate.class table="tile" lazy="false"
 */
public class QuiltTile extends JLabel
{
    private String id;

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
     * @hibernate.id generator-class="uuid.hex"
     */
    public String getId()
    {
        return id;
    }

    /**
     * @param id
     *            The Id to set.
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @hibernate.property column="rotation" type="integer" length="1"
     *                     unique="false"
     *
     * @return Returns the filename.
     */
    public int getRotation()
    {
        return rotation;
    }

    public void setRotation(int rotation)
    {
        this.rotation = rotation;
    }

    /**
     * @hibernate.property column="filename" type="string" length="255"
     *                     unique="false"
     *
     * @return Returns the filename.
     */
    public String getFileName()
    {
        return fileName;
    }

    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }
}
