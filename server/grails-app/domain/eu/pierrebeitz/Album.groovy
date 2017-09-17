package eu.pierrebeitz

class Album {

    String name
    String description

    static hasMany = [items: Item]

    static constraints = {
        name unique: true
        description nullable: true
    }
}
