package eu.pierrebeitz

import grails.rest.RestfulController
import grails.validation.ValidationException
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import javax.servlet.http.HttpServletResponse

import static org.springframework.http.HttpStatus.*

class AlbumController extends RestfulController {

    private static final int DEFAULT_LIMIT = 100
    AlbumService albumService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    AlbumController() {
        super(Album)
    }

    def index(Integer max) {
        params.max = max ?: DEFAULT_LIMIT
        respond albumService.list(params)
    }

    def show(Long id) {
        if (id == null) {
            index(DEFAULT_LIMIT)
        } else {
            respond albumService.get(id)
        }
    }

    def save(Album album) {
        if (album == null) {
            render status: NOT_FOUND
            return
        }

        def newAlbum
        try {
            newAlbum = albumService.save(album)
        } catch (ValidationException e) {
            respond album.errors, view: 'create'
            return
        }

        assert newAlbum != null

        response.setStatus(HttpServletResponse.SC_CREATED)
        response.setHeader('Location', ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/${newAlbum.id}")
                .build()
                .toUri().toString())
        respond newAlbum
    }

    def update(Album album) {
        if (album == null) {
            render status: NOT_FOUND
            return
        }

        try {
            albumService.save(album)
        } catch (ValidationException e) {
            respond album.errors, view: 'edit'
            return
        }

        respond album, [status: OK, view: "show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        albumService.delete(id)

        render status: NO_CONTENT
    }
}
