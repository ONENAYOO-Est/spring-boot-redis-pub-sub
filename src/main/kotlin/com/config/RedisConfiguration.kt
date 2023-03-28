package com.config

import com.listener.ShopListener
import com.listener.UserListener
import com.util.RedisKey.SHOP_TOPIC
import com.util.RedisKey.USER_TOPIC
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.ChannelTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter


@Configuration
class RedisConfiguration {

    @Bean
    fun userListenerAdapter(): MessageListenerAdapter {
        return MessageListenerAdapter(UserListener())
    }

    @Bean
    fun shopListenerAdapter(): MessageListenerAdapter {
        return MessageListenerAdapter(ShopListener())
    }

    @Bean
    fun redisContainer(
        connectionFactory: RedisConnectionFactory?,
    ): RedisMessageListenerContainer? {
        val container = RedisMessageListenerContainer()
        container.setConnectionFactory(connectionFactory!!)
        container.addMessageListener(userListenerAdapter(), ChannelTopic(USER_TOPIC))
        container.addMessageListener(shopListenerAdapter(), ChannelTopic(SHOP_TOPIC))
        return container
    }

}