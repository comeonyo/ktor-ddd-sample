package com.comeonyo.domain.domain.order

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Order(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Order>(OrderTable)

    // OrderTable의 컬럼에 대응하는 프로퍼티 정의
    var userId by OrderTable.userId
    var productId by OrderTable.productId
}
