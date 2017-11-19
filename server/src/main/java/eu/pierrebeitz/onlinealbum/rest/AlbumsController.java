package eu.pierrebeitz.onlinealbum.rest;

import eu.pierrebeitz.onlinealbum.dao.AlbumRepository;
import eu.pierrebeitz.onlinealbum.dto.Album;
import eu.pierrebeitz.onlinealbum.entity.AlbumEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequestMapping(value = "/albums")
@RestController
public class AlbumsController {
    @Value("${statics.path}")
    private String staticPath;

    @Autowired
    private AlbumRepository albumRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createAlbum(@RequestParam String name,
                                         @RequestParam(required = false) String description,
                                         @RequestParam(required = false) MultipartFile image) throws URISyntaxException {
        Path imagePath = Paths.get(name, image.getOriginalFilename());
        File fileToSave = Paths.get(staticPath, imagePath.toString()).toFile();
        try {
            fileToSave.getParentFile().mkdirs();
            fileToSave.createNewFile();
            image.transferTo(fileToSave);
        } catch (IOException e) {
            //TODO real exception handling...
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        albumRepository.save(new AlbumEntity(name, description, imagePath.toString()));
        return ResponseEntity.created(new URI(imagePath.toString())).build();
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
