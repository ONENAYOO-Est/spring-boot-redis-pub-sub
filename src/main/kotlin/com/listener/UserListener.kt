package com.listener

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.model.User
import org.springframework.context.annotation.Configuration


class UserListener() {

    private val objectMapper = ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    fun handleMessage(message: String) {
        val obj = objectMapper.readValue(message, User::class.java)
        println("User received message: $obj")
    }


}