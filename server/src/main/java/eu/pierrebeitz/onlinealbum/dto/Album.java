package eu.pierrebeitz.onlinealbum.dto;

import eu.pierrebeitz.onlinealbum.entity.AlbumEntity;

public class Album {

    private String name;
    private String description;
    private String imageStaticPath;

    public Album() {
    }

    public Album(AlbumEntity album) {
        name = album.getName();
        description = album.getDescription();
        imageStaticPath = album.getImageStaticPath();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageStaticPath() {
        return imageStaticPath;
    }

    public void setImageStaticPath(String imageStaticPath) {
        this.imageStaticPath = imageStaticPath;
    }
}