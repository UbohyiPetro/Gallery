package com.example.gallery.ui.model

import com.example.gallery.repository.api.model.Urls

data class PhotoItem(
    val description: String?,
    val username: String,
    val urls: Urls,
)