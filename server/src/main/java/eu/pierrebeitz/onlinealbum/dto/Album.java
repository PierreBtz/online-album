package eu.pierrebeitz.onlinealbum.dto;

import eu.pierrebeitz.onlinealbum.entity.AlbumEntity;

public class Album {

    private String name;
    private String description;

    public Album() {
    }

    public Album(AlbumEntity album) {
        name = album.getName();
        description = album.getDescription();
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
}
