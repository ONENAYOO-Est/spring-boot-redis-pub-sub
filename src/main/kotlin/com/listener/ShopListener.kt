package com.listener

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.model.Shop


class ShopListener() {

    private val objectMapper = ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    fun handleMessage(message: String) {
        val obj = objectMapper.readValue(message, Shop::class.java)
        println("Shop received message: $obj")
    }


}