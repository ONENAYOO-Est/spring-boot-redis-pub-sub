package com.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Shop(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("addr")
    val addr: String,
)