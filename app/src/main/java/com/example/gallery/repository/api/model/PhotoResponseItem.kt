package com.example.gallery.repository.api.model

import com.example.gallery.ui.model.PhotoItem
import com.google.gson.annotations.SerializedName

data class PhotoResponseItem(
    @SerializedName("description") val description: String?,
    @SerializedName("urls") val urls: Urls,
    @SerializedName("user") val user: User,
)

fun PhotoResponseItem.toPhotoItem(): PhotoItem {
    return PhotoItem(
        username = user.username,
        urls = urls,
        description = description
    )
}