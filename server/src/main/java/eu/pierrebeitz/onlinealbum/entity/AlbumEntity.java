package eu.pierrebeitz.onlinealbum.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AlbumEntity {

    @Id
    private String name;
    private String description;

    public AlbumEntity() {
        // used by JPA
    }

    public AlbumEntity(String name, String description) {
        this.name = name;
        this.description = description;
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
