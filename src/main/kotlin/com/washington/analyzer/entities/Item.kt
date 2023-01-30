package com.washington.analyzer.entities


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import java.io.IOException
import java.time.LocalDateTime


data class Item(

    @JsonProperty("id")
    val id: Int? = null,

    @JsonProperty("name")
    val name: String,

    @JsonProperty("value")
    val value: Double,

    @JsonProperty("status")
    val status: ItemStatus = ItemStatus.PROCESSING,

){
    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    @JsonProperty("createdAt")
    lateinit var  createdAt: LocalDateTime

    @JsonDeserialize(using = LocalDateTimeDeserializer::class)
    @JsonProperty("updatedAt")
    lateinit var updatedAt: LocalDateTime
}