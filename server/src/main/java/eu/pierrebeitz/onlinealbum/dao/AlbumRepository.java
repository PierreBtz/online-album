package eu.pierrebeitz.onlinealbum.dao;

import eu.pierrebeitz.onlinealbum.entity.AlbumEntity;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<AlbumEntity, Long> {
}
