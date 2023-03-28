package com.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class User(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("birth")
    val birth: Date,
)