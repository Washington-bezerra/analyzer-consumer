package com.washington.analyzer.entities.deserializer

import com.fasterxml.jackson.databind.ObjectMapper
import com.analyzer.event.avro.item.Item as ItemAvro
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Deserializer
import org.slf4j.LoggerFactory
import kotlin.text.Charsets.UTF_8


class ItemDeserializer : Deserializer<ItemAvro> {
    private val objectMapper = ObjectMapper()
    private val log = LoggerFactory.getLogger(javaClass)

    override fun deserialize(topic: String?, data: ByteArray?): ItemAvro? {
        log.info("Deserializing...")
        return objectMapper.readValue(
            String(
                data ?: throw SerializationException("Error when deserializing byte[] to Item"), UTF_8
            ), ItemAvro::class.java
        )
    }

    override fun close() {}

}