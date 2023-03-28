package com.controller

import com.model.Shop
import com.model.User
import com.service.ShopService
import com.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController("/")
class UserController(
    private val userService: UserService,
    private val shopService: ShopService
) {

    @GetMapping("send-user")
    fun sendUser() {
        val user = User(1,"test", Date())
        val shop = Shop("toy-story","nakhon")

        println("send user status"+userService.publish(user))
        println("send shop status"+shopService.publish(shop))
    }
}