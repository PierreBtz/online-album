import eu.pierrebeitz.Item
import grails.rest.render.json.JsonCollectionRenderer
import grails.rest.render.json.JsonRenderer

// Place your Spring DSL code here
beans = {
    ItemJSONRenderer(JsonRenderer, Item) {
        excludes = ['image']
    }

    ListItemJSONRenderer(JsonCollectionRenderer, Item) {
        excludes = ['image']
    }
}
