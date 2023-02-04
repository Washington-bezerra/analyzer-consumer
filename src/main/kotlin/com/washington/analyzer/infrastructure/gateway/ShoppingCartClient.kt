package com.washington.analyzer.infrastructure.gateway

import com.washington.analyzer.entities.ItemStatus
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping

@FeignClient(
    name = "ShoppingCartGateway",
    url = "http://localhost:8080"
)
interface ShoppingCartClient {
    @PutMapping(
        path = ["/item/{itemId}?status={status}"],
    )
    fun putItemStatus(
        @PathVariable itemId: Int,
        @PathVariable status: ItemStatus
    ): ResponseEntity<*>
}