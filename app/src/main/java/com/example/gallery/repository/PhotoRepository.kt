package com.example.gallery.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.gallery.repository.api.PhotosApi
import com.example.gallery.repository.api.pagination.PhotoPagingSource
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val photosApi: PhotosApi
) {

//    suspend fun getPhotos(): List<PhotoItem>? {
//        return photosApi.getPhotos(1).body()?.map { photoResponseItem ->
//            photoResponseItem.toPhotoItem()
//        }
//    }

    fun getPhotos() = Pager(
        config = PagingConfig(
            pageSize = 20,
            maxSize = 100,
            enablePlaceholders = false
        ),
        pagingSourceFactory = { PhotoPagingSource(photosApi) }
    ).flow
}