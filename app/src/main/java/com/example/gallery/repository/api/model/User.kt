package com.example.gallery.repository.api.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("username") val username: String
)