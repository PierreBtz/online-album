import eu.pierrebeitz.Item
import grails.rest.render.json.JsonRenderer

// Place your Spring DSL code here
beans = {
    ItemJSONRenderer(JsonRenderer, Item) {
        excludes = ['image']
    }
}
