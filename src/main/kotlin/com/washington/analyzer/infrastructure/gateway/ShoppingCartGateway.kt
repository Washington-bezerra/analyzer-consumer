package com.washington.analyzer.infrastructure.gateway

import com.washington.analyzer.entities.ItemStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ShoppingCartGateway (
    val shoppingCartClient: ShoppingCartClient
){

    fun putItemStatus(id: Int, status: ItemStatus) {
        shoppingCartClient.putItemStatus(id, status)
    }
}