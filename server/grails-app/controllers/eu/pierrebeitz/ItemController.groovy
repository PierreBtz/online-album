package eu.pierrebeitz

import grails.rest.RestfulController
import grails.validation.ValidationException
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import javax.servlet.http.HttpServletResponse

class ItemController extends RestfulController {

    private static final int DEFAULT_LIMIT = 10
    ItemService itemService

    static responseFormats = ['json']
    static allowedMethods = [upload: "POST"]

    ItemController() {
        super(Item)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: DEFAULT_LIMIT, 100)
        respond itemService.list(params)
    }

    def show(Long id) {
        if (id == null) {
            index(DEFAULT_LIMIT)
        } else {
            respond itemService.get(id)
        }
    }

    def upload() {
        // part of the logic should go into the service
        def multiPartFile = params.byteImage
        def contentType = multiPartFile.contentType
        if (checkValidContentType(contentType)) {
            def image = new Image(params)

            Item newItem
            try {
                def item = new Item(
                        name: params.get('name'),
                        image: image,
                        album: Album.findByName(params.get('album').toString()))
                newItem = itemService.save(item)
            } catch (ValidationException e) {
                respond item.errors, view: 'create'
                return
            }
            assert newItem != null

            response.setStatus(HttpServletResponse.SC_CREATED)
            response.setHeader('Location', ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/${newItem.id}")
                    .build()
                    .toUri().toString())
            respond newItem
        } else {
            response.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, 'Server only accepts png and jpeg images')
        }
    }

    private static boolean checkValidContentType(contentType) {
        contentType == 'image/png' || contentType == 'image/jpeg'
    }

}
