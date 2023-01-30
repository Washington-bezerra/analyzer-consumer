package com.washington.analyzer.infra.consumer

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
//import com.washington.analyzer.entities.Item
import org.apache.kafka.clients.consumer.ConsumerRecord
import com.analyzer.event.avro.item.Item as ItemAvro
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class ItemAnalyzer {
    private val logger = LoggerFactory.getLogger(javaClass)

//    @KafkaListener(topics = ["\${kafka.topics.product}"], groupId = "ppr")
//    fun listenGroupFoo(consumerRecord: ConsumerRecord<Any, Any>, ack: Acknowledgment) {
//        logger.info("Message received {}", consumerRecord)
//
//        ack.acknowledge()
//    }

    @KafkaListener(topics = ["\${kafka.topics.product}"], groupId = "ppr")
    fun listenGroupFoo(
        @Payload itemAvro: ItemAvro, ack: Acknowledgment) {
        logger.info("Message received {}", itemAvro)
        println(itemAvro.itemId)
        ack.acknowledge()
    }
}