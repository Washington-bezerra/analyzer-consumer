package com.washington.analyzer.domain

import com.washington.analyzer.entities.ItemStatus

data class Item(
    val id : Int,
    val name: String,
    val value: Double,
    var status: ItemStatus
)