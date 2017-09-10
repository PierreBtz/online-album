package eu.pierrebeitz

class Item {

    String name
    byte[] image
    String contentType

    static constraints = {
        image nullable: true
        contentType nullable: true
    }

    static mapping = {
        image column: 'image', sqlType: 'longblob'
    }
}
