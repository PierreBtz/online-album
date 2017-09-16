package eu.pierrebeitz

import grails.rest.RestfulController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import javax.servlet.http.HttpServletResponse

class ItemController extends RestfulController {

    ItemService itemService

    static responseFormats = ['json']
    static allowedMethods = [upload: "POST"]

    ItemController() {
        super(Item)
    }

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond itemService.list(params), model: [itemCount: itemService.count()]
    }

    def show(Long id) {
        respond itemService.get(id)
    }

    def upload() {
        def multiPartFile = params.byteImage
        def contentType = multiPartFile.contentType
        if (checkValidContentType(contentType)) {
            def image = new Image(params)
            Item newItem = itemService.save(new Item(name: params.get('name'), image: image))

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

    private boolean checkValidContentType(contentType) {
        contentType == 'image/png' || contentType == 'image/jpeg'
    }

}
