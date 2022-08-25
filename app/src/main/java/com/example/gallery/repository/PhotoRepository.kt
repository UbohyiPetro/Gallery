package com.example.gallery.repository

import com.example.gallery.repository.api.PhotosApi
import com.example.gallery.repository.api.model.toPhotoItem
import com.example.gallery.ui.model.PhotoItem
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val photosApi: PhotosApi
) {

    suspend fun getPhotos(): List<PhotoItem>? {
        return photosApi.getPhotos().body()?.map { photoResponseItem ->
            photoResponseItem.toPhotoItem()
        }
    }
}