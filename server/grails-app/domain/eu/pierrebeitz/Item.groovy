package eu.pierrebeitz

class Item {

    Album album
    String name
    Image image

    static embedded = ['image']

    static constraints = {
        image nullable: true
        name unique: true
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