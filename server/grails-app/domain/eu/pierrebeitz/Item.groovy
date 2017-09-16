package eu.pierrebeitz

class Item {

    String name
    Image image

    static embedded = ['image']

    static constraints = {
        name nullable: true
        image nullable: true
    }
}

class Image {
    byte[] byteImage

    static constraints = {
        byteImage maxSize: 1024 * 1024
    }

    static mapping = {
        byteImage column: 'byteImage', sqlType: 'longblob'
    }
}