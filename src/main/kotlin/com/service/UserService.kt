package com.service

import com.model.User
import com.util.RedisKey.USER_TOPIC
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class UserService(
    private val redisTemplate: RedisTemplate<String, String>,
) : BaseRedisService() {


    fun publish(user: User) = redisTemplate.send(USER_TOPIC, user)

}