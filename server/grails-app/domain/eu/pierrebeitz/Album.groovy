package eu.pierrebeitz

class Album {

    String name

    static hasMany = [items: Item]

    static constraints = {
        name unique: true
    }
}
