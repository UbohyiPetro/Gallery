package com.example.gallery.repository.api

import com.example.gallery.repository.api.model.PhotoResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface PhotosApi {

    @GET("photos/?client_id=ab3411e4ac868c2646c0ed488dfd919ef612b04c264f3374c97fff98ed253dc9")
    suspend fun getPhotos(): Response<List<PhotoResponseItem>>
}