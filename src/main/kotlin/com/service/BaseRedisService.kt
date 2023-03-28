package com.service

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
abstract class BaseRedisService() {

    private val objectMapper = ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    fun RedisTemplate<String, String>.send(channel: String, value: Any) =
        this.convertAndSend(channel, objectMapper.writeValueAsString(value))

}