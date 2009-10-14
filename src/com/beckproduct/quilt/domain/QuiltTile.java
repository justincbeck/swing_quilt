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

    @ManyToOne(targetEntity = RawImage.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private RawImage image;

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
     * @return Returns the image.
     */
    public Icon getIcon()
    {
        return super.getIcon();
    }

    /**
     * @param icon
     *            The image to set.
     */
    public void setIcon(Icon icon)
    {
        super.setIcon(icon);
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

    public RawImage getImage()
    {
        return image;
    }

    public void setImage(RawImage image)
    {
        this.image = image;
    }
}
