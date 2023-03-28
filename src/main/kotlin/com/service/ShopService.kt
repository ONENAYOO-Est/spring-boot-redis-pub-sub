package com.service

import com.model.Shop
import com.model.User
import com.util.RedisKey
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service

@Service
class ShopService(
    private val redisTemplate: RedisTemplate<String, String>,
) : BaseRedisService() {

    fun publish(shop: Shop) = redisTemplate.send(RedisKey.SHOP_TOPIC, shop)
}