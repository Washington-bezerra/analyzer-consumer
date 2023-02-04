package com.washington.analyzer.infrastructure.consumer

import com.washington.analyzer.entities.ItemStatus
import com.washington.analyzer.infrastructure.gateway.ShoppingCartGateway
import com.analyzer.event.avro.item.Item as ItemAvro
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class ItemAnalyzer (
    val shoppingCartGateway: ShoppingCartGateway
){
    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["\${kafka.topics.product}"], groupId = "ppr")
    fun listenGroupFoo(
        @Payload itemAvro: ItemAvro, ack: Acknowledgment) {
        logger.info("Message received {}", itemAvro)
        logger.info("Try to set ${itemAvro.itemId} as APPROVED")
        shoppingCartGateway.putItemStatus(itemAvro.itemId, ItemStatus.APPROVED)
        ack.acknowledge()
    }
}