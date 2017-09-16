package eu.pierrebeitz

class UrlMappings {

    static mappings = {

        "/$controller/$action?/$id?"{
            // apply constraints here
        }

        "/items/$id?" (controller: "item") {
            action = [GET:'show', POST:'upload']
        }

        "/"(view:"/index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
