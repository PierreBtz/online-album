package eu.pierrebeitz

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Transactional
@Service(Item)
interface ItemService {

    Item get(Serializable id)

    List<Item> list(Map args)

    Long count()

    void delete(Serializable id)

    Item save(Item item)

}