package com.beckproduct.quilt.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: jbeck
 * Date: Oct 13, 2009
 * Time: 3:27:41 PM
 */

@Entity
@Table(name = "images")
public class RawImage
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(columnDefinition="MEDIUMBLOB")
    private byte[] image;

    public RawImage()
    {
        // Default Constructor
    }

    public RawImage(String name, byte[] image)
    {
        this.name = name;
        this.image = image;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public byte[] getImage()
    {
        return image;
    }

    public void setImage(byte[] image)
    {
        this.image = image;
    }

//    public QuiltTile getTile()
//    {
//        return tile;
//    }
//
//    public void setTile(QuiltTile tile)
//    {
//        this.tile = tile;
//    }
}
