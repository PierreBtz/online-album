package eu.pierrebeitz.onlinealbum.rest;

import eu.pierrebeitz.onlinealbum.dao.AlbumRepository;
import eu.pierrebeitz.onlinealbum.dto.Album;
import eu.pierrebeitz.onlinealbum.entity.AlbumEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequestMapping(value = "/albums")
@RestController
public class AlbumsController {

    @Autowired
    private AlbumRepository albumRepository;

    @RequestMapping(method = RequestMethod.POST)
    public void createAlbum(@RequestParam String name,
                            @RequestParam(required = false) String description,
                            @RequestParam(required = false) MultipartFile image) {
        // TODO: save image in statics, retrieve the static path
        String imageStaticPath = "";
        albumRepository.save(new AlbumEntity(name, description, imageStaticPath));
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Album> retrieveAlbums() {
        return StreamSupport
                .stream(albumRepository.findAll().spliterator(), true)
                .map(Album::new)
                .collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{albumId}")
    public Album retrieveAlbum(@PathVariable("albumId") Long albumId) {
        AlbumEntity album = albumRepository.findOne(albumId);
        return new Album(album);
    }
}
